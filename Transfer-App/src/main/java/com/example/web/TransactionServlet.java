package com.example.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.Account;
import com.example.entity.TXN;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = { "/transaction-history" })
public class TransactionServlet extends HttpServlet   {
	
	TransactionRepository transactionRepository = new TransactionRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	//	List<Todo> todos = todoRepository.getTodos();
	 // List<TXN> transaction = transactionRepository.getTransaction();
	 
		String typeOfHistory = req.getParameter("choose");
		System.out.println("type = "+typeOfHistory);
		if(typeOfHistory.equals("Top-10")) {
			 int AccountNo = Integer.parseInt(req.getParameter("accountNo"));
			 
			List<TXN> history = transactionRepository.getTop10History(AccountNo);
			req.setAttribute("history-list", history);
			req.getRequestDispatcher("transactionHistory.jsp").forward(req, resp);
		}

		if(typeOfHistory.equals("Get-All-Transaction")) {
			//int month = Integer.parseInt(req.getParameter("month"));
			List<TXN> history = transactionRepository.getTransaction();
			req.setAttribute("history-list", history);
			req.getRequestDispatcher("transactionHistory.jsp").forward(req, resp);
		}
		
		
	 

	}}