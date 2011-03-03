package br.com.codejr.chat.repositorio;

import java.io.Serializable;
import java.util.List;

import br.com.codejr.chat.model.Identificavel;

public interface Repositorio<TipoDoID extends Serializable, Classe extends Identificavel<TipoDoID>> {

	TipoDoID salva(Classe objeto);

	void atualiza(Classe objeto);

	List<Classe> lista();

	Classe carregaPor(TipoDoID id);

}
