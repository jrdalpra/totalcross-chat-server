package br.com.codejr.chat.repositorio.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import br.com.codejr.chat.model.Mensagem;
import br.com.codejr.chat.model.Usuario;
import br.com.codejr.chat.repositorio.MensagemRepositorio;

@Repository("mensagemRepositorio")
public class MensagemRepositorioImpl extends RepositorioGenerico<Long, Mensagem> implements MensagemRepositorio {

	@Override
	public List<Mensagem> lista(final Usuario de, final Usuario para, final Mensagem ultima) {
		final Mensagem carregada = ultima == null || ultima.getId() == null || ultima.getId().intValue() == 0 ? null
				: carregaPor(ultima.getId());
		return getHibernateTemplate().execute(new HibernateCallback<List<Mensagem>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Mensagem> doInHibernate(Session session) throws HibernateException, SQLException {
				return session.getNamedQuery("Mensagem.dePara").setParameter("de", de).setParameter("para", para)
						.setParameter("ultima", carregada == null ? 0 : carregada.getId()).list();
			}
		});
	}

}