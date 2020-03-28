package com.pict.sg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;

/**
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
		HttpSession session=request.getSession();
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/dashboard.jsp");
		if(session==null || session.getAttribute("uid")==null )
		{
		int rollNo=Integer.parseInt(request.getParameter("rollno"));
		String fName=request.getParameter("fName");
		String lName=request.getParameter("lName");
		String _Class=request.getParameter("_Class");
		String uName=request.getParameter("uName");
		String pwd=request.getParameter("pwd");
		
		Student s=new Student();
		s.set_Class(_Class);
		s.setfName(fName);
		s.setlName(lName);
		s.setPwd(pwd);
		s.setRollno(rollNo);
		s.setUname(uName);
		
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		StudentDAO sDAO=new StudentDAO(mongo);
		sDAO.createStudent(s);
		System.out.println("Student added successfully woth id : "+s.getId());
		session.setAttribute("uid",uName);

		rd.forward(request, response);
		}
		else
		{
			rd.forward(request, response);
		}
	}

}
