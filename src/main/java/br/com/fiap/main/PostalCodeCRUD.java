package br.com.fiap.main;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.entity.PostalCode;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class PostalCodeCRUD {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		GenericDao<PostalCode, Integer> dao = new GenericDaoImpl<PostalCode, Integer>(em) {
		};

		PostalCode postalCode = new PostalCode("03433025", "rua", LocalDateTime.now(), LocalDateTime.now());

		try {
			dao.create(postalCode);
			dao.commit();

			dao.read(1);

			dao.update(new PostalCode(postalCode.getZipCode(), "rua b", postalCode.getDateCreated(), LocalDateTime.now()));
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
