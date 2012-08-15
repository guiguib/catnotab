package fr.gbourquet.catnotab.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LoginPlace extends Place {
	private String login;
	private String passwd;

    public LoginPlace(String login, String passwd) {
    	this.login = login;
    	this.passwd = passwd;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }

    public static class Tokenizer implements PlaceTokenizer<LoginPlace> {
        @Override
        public String getToken(LoginPlace place) {
            return place.getLogin();
        }

        @Override
        public LoginPlace getPlace(String token) {
            return new LoginPlace(token,"");
        }
    }
}
