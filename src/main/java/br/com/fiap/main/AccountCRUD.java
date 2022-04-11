package br.com.fiap.main;

import java.time.LocalDateTime;
import javax.persistence.*;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.entity.Account;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class AccountCRUD {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		GenericDao<Account, Integer> dao = new GenericDaoImpl<Account, Integer>(em) {
		};

		Account account = new Account("Diego", 16, "176.571.330-74", LocalDateTime.now(), LocalDateTime.now());

		try {
			dao.create(account);
			dao.commit();

			dao.read(1);

			dao.update(new Account("Felipe", 16, "10", account.getDateCreated(), LocalDateTime.now()));
			dao.commit();

			dao.delete(1);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}

		finally {
			em.close();
			fabrica.close();
		}

	}
}
