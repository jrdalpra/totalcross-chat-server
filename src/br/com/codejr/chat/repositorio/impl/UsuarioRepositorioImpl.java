package br.com.codejr.chat.repositorio.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import br.com.codejr.chat.model.Usuario;
import br.com.codejr.chat.repositorio.UsuarioRepositorio;

@Repository("usuarioRepositorio")
public class UsuarioRepositorioImpl extends RepositorioGenerico<Long, Usuario> implements UsuarioRepositorio {

	@Override
	public Usuario carregaComMesmoLoginESenhaQue(final Usuario outro) {

		if (outro == null || outro.getLogin() == null || outro.getSenha() == null) {
			return null;
		}

		return getHibernateTemplate().execute(new HibernateCallback<Usuario>() {
			@Override
			public Usuario doInHibernate(Session session) throws HibernateException, SQLException {
				return (Usuario) session.getNamedQuery("Usuario.comMesmoLoginESenha").setString("login", outro.getLogin())
						.setString("senha", outro.getSenha()).uniqueResult();
			}
		});
	}

}
