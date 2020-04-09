package com.pict.sg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;

/**
 * Servlet implementation class DeleteGrievance
 */
public class DeleteGrievance extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteGrievance() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println("Id for deletion is : "+id);
//		doGet(request, response);
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		GrievanceDAO gDAO=new GrievanceDAO(mongo);
		boolean result=gDAO.deleteGrievance(id);
		response.setContentType("text/plain");
		if(result)
		response.getWriter().write("Success");
		else
		response.getWriter().write("Error");

	}
	

}
