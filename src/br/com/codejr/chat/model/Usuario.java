package br.com.codejr.chat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@NamedQueries({ @NamedQuery(name = "Usuario.comMesmoLoginESenha", query = "select u from Usuario u where u.login = :login and u.senha = :senha") })
public class Usuario implements Identificavel<Long> {

	private static final long serialVersionUID = -8959926939562804051L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "usuarioGenerator")
	@TableGenerator(name = "usuarioGenerator", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(length = 100)
	private String login;

	@Column(length = 20)
	private String senha;

	@Override
	public boolean equals(Object obj) {
		if (obj == null || (!(obj instanceof Usuario))) {
			return false;
		}
		Usuario outro = (Usuario) obj;
		return new EqualsBuilder().append(this.getId(), outro.getId()).isEquals();
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).toHashCode();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
