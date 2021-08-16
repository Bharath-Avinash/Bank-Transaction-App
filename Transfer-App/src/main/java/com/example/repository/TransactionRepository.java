package com.example.repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.entity.Account;
import com.example.entity.TXN;
import com.example.jpa.LocalEntityManagerFactory;

public class TransactionRepository {

	public void save(TXN transaction) {

		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();

		em.persist(transaction);

		em.getTransaction().commit();
		em.close();
	}
	
	public TXN load(int id) {

		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();

		 TXN transaction= em.find(TXN.class, id);

		em.getTransaction().commit();
		em.close();
		return transaction;

	}

	public void updateTransaction(TXN transaction) {

		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();

		em.merge(transaction);

		em.getTransaction().commit();
		em.close();

	}
	public void removeTransaction(int id) {
		
		
		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();
		TXN transaction = em.find(TXN.class, id);

		em.remove(transaction);

		em.getTransaction().commit();
		em.close();
		
	}
	public List<TXN> getTransaction() {
		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();

		List<TXN> transaction = em.createQuery("from TXN").getResultList();

		em.getTransaction().commit();
		em.close();
		return transaction;
	}
	
public List<TXN> getTop10History(int accountNo){
		
		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select t from TXN t where t.fromAccountNo = '"+accountNo+"'" +" order by id desc");
		query.setMaxResults(10);
		List<TXN> list = query.getResultList();
		return list;
	}
	
	public List<TXN> getLastSomeMonthHistory(int accountNo,int month){
		EntityManager em = LocalEntityManagerFactory.emf().createEntityManager();
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -3);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beforeMonth = calendar.getTime();
		String newDate = sdf.format(beforeMonth);
		Query query = em.createQuery("select h from txr_history h where h.fromAccountNo = " + accountNo + " and h.date >= '"+ newDate + "'"+"order by date");
		List<TXN> list = query.getResultList();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	

}