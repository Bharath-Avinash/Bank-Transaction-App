package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.example.entity.Account;
import com.example.entity.TXN;
import com.example.jpa.LocalEntityManagerFactory;

public class AccountRepository {

	public void save(Account acc) {

		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();

		em.persist(acc);

		em.getTransaction().commit();
		em.close();

	}

	public Account load(int number) {

		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();

		Account acc = em.find(Account.class, number);

		em.getTransaction().commit();
		em.close();
		return acc;

	}

	public void updateAcc(Account account) {

		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();

		em.merge(account);

		em.getTransaction().commit();
		em.close();

	}

	public void removeAccount(int number) {

		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();
		Account acc = em.find(Account.class, number);

		em.remove(acc);

		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Account> getAccount() {
		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();

		List<Account> accounts = em.createQuery("from Account").getResultList();

		em.getTransaction().commit();
		em.close();
		return accounts;
	}
public void createHistory(TXN history) {
		
		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();
		em.persist(history);
		em.getTransaction().commit();
		em.close();
	}

}

