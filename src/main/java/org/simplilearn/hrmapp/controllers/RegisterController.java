package org.simplilearn.hrmapp.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.hrmapp.dao.UserDao;
import org.simplilearn.hrmapp.dao.UserDaoImpl;
import org.simplilearn.hrmapp.entities.User;


@WebServlet("/register")
public class RegisterController extends HttpServlet {
	UserDao dao=new UserDaoImpl();
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		dao.insertUser(user);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
