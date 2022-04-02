package br.com.fiap.jpa.main;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Artista;
import br.com.fiap.jpa.entity.GeneroMusica;

public class ExemploAtualizacao {
	
	public static void main(String[] args) {
		//Obter a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Obter o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um artista com uma PK (Estado detached)
		Artista artista = new Artista(2131, "Eric Johssdfgsdfgnson", LocalDate.of(1965, Month.AUGUST, 10),
				null, GeneroMusica.ROCK, true, true, 120);
		
		//Utilizar o método merge
		Artista copia = em.merge(artista); //Retorna a cópia da entidade gerenciada
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Alterar algum valor do artista
		copia.setNome("Jonh");
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
}