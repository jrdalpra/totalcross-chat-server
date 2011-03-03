package br.com.codejr.chat.seguranca;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.codejr.chat.model.Usuario;

@Component
@SessionScoped
public class Sessao implements Serializable {

	private static final long serialVersionUID = 8100605203173461410L;

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean isLogado() {
		return usuario != null;
	}

	public void loga(Usuario usuario) {
		setUsuario(usuario);
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
