package br.com.fiap.dao;

import br.com.fiap.exception.*;

public interface GenericDao<T, K> {

	void create(T entidade);

	void update(T entidade);
	
	T read(K id) throws IdNotFoundException;

	void delete(K id) throws IdNotFoundException;
	
	void commit() throws CommitException;

}