package org.simplilearn.hrmapp.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simplilearn.hrmapp.dao.UserDao;
import org.simplilearn.hrmapp.dao.UserDaoImpl;
import org.simplilearn.hrmapp.entities.User;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private UserDao dao=new UserDaoImpl();
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			User user=dao.getUser(username, password);
			if(user!=null)
			{
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
	}

}
