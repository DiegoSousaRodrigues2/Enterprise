package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ClienteDao;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class ClienteDaoImpl implements ClienteDao {
	
	private EntityManager em;
	
	public ClienteDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Cliente cliente) {
		em.persist(cliente);
	}

	public void atualizar(Cliente cliente) {
		em.merge(cliente);
	}

	public Cliente buscar(Integer codigo) throws IdNotFoundException {
		Cliente cliente = em.find(Cliente.class, codigo); 
		//Validar se o cliente existe, se não existir lançar exception
		if (cliente == null)
			throw new IdNotFoundException();
		return cliente; 
	}

	public void deletar(Integer codigo) throws IdNotFoundException {
		Cliente cliente = buscar(codigo);
		em.remove(cliente);
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



