package org.simplilearn.hrmapp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.hrmapp.dao.SubjectDao;
import org.simplilearn.hrmapp.dao.SubjectDaoImpl;
import org.simplilearn.hrmapp.entities.Subject;


@WebServlet("/addSub")
public class AddSubjectController extends HttpServlet {
	SubjectDao subjectDao=new SubjectDaoImpl();
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subName=request.getParameter("sname");
		Subject subject=new Subject();
		subject.setName(subName);
		subjectDao.addSubject(subject);
	}

}
