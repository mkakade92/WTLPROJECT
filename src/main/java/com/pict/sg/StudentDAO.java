package com.pict.sg;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class StudentDAO {
	MongoCollection<Document> col;

	public StudentDAO(MongoClient mongo) {
		
		this.col = mongo.getDatabase("StudentGrievanceSystem").getCollection("Student");
		
	}
	
	public Student createStudent(Student s)
	{
		Document doc=StudentConvertor.toDocument(s);
		this.col.insertOne( doc);
		ObjectId id=(ObjectId)doc.get("_id");
		s.setId(id.toString());
		return s;
	}
	
	public List<Student> readAllStudents()
	{
		List<Student> data=new ArrayList<Student>();
		FindIterable<Document> document=col.find();
		for(Document doc: document )
		{
			Student s=StudentConvertor.toObject(doc);
			data.add(s);
		}
		return data;
	}
	
	public void updateStudent(Student s)
	{
		Document query=new Document().append("_id",new ObjectId(s.getId()));
		this.col.updateOne(query, StudentConvertor.toDocument(s));
	}
	
	public void deleteStudent(Student s)
	{
		Document query = new Document()
				.append("_id", new ObjectId(s.getId()));
		
		this.col.deleteOne(query);
	}
	
	public Student readStudent(String uname) {
		Student S = null;
		Document query = new Document()
				.append("Username",uname);
		FindIterable<Document> document = this.col.find(query);
		for(Document doc:document)
		{
		S = StudentConvertor.toObject(doc);
		}
		return S;
	}
	
	public boolean verifyStudent(String uname,String pwd)
	{
		//first check if username exists
		Document query=new Document()
				.append("Username",uname)
				.append("password",pwd);
		FindIterable<Document> document = this.col.find(query);
		if(document==null)
			return false;
		else
			return true;
	}
		 
}
