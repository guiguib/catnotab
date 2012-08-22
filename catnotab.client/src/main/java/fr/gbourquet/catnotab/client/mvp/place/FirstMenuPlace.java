package fr.gbourquet.catnotab.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class FirstMenuPlace extends Place {
	private int numMenu;

    public FirstMenuPlace(int numMenu) {
    	this.numMenu = numMenu;
    }

    public int getNumMenu() {
        return this.numMenu;
    }

    public static class Tokenizer implements PlaceTokenizer<FirstMenuPlace> {
        @Override
        public String getToken(FirstMenuPlace place) {
            return place.getNumMenu()+"";
        }

        @Override
        public FirstMenuPlace getPlace(String token) {
            return new FirstMenuPlace(Integer.parseInt(token));
        }
    }
}
