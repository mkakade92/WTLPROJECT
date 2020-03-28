package com.pict.sg;

import org.bson.Document;
import org.bson.types.ObjectId;

public class StudentConvertor {

	//Covert A Student Class Object to a MongoDb DB object
	
	public static Document toDocument(Student s)
	{
		Document document=new Document()
				.append("fname",s.getfName())
				.append("lname",s.getlName())
				.append("rollno",s.getRollno())
				.append("_Class",s.get_Class())
				.append("Username", s.getUname())
				.append("password", s.getPwd());
		if(s.getId()!=null)
			document=document.append("_id",new ObjectId(s.getId()));
		return document;
	}
	
	//Convert DBObject to Student Class Object

	public static Student toObject(Document doc)
	{
		Student s=new Student();
		s.setfName((String)doc.get("fname"));
		s.setlName((String)doc.get("lname"));
		s.setRollno((Integer)doc.get("rollno"));
		s.set_Class((String)doc.get("_Class"));
		s.setUname((String)doc.get("Username"));
		s.setPwd((String)doc.get("password"));
		ObjectId id=(ObjectId)doc.get("_id");
		s.setId(id.toString());
		return s;
	}
	
}
