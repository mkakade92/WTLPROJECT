package com.pict.sg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;

/**
 * Servlet implementation class UploadGrievance
 */
public class UploadGrievance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadGrievance() {
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
		if(session!=null || session.getAttribute("uname")==null)
		{
		String uName=(String) session.getAttribute("uname");
		String title=request.getParameter("title");
		String grievance=request.getParameter("grievance");
		
		
		StudentGrievance g=new StudentGrievance();
		g.setUname(uName);
		g.setTitle(title);
		g.setGrievance(grievance);
		
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		GrievanceDAO gDAO=new GrievanceDAO(mongo);
		gDAO.createGrievance(g);
		ArrayList<StudentGrievance> data=new ArrayList<StudentGrievance>();
		data.add(g);
		request.setAttribute("StudentG", data);
		request.setAttribute("UploadMsg","Success");
		session.setAttribute("uname",g.getUname());
		System.out.println("Grievance added successfully with id : "+g.getId());
		rd.forward(request, response);
		}
		else
		{
			rd.forward(request, response);
		}
	
	}

}
