package com.SunZoo.SunZoo.account.jdbc;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SunZoo.SunZoo.account.Account;

import sunZoo.Animal;

@Repository
public class AccountJdbcRepository {
	//Think about this as a class and method like insert is just like normal method, which can be used at AccountJdbcCommandLineRunner
	//We need to add auto wired, if not, It Cannot invoke
	@Autowired
	private JdbcTemplate accountJdpcTemplate;

	private static String INSERT_QUERY = 
			"""
			INSERT INTO ACCOUNT (account, pwd)
			VALUES
			(?, ?)
			""";
	
	private static String DELETE_QUERY =
			"""
			DELETE FROM ACCOUNT
			WHERE account = ?
			"""
			;
	
	private static String SELECT_QUERY =
			"""
			SELECT * FROM ACCOUNT
			WHERE account = ?
			"""
			;
	
	private static String FIND_ALL_ACCOUNT = 
			"""
					SELECT * FROM ACCOUNT;
					"""
			;
	
	private static String ADD_ANIMAL = 
			"""
					INSERT INTO ANIMAL(animal_type, name, age, health, cage_id)
					VALUES
					(
					? , ? , ? ,?, ?
					)
					;
					"""
			;
	

	public void insert(Account account) {
		accountJdpcTemplate.update(INSERT_QUERY, account.getAccount(), account.getPwd());
	}
	
	public void deleteByAccount(String account) {
		accountJdpcTemplate.update(DELETE_QUERY, account);
	}
	
	public Account findByAccount(String account) {
		//Result set -> Bean =>Row Mapper
		//id
		//In order to parse data into query, we DO NEED set setter for Account class
		
		return accountJdpcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Account.class), account);
	}
	
	public ArrayList<Account> findAllAcc(){
		ArrayList<Account> accounts = new ArrayList<Account>(accountJdpcTemplate.query(FIND_ALL_ACCOUNT, new BeanPropertyRowMapper<Account>(Account.class)));
		return accounts;
	}
	
	public void addAnimal (Animal animal, int cageId) {
		accountJdpcTemplate.update(ADD_ANIMAL, animal.getType(), animal.getName(), animal.getAge(), animal.getHealth(), cageId);
	}
}
