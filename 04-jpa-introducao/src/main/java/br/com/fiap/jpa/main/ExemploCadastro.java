package br.com.fiap.jpa.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Artista;
import br.com.fiap.jpa.entity.GeneroMusica;

public class ExemploCadastro {

	public static void main(String[] args) {
		//Obter uma fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Obter um entity manager
		EntityManager em = fabrica.createEntityManager();

		//Criar um artista sem o código (estado novo)
		Artista artista = new Artista("Michael Jackson", LocalDate.of(1990, 2, 10), 
													null, GeneroMusica.POP, true, true, 80);
		
		//Persist
		em.persist(artista);
		
		//Commit para dar o Insert
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		artista.setNome("Luan");
		
		//Commit para dar o Update
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
}