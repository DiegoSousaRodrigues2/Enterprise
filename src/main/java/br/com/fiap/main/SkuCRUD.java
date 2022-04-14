package br.com.fiap.main;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.entity.Sku;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class SkuCRUD {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		GenericDao<Sku, Integer> dao = new GenericDaoImpl<Sku, Integer>(em) {
		};

		Sku sku = new Sku("churros", 10.90, LocalDateTime.now(), LocalDateTime.now());

		try {
			dao.create(sku);
			dao.commit();

			dao.read(sku.getId());

			sku.setPrice(15.00);
			sku.setLastUpdate(LocalDateTime.now());

			dao.update(sku);
			dao.commit();

			dao.delete(sku.getId());
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
