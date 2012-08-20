package fr.gbourquet.catnotab.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface MenuEventHandler extends EventHandler {

	void onMenuClicked(MenuEvent event);
}
