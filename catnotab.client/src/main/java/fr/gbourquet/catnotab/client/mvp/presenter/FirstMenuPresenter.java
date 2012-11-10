package fr.gbourquet.catnotab.client.mvp.presenter;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;

import fr.gbourquet.catnotab.client.event.MenuEvent;
import fr.gbourquet.catnotab.client.mvp.ClientFactory;
import fr.gbourquet.catnotab.client.mvp.place.FirstMenuPlace;

/**
 * Presenter de la vue de login.
 * 
 * @author guillaume
 */
public class FirstMenuPresenter extends AbstractPresenter {

	public static final int ACCEUIL          = 0;
	public static final int ADMINISTRATION   = 1;

	/**
	 * Contrat echange avec la vue.
	 * 
	 * @author guillaume
	 */
	public interface View extends IsWidget {

		/**
		 * Methode d'acces aux boutons du menu.
		 * 
		 * @return PushButton le bouton
		 */
		HasValue<Boolean> getButton(int numButton);

		void showAuthorizedButtons(boolean[] droits);

	}

	public View view;
	/**
	 * Dispatcher pour appeler les services.
	 */
	/* private DispatchAsync dispatcher; */

	private int numActiveMenu = 0;

	/**
	 * Constructeur.
	 * 
	 * @param display
	 *           Class implementant la vue
	 * @param eventBus
	 *           bus des messages
	 */
	public FirstMenuPresenter(ClientFactory factory) {
		super(factory);
		this.view = factory.getFirstMenuView();
		/* this.dispatcher = factory.getDistpatcher(); */
		bind();
	}

	private void bind() {
		getView().getButton(ACCEUIL).addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				if (event.getValue()) {
					setActiveMenuButton(ACCEUIL);
					getPlaceController().goTo(new FirstMenuPlace(ACCEUIL));
					
					// Si on passe de non enfoncé à enfoncé, on
					// envoit un message
					getEventBus().fireEvent(new MenuEvent(getView().getButton(ACCEUIL)));
				} else {
					// Sinon, on le repasse à enfoncé
					getView().getButton(ACCEUIL).setValue(true);
				}
			}
		});

		getView().getButton(ADMINISTRATION).addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				if (event.getValue()) {
					setActiveMenuButton(ADMINISTRATION);
					getPlaceController().goTo(new FirstMenuPlace(ADMINISTRATION));
					
					// Si on passe de non enfoncé à enfoncé, on
					// envoit un message
					getEventBus().fireEvent(new MenuEvent(getView().getButton(ADMINISTRATION)));
				} else {
					// Sinon, on le repasse à enfoncé
					getView().getButton(ADMINISTRATION).setValue(true);
				}
			}
		});

	}

	@Override
	public void start() {
		RootPanel.get("firstMenu").clear();
		RootPanel.get("firstMenu").add(getView().asWidget());
		boolean[] authorizations = { true, false };
		view.showAuthorizedButtons(authorizations);
	}

	public void setActiveMenuButton(int numMenu) {
		this.numActiveMenu = numMenu;
		switch (this.numActiveMenu) {
		case ACCEUIL:
			getView().getButton(ACCEUIL).setValue(true);
			getView().getButton(ADMINISTRATION).setValue(false);
			break;
		case ADMINISTRATION:
			getView().getButton(ACCEUIL).setValue(false);
			getView().getButton(ADMINISTRATION).setValue(true);
			break;
		default:
			;
		}
	}

	public View getView() {
		return view;
	}

}
