package fr.gbourquet.catnotab.client.mvp.presenter;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;

import fr.gbourquet.catnotab.client.event.MenuEvent;
import fr.gbourquet.catnotab.client.mvp.ClientFactory;
import fr.gbourquet.catnotab.client.mvp.place.FirstMenuPlace;

/**
 * Presenter de la vue de login.
 * 
 * @author guillaume
 */
public class FirstMenuPresenter extends AbstractPresenter {

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

	public View view;
	/**
	 * Dispatcher pour appeler les services.
	 */
	/*private DispatchAsync dispatcher;*/
	
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
	super(factory);
	this.view = factory.getFirstMenuView();
	/*this.dispatcher = factory.getDistpatcher();*/
	
	}

	private void bind()
	{
		RootPanel.get("firstMenu").clear();
		RootPanel.get("firstMenu").add(getView().asWidget());
		if (!binded)
		{
			// On s'affiche

			getView().getButtonMenu1().addValueChangeHandler(new ValueChangeHandler<Boolean>() {

				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {
					// dans le bus
					if (event.getValue())
					{
						setActiveMenu(1);
						getPlaceController().goTo(new FirstMenuPlace(1));
						
						// Si on passe de non enfoncé à enfoncé, on envoit un message
						getEventBus().fireEvent(new MenuEvent(getView().getButtonMenu1()));
					}
					else
					{
						// Sinon, on le repasse à enfoncé
						getView().getButtonMenu1().setValue(true);
					}
				}
			});

			getView().getButtonMenu2().addValueChangeHandler(new ValueChangeHandler<Boolean>() {

				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {

					if (event.getValue())
					{
						setActiveMenu(2);
						// on enregistre l'historique
						getPlaceController().goTo(new FirstMenuPlace(2));
						// Si on passe de non enfoncé à enfoncé, on envoit un message
						getEventBus().fireEvent(new MenuEvent(getView().getButtonMenu2()));
					}
					else
					{
						// Sinon, on le repasse à enfoncé
						getView().getButtonMenu2().setValue(true);
					}

				}
			});
			setActiveMenu(1);
			binded = true;
		}
	}
	
	@Override
	public void start() {
		bind();
	}

	public void setActiveMenu(int numMenu) {
		this.numActiveMenu = numMenu;
		switch (this.numActiveMenu)
		{
		case 1: 
			getView().getButtonMenu1().setValue(true); 
			getView().getButtonMenu2().setValue(false); 
			break;
		case 2: 
			getView().getButtonMenu1().setValue(false);
			getView().getButtonMenu2().setValue(true);
			break;
		default:
			;
		}
	}
	
	public View getView()
	{
		return view;
	}
	
}
