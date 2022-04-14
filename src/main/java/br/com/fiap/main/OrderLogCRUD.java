package br.com.fiap.main;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.entity.OrderLog;
import br.com.fiap.entity.Status;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class OrderLogCRUD {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		GenericDao<OrderLog, Integer> dao = new GenericDaoImpl<OrderLog, Integer>(em) {
		};

		OrderLog orderLog = new OrderLog(Status.PA,"Pagamento aprovado",LocalDateTime.now(), LocalDateTime.now());

		try {
			dao.create(orderLog);
			dao.commit();

			dao.read(orderLog.getId());

			orderLog.setComentario("Finalizado");
			orderLog.setOrderLog(Status.CO);
			orderLog.setLastUpdate(LocalDateTime.now());
			
			dao.update(orderLog);
			dao.commit();

			dao.delete(orderLog.getId());
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
