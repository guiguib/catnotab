package fr.gbourquet.catnotab.client.mvp.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.web.bindery.event.shared.EventBus;

import fr.gbourquet.catnotab.client.event.LoginEvent;
import fr.gbourquet.catnotab.client.event.LoginEventHandler;
import fr.gbourquet.catnotab.client.event.MenuEvent;
import fr.gbourquet.catnotab.client.event.MenuEventHandler;
import fr.gbourquet.catnotab.client.mvp.ClientFactory;

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
		ToggleButton getButtonMenu1();

		/**
		 * Methode d'acces au bouton menu2.
		 * 
		 * @return PushButton le bouton menu2
		 */
		ToggleButton getButtonMenu2();

	}

	/**
	 * Dispatcher pour appeler les services.
	 */
	private DispatchAsync dispatcher;

	private View view;
	private final EventBus eventBus;

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
	}

	@Override
	public void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBusBidon) {

		panel.setWidget(view);

		// On s'affiche
		RootPanel.get("firstMenu").add(view.asWidget());

		final ToggleButton button1 = view.getButtonMenu1();
		final ToggleButton button2 = view.getButtonMenu2();
		
	button1.setDown(true);
		
		button1.addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						//Si on passe de non enfoncé à enfoncé, on envoit un message dans le bus
						if (event.getValue())
							eventBus.fireEvent(new MenuEvent(button1));
						else 						//Sinon, on le repasse à enfoncé
							button1.setDown(true);
					}
				});

		button2.addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						
						//Si on passe de non enfoncé à enfoncé, on envoit un message dans le bus
						if (event.getValue())
							eventBus.fireEvent(new MenuEvent(button2));
						else 						//Sinon, on le repasse à enfoncé
							button2.setDown(true);
					

					}
				});

		// On s'inscrit aux evenement du bus pour savoir quel bouton activer
		eventBus.addHandler(MenuEvent.TYPE, new MenuEventHandler() {

			@Override
			public void onMenuClicked(MenuEvent event) {
				
				if (button1 != (ToggleButton) event.getButton()) {
					button1.setDown(!event.getButton().getValue());
				}
				if (button2 != (ToggleButton) event.getButton()) {
					button2.setDown(!event.getButton().getValue());
				}

			}
		});
	}

}
