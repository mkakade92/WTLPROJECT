package com.pict.sg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mongodb.MongoClient;

/**
 * Servlet implementation class ViewGrievance
 */
public class ViewGrievance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ViewGrievance() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In the servlet . YAayy");
		HttpSession session=request.getSession();
		
		String uName=(String) session.getAttribute("uname");
		if(uName!=null)
		{
			ArrayList<StudentGrievance> SG_LIST=new ArrayList<StudentGrievance>();
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			GrievanceDAO gDAO=new GrievanceDAO(mongo);
			SG_LIST=gDAO.readGrievance(uName);
			Gson gson = new Gson();
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(SG_LIST));
			out.flush();
			out.close();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
