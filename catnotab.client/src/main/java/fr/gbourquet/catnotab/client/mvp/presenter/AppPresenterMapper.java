package fr.gbourquet.catnotab.client.mvp.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import fr.gbourquet.catnotab.client.mvp.ClientFactory;
import fr.gbourquet.catnotab.client.mvp.place.AcceuilPlace;
import fr.gbourquet.catnotab.client.mvp.place.LoginPlace;

public class AppPresenterMapper implements ActivityMapper {
    private LoginPresenter loginPresenter;
    private AcceuilPresenter acceuilPresenter;
    
    public AppPresenterMapper(ClientFactory clientFactory) {
        super();
        this.acceuilPresenter = new AcceuilPresenter(clientFactory);
        this.loginPresenter = new LoginPresenter(clientFactory);
    }

    
    
    @Override
    public Activity getActivity(Place place) {
        if (place instanceof LoginPlace)
        {
        	loginPresenter.setLogin(((LoginPlace) place).getLogin());
        	return loginPresenter;
        }
        else if (place instanceof AcceuilPlace)
            return acceuilPresenter;
        return null;
    }
}
