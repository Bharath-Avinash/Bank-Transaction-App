package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "accounts",schema="accounts_db")
public class Account {
	
	@Id
	private int number;
	private double balance;
	
	

	public Account() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	
	
	@Override
	public String toString() {
		return "Account [number=" + number + ", balance=" + balance + "]";
	}

	public Account(int number, double balance) {
		super();
		this.number = number;
		this.balance = balance;
	}
	

}
