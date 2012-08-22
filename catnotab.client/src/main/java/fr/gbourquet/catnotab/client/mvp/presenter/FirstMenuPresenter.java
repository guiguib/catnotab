package fr.gbourquet.catnotab.client.mvp.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;

import fr.gbourquet.catnotab.client.event.MenuEvent;
import fr.gbourquet.catnotab.client.mvp.ClientFactory;
import fr.gbourquet.catnotab.client.mvp.place.FirstMenuPlace;

/**
 * Presenter de la vue de login.
 * 
 * @author guillaume
 */
public class FirstMenuPresenter extends AbstractActivity {

	/**
	 * Contrat echange avec la vue.
	 * 
	 * @author guillaume
	 */
	public interface View extends IsWidget {

		/**
		 * Methode d'acces au bouton menu1.
		 * 
		 * @return PushButton le bouton menu1
		 */
		HasValue<Boolean> getButtonMenu1();

		/**
		 * Methode d'acces au bouton menu2.
		 * 
		 * @return PushButton le bouton menu2
		 */
		HasValue<Boolean> getButtonMenu2();

	}

	/**
	 * Dispatcher pour appeler les services.
	 */
	private DispatchAsync dispatcher;
	private PlaceController placeController;
	
	private View view;
	private final EventBus eventBus;
	private boolean binded = false;
	private int numActiveMenu = 1;

	/**
	 * Constructeur.
	 * 
	 * @param display
	 *            Class implementant la vue
	 * @param eventBus
	 *            bus des messages
	 */
	public FirstMenuPresenter(ClientFactory factory) {
		this.dispatcher = factory.getDistpatcher();
		this.view = factory.getFirstMenuView();
		this.eventBus = factory.getEventBus();
		this.placeController = factory.getPlaceController();
	}

	private void bind()
	{
		RootPanel.get("firstMenu").clear();
		RootPanel.get("firstMenu").add(view.asWidget());
		if (!binded)
		{
			// On s'affiche

			view.getButtonMenu1().addValueChangeHandler(new ValueChangeHandler<Boolean>() {

				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {
					// dans le bus
					if (event.getValue())
					{
						setActiveMenu(1);
						placeController. goTo(new FirstMenuPlace(1));
						
						// Si on passe de non enfoncé à enfoncé, on envoit un message
						eventBus.fireEvent(new MenuEvent(view.getButtonMenu1()));
					}
					else
					{
						// Sinon, on le repasse à enfoncé
						view.getButtonMenu1().setValue(true);
					}
				}
			});

			view.getButtonMenu2().addValueChangeHandler(new ValueChangeHandler<Boolean>() {

				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {

					if (event.getValue())
					{
						setActiveMenu(2);
						// on enregistre l'historique
						placeController. goTo(new FirstMenuPlace(2));
						// Si on passe de non enfoncé à enfoncé, on envoit un message
						eventBus.fireEvent(new MenuEvent(view.getButtonMenu2()));
					}
					else
					{
						// Sinon, on le repasse à enfoncé
						view.getButtonMenu2().setValue(true);
					}

				}
			});
			setActiveMenu(1);
			binded = true;
		}
	}
	
	@Override
	public void start(AcceptsOneWidget panel, com.google.gwt.event.shared.EventBus eventBusBidon) {
		panel.setWidget(view);
		bind();
	}

	public void setActiveMenu(int numMenu) {
		this.numActiveMenu = numMenu;
		switch (this.numActiveMenu)
		{
		case 1: 
			view.getButtonMenu1().setValue(true); 
			view.getButtonMenu2().setValue(false); 
			break;
		case 2: 
			view.getButtonMenu1().setValue(false);
			view.getButtonMenu2().setValue(true);
			break;
		default:
			;
		}
	}
	
}
