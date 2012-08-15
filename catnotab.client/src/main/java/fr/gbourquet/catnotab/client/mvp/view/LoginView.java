package fr.gbourquet.catnotab.client.mvp.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import fr.gbourquet.catnotab.client.mvp.presenter.LoginPresenter;

public class LoginView extends DialogBox implements LoginPresenter.View {
	private TextBox id;
	private TextBox passwd;
    private Button login;
    private Label error;
    
	public LoginView() {

        setTitle("Login");
        setText("Login");
        setAnimationEnabled(true);
        setPopupPosition(50, 50);
        VerticalPanel panel = new VerticalPanel();
        setWidget(panel);
		
        error = new Label("");
		panel.add(error);
        
        Grid grille = new Grid(2,2);
        panel.add(grille);
        
		setSize("500px", "200px");
        setModal(true);
    
        id = new TextBox();
        grille.setWidget(0, 0, new Label("Identifiant :"));
        grille.setWidget(0, 1, id);
        
        passwd = new TextBox();
        grille.setWidget(1, 0, new Label("Mot de passe :"));
        grille.setWidget(1, 1, passwd);
        
        login = new Button("Login");
        panel.add(login);
    }

	@Override
    public void show() {
        super.show();
    }

	@Override
    public void hide() {
        super.hide();
    }

    @Override
    public Widget asWidget() {
        // TODO Auto-generated method stub
        return this;
    }

    @Override
    public String getPasswd() {
        // TODO Auto-generated method stub
        return passwd.getText();
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return id.getText();
    }

    @Override
    public void setId(String id) {
        this.id.setValue(id);
    }

    @Override
    public void setPasswd(String passwd) {
        this.passwd.setValue(passwd);
    }

	@Override
	public Button getLogin() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public void errorLogin() {
		this.error.setText("Erreur de connexion");
		
	}

}
