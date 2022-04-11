package br.com.fiap.singleton;

import javax.persistence.*;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory fabrica;

	private EntityManagerFactorySingleton() {
	}

	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}

}
