package com.pict.sg;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;

public class GrievanceDAO {
	
	MongoCollection<Document> col;

	public  GrievanceDAO(MongoClient mongo) {
		
		this.col = mongo.getDatabase("StudentGrievanceSystem").getCollection("StudentGrievance");
	}
	
	public StudentGrievance createGrievance(StudentGrievance g)
	{
		Document doc=GrievanceConvertor.toDocument(g);
		this.col.insertOne( doc);
		ObjectId id=(ObjectId)doc.get("_id");
		g.setId(id.toString());
		return g;
	}
	
	public ArrayList<StudentGrievance> readGrievance(String uname)
	{
		ArrayList<StudentGrievance> SG_List=new ArrayList<StudentGrievance>();
		StudentGrievance G = null;
		DBObject query = BasicDBObjectBuilder.start()
				.append("Username",uname).get();
		FindIterable<Document> document = this.col.find((Bson) query);
		for(Document doc:document)
		{
		G = GrievanceConvertor.toObject(doc);
		System.out.println(G.toString());
		SG_List.add(G);
		}
		return SG_List;
	}
	
	public boolean deleteGrievance(String id)
	{
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id",id).get();
		FindIterable<Document> document = this.col.find((Bson) query);
		if(document!=null)
		{
			DeleteResult res=this.col.deleteOne(eq("_id",new ObjectId(id)));
			System.out.println("deleteOne() - # of records deleted - " + res.getDeletedCount());
			return true;
		}
		else
		{
			System.out.println("Document for Deletion not found");
		return false;
		}
	}
}
