package fr.gbourquet.catnotab.client.mvp.presenter;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;

import fr.gbourquet.catnotab.client.event.LoginEvent;
import fr.gbourquet.catnotab.client.event.LoginEventHandler;
import fr.gbourquet.catnotab.client.mvp.ClientFactory;
import fr.gbourquet.catnotab.client.mvp.place.FirstMenuPlace;

public class AppPresenter extends AbstractPresenter {

	/*
	 * Contrat echangé avec la vue
	 */
	public interface View extends IsWidget {
		void hello(String nom);
	}

	public View view;

	public AppPresenter(ClientFactory factory) {
		super(factory);
		view = factory.getAppView();
		bind();
	}

	public void bind() {
		// On s'inscrit aux evenements du Bus
		getEventBus().addHandler(LoginEvent.TYPE, new LoginEventHandler() {

			@Override
			public void onLogin(final LoginEvent event) {

				// On s'affiche
				RootPanel.get("contenu").add(getView().asWidget());

				// On affiche le menu1
				getFactory().getPlaceController().goTo(new FirstMenuPlace(FirstMenuPresenter.ACCEUIL));
			}
		});

	}

	@Override
	public void start() {

	}

	public View getView() {
		return view;
	}
}