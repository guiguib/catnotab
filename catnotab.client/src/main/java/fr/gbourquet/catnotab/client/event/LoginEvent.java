package fr.gbourquet.catnotab.client.event;

import com.google.gwt.event.shared.GwtEvent;

import fr.gbourquet.catnotab.serveur.metier.Personne;


public class LoginEvent extends GwtEvent<LoginEventHandler> {
public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();
	
	private final Personne utilisateur;
	
	public LoginEvent(final Personne utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Personne getUtilisateur() {
		return utilisateur;
	}
	
	@Override
	public Type<LoginEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final LoginEventHandler handler) {
		handler.onLogin(this);
	}
}
