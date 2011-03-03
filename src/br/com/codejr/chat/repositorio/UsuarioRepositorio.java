package br.com.codejr.chat.repositorio;

import br.com.codejr.chat.model.Usuario;

public interface UsuarioRepositorio extends Repositorio<Long, Usuario> {

	Usuario carregaComMesmoLoginESenhaQue(Usuario outro);

}
