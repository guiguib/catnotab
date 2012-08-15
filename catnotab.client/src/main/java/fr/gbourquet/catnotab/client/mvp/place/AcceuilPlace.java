package fr.gbourquet.catnotab.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AcceuilPlace extends Place {
    private String helloName;

    public AcceuilPlace(String token) {
        this.helloName = token;
    }

    public String getHelloName() {
        return helloName;
    }

    public static class Tokenizer implements PlaceTokenizer<AcceuilPlace> {
        @Override
        public String getToken(AcceuilPlace place) {
            return place.getHelloName();
        }

        @Override
        public AcceuilPlace getPlace(String token) {
            return new AcceuilPlace(token);
        }
    }
}
