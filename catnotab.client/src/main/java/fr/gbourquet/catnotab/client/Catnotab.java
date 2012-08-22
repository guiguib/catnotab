package fr.gbourquet.catnotab.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

import fr.gbourquet.catnotab.client.mvp.ClientFactory;
import fr.gbourquet.catnotab.client.mvp.place.AppPlace;
import fr.gbourquet.catnotab.client.mvp.place.AppPlaceHistoryMapper;
import fr.gbourquet.catnotab.client.mvp.presenter.AppPresenterMapper;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Catnotab implements EntryPoint {
	
	private Place defaultPlace = new AppPlace("");
    
    /**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppPresenterMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(new SimplePanel());

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);
        
        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();
        
        
	}
}
