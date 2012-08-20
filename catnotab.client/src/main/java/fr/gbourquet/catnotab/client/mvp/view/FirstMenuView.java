package fr.gbourquet.catnotab.client.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;

import fr.gbourquet.catnotab.client.mvp.presenter.FirstMenuPresenter;

public class FirstMenuView extends Composite implements FirstMenuPresenter.View{

	private static FirstMenuViewUiBinder uiBinder = GWT
			.create(FirstMenuViewUiBinder.class);

	interface FirstMenuViewUiBinder extends UiBinder<Widget, FirstMenuView> {
	}

	@UiField
	ToggleButton menu1;
	@UiField
	ToggleButton menu2;

	public FirstMenuView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public ToggleButton getButtonMenu1() {
		return menu1;
	}

	@Override
	public ToggleButton getButtonMenu2() {
		return menu2;
	}

	
}
