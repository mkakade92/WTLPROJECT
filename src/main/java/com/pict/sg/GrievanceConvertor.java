package com.pict.sg;

import org.bson.Document;
import org.bson.types.ObjectId;

public class GrievanceConvertor {

	public static Document toDocument(StudentGrievance g)
	{
		Document document=new Document()
				.append("Username",g.getUname())
				.append("Title", g.getTitle())
				.append("Grievance",g.getGrievance());
		if(g.getId()!=null)
			document=document.append("_id",new ObjectId(g.getId()));
		return document;
	}
	
	//Convert DBObject to Student Class Object

	public static StudentGrievance toObject(Document doc)
	{
		StudentGrievance g=new StudentGrievance();
		g.setUname((String)doc.get("Username"));
		g.setTitle((String)doc.get("Title"));
		g.setGrievance((String)doc.get("Grievance"));
		ObjectId id=(ObjectId)doc.get("_id");
		g.setId(id.toString());
		return g;
	}
	
	
}
