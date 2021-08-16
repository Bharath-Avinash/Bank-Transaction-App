package com.example.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.Account;
import com.example.entity.TXN;
import com.example.entity.Txn_Type;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;

@WebServlet(urlPatterns = { "/transfer" })
public class TransferServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountRepository transferRepo = new AccountRepository();
	
		try{int fromAccountNo = Integer.parseInt(req.getParameter("from"));
		int toAccountNo = Integer.parseInt(req.getParameter("to"));
		double amount = Double.parseDouble(req.getParameter("amount"));
	
		Account fromAccount = transferRepo.load(fromAccountNo);
		Account toAccount = transferRepo.load(toAccountNo);
		
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		if(fromAccount.getBalance()<0) {
			fromAccount.setBalance(fromAccount.getBalance()-amount);
			req.setAttribute("transfer-status", "Insufficient Account Balance ");
			req.getRequestDispatcher("transferStatus.jsp").forward(req, resp);}
		else {
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		
		transferRepo.updateAcc(fromAccount);
		transferRepo.updateAcc(toAccount);
		
		TXN debitHistory = new TXN(fromAccountNo, toAccountNo,  Txn_Type.DEBIT, new Date(),amount);
		TXN creditHistory = new TXN(toAccountNo, fromAccountNo,  Txn_Type.CREDIT, new Date(),amount);
		
		transferRepo.createHistory(debitHistory);
		transferRepo.createHistory(creditHistory);
		
		System.out.println("transaction successfull");
		
		req.setAttribute("transfer-status", "Transaction successfull");
		req.getRequestDispatcher("transferStatus.jsp").forward(req, resp);}
		
		}catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("transfer-status", "Enter valid Account Number");
			req.getRequestDispatcher("transferStatus.jsp").forward(req, resp);}}}
