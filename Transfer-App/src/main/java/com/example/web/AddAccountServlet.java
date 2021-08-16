package com.example.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/add-account"})
public class AddAccountServlet extends HttpServlet {
	
	AccountRepository accountRepository = new AccountRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		int accountNo = Integer.parseInt(req.getParameter("No"));
	
		double balance = Double.parseDouble(req.getParameter("deposit"));
		
		Account acc = new Account();
		acc.setNumber(accountNo);
		
		acc.setBalance(balance);
		
		accountRepository.save(acc);
		req.setAttribute("add-status", "Account added successfully");
		
		req.getRequestDispatcher("addAccountStatus.jsp").forward(req, resp);
	}
	
	

}
