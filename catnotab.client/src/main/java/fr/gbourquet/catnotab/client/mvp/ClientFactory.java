package fr.gbourquet.catnotab.client.mvp;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import fr.gbourquet.catnotab.client.LocalSession;
import fr.gbourquet.catnotab.client.mvp.presenter.AppPresenter;
import fr.gbourquet.catnotab.client.mvp.presenter.FirstMenuPresenter;
import fr.gbourquet.catnotab.client.mvp.presenter.LoginPresenter;

public interface ClientFactory {
    EventBus getEventBus();
    PlaceController getPlaceController();
    DispatchAsync getDistpatcher();
    AppPresenter.View getAppView();
    LoginPresenter.View getLoginView();
	FirstMenuPresenter.View getFirstMenuView();
	LocalSession getLocalSession();
}
