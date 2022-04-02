package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Artista;

public class ExemploRemocao {
	
	public static void main(String[] args) {
		//Obter uma fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Obter um Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar o artista pela PK
		Artista artista = em.find(Artista.class, 2);
		
		//Remove o artista
		em.remove(artista);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println(artista.getNome());
		
		//Fechar
		em.close();
		fabrica.close();
	}
}