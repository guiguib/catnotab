package fr.gbourquet.catnotab.client.mvp.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

import fr.gbourquet.catnotab.client.mvp.ClientFactory;
import fr.gbourquet.catnotab.client.mvp.place.LoginPlace;

public abstract class AbstractPresenter implements Activity {

	private ClientFactory factory;
	private EventBus eventBus;
	private PlaceController placeController;

	public AbstractPresenter(ClientFactory factory) {
		this.eventBus = factory.getEventBus();
		this.placeController = factory.getPlaceController();
		this.factory = factory;
	}

	@Override
	public String mayStop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public final void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBus) {
		
		// Si on n'est pas loggué, on affiche la popup
		if (factory.getLocalSession().getAttribute("utilisateur") == null)
			factory.getPlaceController().goTo(new LoginPlace("", ""));

		start();

	}

	public abstract void start();

	public ClientFactory getFactory() {
		return factory;
	}

	public void setFactory(ClientFactory factory) {
		this.factory = factory;
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	public void setEventBus(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	public PlaceController getPlaceController() {
		return placeController;
	}

	public void setPlaceController(PlaceController placeController) {
		this.placeController = placeController;
	}

}
