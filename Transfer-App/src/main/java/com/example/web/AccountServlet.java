package com.example.web;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import com.example.entity.*;

import com.example.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;=

@WebServlet(urlPatterns = { "/accounts" })
public class AccountServlet extends HttpServlet   {
	
	AccountRepository accountRepository = new AccountRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	//	List<Todo> todos = todoRepository.getTodos();
	  List<Account> accounts = accountRepository.getAccount();
	 // System.out.print("accounts loaded");
	  req.setAttribute("history-lis", accounts);
		req.getRequestDispatcher("Account.jsp").forward(req, resp);

		

	}
	
	
	
	

}
