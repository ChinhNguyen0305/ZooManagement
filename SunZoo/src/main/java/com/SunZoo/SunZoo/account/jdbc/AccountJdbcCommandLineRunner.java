package com.SunZoo.SunZoo.account.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.SunZoo.SunZoo.account.Account;

@Component
public class AccountJdbcCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private AccountJdbcRepository repository;

	@Override
	public void run(String... args) throws Exception {
		//Test insert query
		repository.insertAccount(new Account("theSun", "theSun"));
		
	}

}
