package fr.gbourquet.catnotab.client.mvp.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import fr.gbourquet.catnotab.client.mvp.ClientFactory;
import fr.gbourquet.catnotab.client.mvp.place.AppPlace;
import fr.gbourquet.catnotab.client.mvp.place.FirstMenuPlace;
import fr.gbourquet.catnotab.client.mvp.place.LoginPlace;

public class AppPresenterMapper implements ActivityMapper {
    private LoginPresenter loginPresenter;
    private AppPresenter appPresenter;
    private FirstMenuPresenter firstMenuPresenter;
    
    public AppPresenterMapper(ClientFactory clientFactory) {
        super();
        this.appPresenter = new AppPresenter(clientFactory);
        this.loginPresenter = new LoginPresenter(clientFactory);
        this.firstMenuPresenter = new FirstMenuPresenter(clientFactory);
        }

    
    
    @Override
    public Activity getActivity(Place place) {
        if (place instanceof LoginPlace)
        {
        	loginPresenter.setLogin(((LoginPlace) place).getLogin());
        	return loginPresenter;
        }
        else if (place instanceof AppPlace)
        {
        	return appPresenter;
        }
        else if (place instanceof FirstMenuPlace)
        {
        	firstMenuPresenter.setActiveMenuButton(((FirstMenuPlace) place).getNumMenu());
        	return firstMenuPresenter;
        }
        return null;
    }
}
