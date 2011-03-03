package br.com.codejr.chat.repositorio;

import java.util.List;

import br.com.codejr.chat.model.Mensagem;
import br.com.codejr.chat.model.Usuario;

public interface MensagemRepositorio extends Repositorio<Long, Mensagem> {

	List<Mensagem> lista(Usuario de, Usuario para, Mensagem ultima);

}
