package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.*;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public abstract class GenericDaoImpl<T, K> implements GenericDao<T, K> {

	private EntityManager em;

	private Class<T> clazz;// armazena o .class da entidade

	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void create(T entidade) {
		em.persist(entidade);
	}

	public void update(T entidade) {
		em.merge(entidade);
	}

	public T read(K id) throws IdNotFoundException {
		T entidade = em.find(clazz, id);
		if (entidade == null)
			throw new IdNotFoundException();
		return entidade;
	}

	public void delete(K id) throws IdNotFoundException {
		em.remove(read(id));
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}
