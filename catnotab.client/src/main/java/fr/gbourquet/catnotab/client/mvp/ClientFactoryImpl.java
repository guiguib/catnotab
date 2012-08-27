package fr.gbourquet.catnotab.client.mvp;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import fr.gbourquet.catnotab.client.LocalSession;
import fr.gbourquet.catnotab.client.mvp.presenter.AppPresenter;
import fr.gbourquet.catnotab.client.mvp.presenter.FirstMenuPresenter;
import fr.gbourquet.catnotab.client.mvp.presenter.FirstMenuPresenter.View;
import fr.gbourquet.catnotab.client.mvp.presenter.LoginPresenter;
import fr.gbourquet.catnotab.client.mvp.view.AppView;
import fr.gbourquet.catnotab.client.mvp.view.FirstMenuView;
import fr.gbourquet.catnotab.client.mvp.view.LoginView;

public class ClientFactoryImpl implements ClientFactory {
    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    private final AppPresenter.View appView = new AppView();
    private final LoginPresenter.View loginView = new LoginView();
    private final FirstMenuPresenter.View firstMenuView = new FirstMenuView();
    private final DispatchAsync dispatcher = new StandardDispatchAsync(new DefaultExceptionHandler());

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public AppPresenter.View getAppView() {
		return appView;
	}

	@Override
	public LoginPresenter.View getLoginView() {
		return loginView;
	}

	@Override
	public DispatchAsync getDistpatcher() {
		return dispatcher;
	}

	@Override
	public View getFirstMenuView() {
		return firstMenuView;
	}

	@Override
	public LocalSession getLocalSession() {
		return LocalSession.getInstance();
	}

	    
}
