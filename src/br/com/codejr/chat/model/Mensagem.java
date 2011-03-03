package br.com.codejr.chat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

@Entity
@NamedQueries({ @NamedQuery(name = "Mensagem.dePara", query = "select m from Mensagem m where m.de = :de and m.para = :para and m.id > :ultima") })
public class Mensagem implements Identificavel<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6919293657800916074L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "mensagemGenerator")
	@TableGenerator(name = "mensagemGenerator", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idUsuarioOrigem")
	private Usuario de;

	@ManyToOne
	@JoinColumn(name = "idUsuarioDestino")
	private Usuario para;

	private String texto;

	public Usuario getDe() {
		return de;
	}

	public Long getId() {
		return id;
	}

	public Usuario getPara() {
		return para;
	}

	public String getTexto() {
		return texto;
	}

	public void setDe(Usuario de) {
		this.de = de;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPara(Usuario para) {
		this.para = para;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
