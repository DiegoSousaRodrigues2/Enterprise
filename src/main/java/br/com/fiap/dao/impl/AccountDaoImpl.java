package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.dao.AccountDao;
import br.com.fiap.entity.Account;

public class AccountDaoImpl extends GenericDaoImpl<Account, Integer> implements AccountDao{

	public AccountDaoImpl(EntityManager em) {
		super(em);
	}

}
