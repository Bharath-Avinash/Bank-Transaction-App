package com.example.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "txr_history",schema="accounts_db")

public class TXN {
	
	    public TXN() {
		super();
	}



		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    int fromAccountNo;
	    int toAccountNo;

		@Enumerated(EnumType.STRING)
	    private Txn_Type type;
        private double amount;
	   



		public TXN( int fromAccountNo, int toAccountNo, Txn_Type type, Date date,double amount
				) {
			super();
			this.id = id;
			this.fromAccountNo = fromAccountNo;
			this.toAccountNo = toAccountNo;
			
			this.type = type;
			this.amount = amount;
			this.date = date;
			//this.acc_number = acc_number;
		}



		@Temporal(TemporalType.DATE)
	    private Date date;



	  //  @ManyToOne
	//    @JoinColumn(name="acc_number")
	   // private Account acc_number;




		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public int getFromAccountNo() {
			return fromAccountNo;
		}



		public void setFromAccountNo(int fromAccountNo) {
			this.fromAccountNo = fromAccountNo;
		}



		public int getToAccountNo() {
			return toAccountNo;
		}



		public void setToAccountNo(int toAccountNo) {
			this.toAccountNo = toAccountNo;
		}



		public Txn_Type getType() {
			return type;
		}



		public void setType(Txn_Type type) {
			this.type = type;
		}



		public double getAmount() {
			return amount;
		}



		public void setAmount(double amount) {
			this.amount = amount;
		}



		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}



		
	   
		


}

