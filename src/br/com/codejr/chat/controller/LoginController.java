package br.com.codejr.chat.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.RequestInfo;
import br.com.caelum.vraptor.view.Results;
import br.com.codejr.chat.model.Usuario;
import br.com.codejr.chat.repositorio.UsuarioRepositorio;
import br.com.codejr.chat.seguranca.Sessao;

@Resource
@Path("/login")
public class LoginController {

	private final Result resultado;
	private final Sessao sessao;
	private final RequestInfo info;
	private final UsuarioRepositorio repositorio;

	public LoginController(	Result resultado,
							Sessao sessao,
							RequestInfo info,
							UsuarioRepositorio repositorio) {
		this.resultado = resultado;
		this.sessao = sessao;
		this.info = info;
		this.repositorio = repositorio;
	}

	@Path("/autentica/tc")
	public void autenticaQuandoVemDoTotalCross(Usuario usuario) {
		if (!autenticou(usuario)) {
			resultado.use(Results.status()).notFound();
			return;
		}
		resultado.include("usuario", sessao.getUsuario());
		resultado.include("jsessionid", jsessionid());
	}

	private boolean autenticou(Usuario usuario) {
		sessao.setUsuario(repositorio.carregaComMesmoLoginESenhaQue(usuario));
		return sessao.isLogado();
	}

	private String jsessionid() {
		return info.getRequest().getSession().getId();
	}

}
