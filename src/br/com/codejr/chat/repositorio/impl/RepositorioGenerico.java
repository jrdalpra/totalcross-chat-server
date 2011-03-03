package br.com.codejr.chat.repositorio.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import br.com.codejr.chat.model.Identificavel;
import br.com.codejr.chat.repositorio.Repositorio;

@Transactional(readOnly = true)
public class RepositorioGenerico<TipoDoID extends Serializable, Classe extends Identificavel<TipoDoID>> extends
		HibernateDaoSupport implements Repositorio<TipoDoID, Classe> {

	private final Class<Classe> clazz;

	@SuppressWarnings("unchecked")
	public RepositorioGenerico() {
		Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
		this.clazz = (Class<Classe>) types[1];
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public TipoDoID salva(Classe objeto) {
		return (TipoDoID) getHibernateTemplate().save(objeto);
	}

	@Override
	@Transactional(readOnly = false)
	public void atualiza(Classe objeto) {
		getHibernateTemplate().update(objeto);
	}

	@Autowired
	public void setFactory(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public List<Classe> lista() {
		return getHibernateTemplate().execute(new HibernateCallback<List<Classe>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Classe> doInHibernate(Session arg0) throws HibernateException, SQLException {
				return arg0.createCriteria(clazz).list();
			}
		});
	}

	@Override
	public Classe carregaPor(TipoDoID id) {
		return getHibernateTemplate().load(clazz, id);
	}

}
