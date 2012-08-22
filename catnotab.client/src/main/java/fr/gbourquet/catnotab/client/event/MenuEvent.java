package fr.gbourquet.catnotab.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ToggleButton;

public class MenuEvent extends GwtEvent<MenuEventHandler> {
	
	public static Type<MenuEventHandler> TYPE = new Type<MenuEventHandler>();

	private HasValue<Boolean> button;
	
	public MenuEvent(HasValue<Boolean> button)
	{
		this.button = button;
	}
	
	@Override
	public Type<MenuEventHandler> getAssociatedType() {
		return TYPE;
	}


	@Override
	protected void dispatch(MenuEventHandler handler) {
		handler.onMenuClicked(this);
	}
	
	public HasValue<Boolean> getButton()
	{
		return button;		
	}
	
	public void setButton(ToggleButton button)
	{
		this.button = button;
	}

}
