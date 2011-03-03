package br.com.codejr.chat.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.codejr.chat.model.Usuario;
import br.com.codejr.chat.repositorio.UsuarioRepositorio;
import br.com.codejr.chat.seguranca.Sessao;

@Resource
@Path("/usuario")
public class UsuarioController {

	private final Result resultado;
	private final UsuarioRepositorio repositorio;
	private final Sessao sessao;

	public UsuarioController(	Result resultado,
								Sessao sessao,
								UsuarioRepositorio repositorio) {
		this.resultado = resultado;
		this.sessao = sessao;
		this.repositorio = repositorio;
	}

	public void atualiza(Usuario usuario) {
		repositorio.atualiza(usuario);
		resultado.redirectTo(this).lista();
	}

	@Path("/edita/{id}")
	public void edita(Long id) {
		resultado.forwardTo(this).formulario("atualiza", repositorio.carregaPor(id));
	}

	public Usuario formulario(String acao, Usuario usuario) {
		resultado.include("acao", acao);
		return usuario;
	}

	public List<Usuario> lista() {
		return repositorio.lista();
	}

	@Path("/lista/tc")
	public List<Usuario> listaParaOTotalCross() {
		if (!sessao.isLogado()) {
			resultado.use(Results.status()).notFound();
			return null;
		}
		List<Usuario> lista = repositorio.lista();
		lista.remove(sessao.getUsuario());
		resultado.include("tamanho", lista.size());
		return lista;
	}

	public void novo(Usuario usuario) {
		resultado.forwardTo(this).formulario("salva", usuario);
	}

	public void salva(Usuario usuario) {
		repositorio.salva(usuario);
		resultado.redirectTo(this).lista();
	}

	@Path("/salva/tc")
	public void salvaQuandoVemDoTotalCross(Usuario usuario) {
		repositorio.salva(usuario);
		resultado.use(Results.status()).ok();
	}

}
