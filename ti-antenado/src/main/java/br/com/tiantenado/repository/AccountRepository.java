package br.com.tiantenado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tiantenado.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	
}
