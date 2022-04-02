package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public interface ClienteDao {

	void cadastrar(Cliente cliente);
	
	void atualizar(Cliente cliente);
	
	Cliente buscar(Integer codigo) throws IdNotFoundException;
	
	void deletar(Integer codigo) throws IdNotFoundException;
	
	void commit() throws CommitException;
	
}