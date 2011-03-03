package br.com.codejr.chat.model;

import java.io.Serializable;

public interface Identificavel<TipoDoID extends Serializable> extends Serializable {

	TipoDoID getId();

}
