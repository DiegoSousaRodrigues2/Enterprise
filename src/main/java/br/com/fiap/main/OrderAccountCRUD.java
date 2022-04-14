package br.com.fiap.main;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.entity.OrderAccount;
import br.com.fiap.entity.Status;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class OrderAccountCRUD {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		GenericDao<OrderAccount, Integer> dao = new GenericDaoImpl<OrderAccount, Integer>(em) {
		};

		OrderAccount orderAccount = new OrderAccount(1,15, Status.SH, LocalDateTime.now(), LocalDateTime.now());

		try {
			dao.create(orderAccount);
			dao.commit();

			dao.read(orderAccount.getId());

			orderAccount.setStatus(Status.CO);
			orderAccount.setLastUpdate(LocalDateTime.now());
			
			dao.update(orderAccount);
			dao.commit();

			dao.delete(orderAccount.getId());
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
