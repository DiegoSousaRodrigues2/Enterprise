package br.com.fiap.main;

import java.time.LocalDateTime;
import javax.persistence.*;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.entity.Account;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class AccountCRUD {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		GenericDao<Account, Integer> dao = new GenericDaoImpl<Account, Integer>(em) {
		};

		try {
			dao.create(new Account("Diego", 16, "176.571.330-74", LocalDateTime.now(), LocalDateTime.now()));
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
			fabrica.close();
		}
		
	}
}
