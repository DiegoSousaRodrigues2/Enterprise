package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.jpa.entity.Artista;

public class ExemploPesquisa {
	
	public static void main(String[] args) {
		//Obter uma fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Obter um entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar um artista pela PK
		Artista artista = em.find(Artista.class, 21); //(Classe, PK)
		
		//Exibir o nome do artista
		System.out.println(artista.getNome());
		
		//Alterar o nome do artista
		artista.setNome("Tirulipa");
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
}