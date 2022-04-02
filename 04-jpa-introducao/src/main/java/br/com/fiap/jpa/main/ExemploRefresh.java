package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Artista;

//Atualiza o objeto Java com os dados do banco
public class ExemploRefresh {

	public static void main(String[] args) {
		//1-Obter a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//2-Obter o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//3-Pesquisar o artista pela PK
		Artista artista = em.find(Artista.class, 1);
		
		//4-Exibir o nome do artista
		System.out.println(artista.getNome()); //banco
		
		//5-Alterar no objeto o nome do artista
		artista.setNome("Marilia");
		
		//6-Exibir o nome do artista
		System.out.println(artista.getNome()); //objeto
		
		//7-Chamar o método refresh
		em.refresh(artista);
		
		//8-Exibir o nome do artista
		System.out.println(artista.getNome()); //banco
		
		//9-Fechar
		em.close();
		fabrica.close();
	}
}