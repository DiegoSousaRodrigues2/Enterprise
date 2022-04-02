package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ProdutoDao;
import br.com.fiap.jpa.dao.impl.ProdutoDaoImpl;
import br.com.fiap.jpa.entity.Produto;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo {

	//Testar o ProdutoDao
	public static void main(String[] args) {
		//Obter uma fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();

		//Obter o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o ProdutoDaoImpl
		ProdutoDao dao = new ProdutoDaoImpl(em);
		
		//Instanciar um produto sem o código
		Produto produto = new Produto("Churros"); //Criar o construtor..
		
		try {
			//Cadastrar um produto
			dao.cadastrar(produto);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Pesquisar um produto
			Produto busca = dao.buscar(1);
			System.out.println(busca.getNome());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Atualizar um produto
			produto.setNome("Pastel");
			dao.atualizar(produto);
			dao.commit();
		}catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Remover um produto
			dao.deletar(1);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
		em.close();
		fabrica.close();
	}
}