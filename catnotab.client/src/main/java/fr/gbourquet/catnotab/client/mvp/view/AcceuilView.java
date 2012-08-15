package fr.gbourquet.catnotab.client.mvp.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import fr.gbourquet.catnotab.client.mvp.presenter.AcceuilPresenter;

public class AcceuilView extends Composite implements AcceuilPresenter.View {
	
	Label hello;
	public AcceuilView() {
		hello = new Label();
		VerticalPanel panel = new VerticalPanel();
		initWidget( panel );

		panel.add(new Label("Application demarree"));
		panel.add(hello);
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void hello(String nom) {
		this.hello.setText("Bonjour "+nom);
		
	}
}
