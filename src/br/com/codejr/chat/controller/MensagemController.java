package br.com.codejr.chat.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.codejr.chat.model.Mensagem;
import br.com.codejr.chat.model.Usuario;
import br.com.codejr.chat.repositorio.MensagemRepositorio;
import br.com.codejr.chat.repositorio.UsuarioRepositorio;
import br.com.codejr.chat.seguranca.Sessao;

@Resource
@Path("/mensagem")
public class MensagemController {

	private final Result resultado;
	private final Sessao sessao;
	private final MensagemRepositorio repositorio;
	private final UsuarioRepositorio repositorioDeUsuarios;

	public MensagemController(	Result resultado,
								Sessao sessao,
								MensagemRepositorio repositorio,
								UsuarioRepositorio repositorioDeUsuarios) {
		this.resultado = resultado;
		this.sessao = sessao;
		this.repositorio = repositorio;
		this.repositorioDeUsuarios = repositorioDeUsuarios;
	}

	@Path("/lista/tc/{ultima.id}")
	public List<Mensagem> listaParaOTotalCross(Usuario de, Mensagem ultima) {

		if (!sessao.isLogado() || de == null) {
			resultado.use(Results.status()).notFound();
			return null;
		}

		List<Mensagem> lista = repositorio.lista(repositorioDeUsuarios.carregaPor(de.getId()), sessao.getUsuario(), ultima);
		if (lista != null) {
			resultado.include("tamanho", lista.size());
		}
		return lista;
	}

	@Path("/nova/tc")
	public void novaQueVemDoTotalCross(Mensagem mensagem) {
		mensagem.setDe(repositorioDeUsuarios.carregaPor(mensagem.getDe().getId()));
		mensagem.setPara(repositorioDeUsuarios.carregaPor(mensagem.getPara().getId()));
		repositorio.salva(mensagem);
		resultado.use(Results.status()).ok();
	}
}
