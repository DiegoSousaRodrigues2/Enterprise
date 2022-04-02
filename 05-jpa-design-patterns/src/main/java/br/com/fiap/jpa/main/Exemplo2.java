package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ClienteDao;
import br.com.fiap.jpa.dao.GenericDao;
import br.com.fiap.jpa.dao.impl.GenericDaoImpl;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo2 {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();

		//Obter o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um DAO sem a implementação específica
		//Cria e instancia uma classe anônima
		GenericDao<Cliente, Integer> dao = 
				new GenericDaoImpl<Cliente,Integer>(em) {};
		
		//implementar as ações...
				
		em.close();
		fabrica.close();
	}

}
