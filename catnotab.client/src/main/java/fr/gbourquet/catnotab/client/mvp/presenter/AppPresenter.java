package fr.gbourquet.catnotab.client.mvp.presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;

import fr.gbourquet.catnotab.client.event.LoginEvent;
import fr.gbourquet.catnotab.client.event.LoginEventHandler;
import fr.gbourquet.catnotab.client.mvp.ClientFactory;
import fr.gbourquet.catnotab.client.mvp.place.FirstMenuPlace;
import fr.gbourquet.catnotab.client.mvp.place.LoginPlace;

public class AppPresenter extends AbstractActivity {

	/*
	 * Contrat echangé avec la vue
	 */
	public interface View extends IsWidget {
		void hello(String nom);
	}

	private View view;
	private ClientFactory factory;
	private EventBus eventBus;
	
	public AppPresenter(ClientFactory factory) {
		this.view = factory.getAppView();
		this.eventBus = factory.getEventBus();
		this.factory = factory;
	}

	@Override
	public void start(AcceptsOneWidget panel, com.google.gwt.event.shared.EventBus eventBusBidon) {
		
		// On s'inscrit aux evenements du Bus
		eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {

			@Override
			public void onLogin(final LoginEvent event) {
				//On s'affiche
				RootPanel.get("contenu").add(view.asWidget() );
				
				//On affiche le menu1
				factory.getPlaceController().goTo(new FirstMenuPlace(1));
			}
		});
		
		factory.getPlaceController().goTo(new LoginPlace("",""));
	}
}