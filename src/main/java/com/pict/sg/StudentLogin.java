package com.pict.sg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;

/**
 * Servlet implementation class StudentLogin
 */
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		StudentDAO sDAO=new StudentDAO(mongo);
		String uName=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		if(sDAO.verifyStudent(uName, pwd))
		{
			System.out.println("Successful Authentication");
			
			
			
			HttpSession session=request.getSession();
			session.setAttribute("uid",uName);
			Student S=sDAO.readStudent(uName);
			ArrayList<Student> data=new ArrayList<Student>();
			data.add(S);
			request.setAttribute("Student", data);
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			
		}
		else
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	
	}

}
