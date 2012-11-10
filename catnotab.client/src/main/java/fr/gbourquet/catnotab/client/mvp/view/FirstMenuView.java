package fr.gbourquet.catnotab.client.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;

import fr.gbourquet.catnotab.client.mvp.presenter.FirstMenuPresenter;

public class FirstMenuView extends Composite implements FirstMenuPresenter.View {

	private static FirstMenuViewUiBinder uiBinder = GWT
			.create(FirstMenuViewUiBinder.class);

	interface FirstMenuViewUiBinder extends UiBinder<Widget, FirstMenuView> {
	}

	@UiField
	Panel panel;
	
	ToggleButton[] buttons=new ToggleButton[2];
	SimplePanel[] separators = new SimplePanel[2];
	
	public FirstMenuView() {
		initWidget(uiBinder.createAndBindUi(this));
		
		buttons[0] = new ToggleButton("Tableau de bord");
		separators[0] = new SimplePanel();
		separators[0].addStyleName("nav-divider");
		
		buttons[1] = new ToggleButton("Administration");
		separators[1] = new SimplePanel();
		separators[1].addStyleName("nav-divider");
		
		panel.add(buttons[0]);
		panel.add(separators[0]);
		panel.add(buttons[1]);
		panel.add(separators[1]);
	
	}

	@Override
	public HasValue<Boolean> getButton(int numButton) {
		return buttons[numButton];
	}
	
	@Override
	public void showAuthorizedButtons(boolean[] droits)
	{
		for (int i=0;i<droits.length;i++)
		{
			buttons[i].setVisible(droits[i]);
			separators[i].setVisible(droits[i]);
		}
	}

}
