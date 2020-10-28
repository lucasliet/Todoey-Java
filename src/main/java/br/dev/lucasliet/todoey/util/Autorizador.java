package br.dev.lucasliet.todoey.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.dev.lucasliet.todoey.model.UserLogin;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent evento) {

		FacesContext context = evento.getFacesContext();
		String pageName = context.getViewRoot().getViewId();

		if ("/login.xhtml".equals(pageName)) {
			return;
		}

		UserLogin loggedUser = (UserLogin) context.getExternalContext()
				.getSessionMap().get("loggedUser");

		if (loggedUser != null) {
			return;
		}

		NavigationHandler handler = context.getApplication()
				.getNavigationHandler();
		handler.handleNavigation(context, null, "/login?faces-redirect=true");
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
