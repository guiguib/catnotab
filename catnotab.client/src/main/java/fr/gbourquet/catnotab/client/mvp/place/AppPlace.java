package fr.gbourquet.catnotab.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AppPlace extends Place {
    private String helloName;

    public AppPlace(String token) {
        this.helloName = token;
    }

    public String getHelloName() {
        return helloName;
    }

    public static class Tokenizer implements PlaceTokenizer<AppPlace> {
        @Override
        public String getToken(AppPlace place) {
            return place.getHelloName();
        }

        @Override
        public AppPlace getPlace(String token) {
            return new AppPlace(token);
        }
    }
}
