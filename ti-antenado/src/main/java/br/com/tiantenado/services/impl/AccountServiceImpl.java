package br.com.tiantenado.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.tiantenado.model.Account;
import br.com.tiantenado.repository.AccountRepository;
import br.com.tiantenado.services.AccountService;

@Service
public class AccountServiceImpl extends BasicPersistenceServiceImpl<Account,Long> implements AccountService{

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public JpaRepository<Account, Long> getRepository() {
		return accountRepository;
	}
	

}
