package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ProdutoDao;
import br.com.fiap.jpa.entity.Produto;

public class ProdutoDaoImpl 
				extends GenericDaoImpl<Produto, Integer> 
											implements ProdutoDao {

	public ProdutoDaoImpl(EntityManager em) {
		super(em);
	}

}