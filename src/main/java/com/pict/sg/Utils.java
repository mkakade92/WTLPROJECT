package com.pict.sg;

import com.mongodb.MongoClient;

public class Utils {

	public static MongoClient getConnection()
	{
		int port_no = 27017;
        String url = "localhost";
        MongoClient mongoClntObj = new MongoClient(url, port_no);
        return mongoClntObj;
	}
	
}
