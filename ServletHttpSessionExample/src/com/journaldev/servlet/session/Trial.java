package com.journaldev.servlet.session;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class Trial {
	public static final String NAME_SPACE="com.cg";
	
	void set() throws IOException
	{
		MemcachedClient client=new MemcachedClient(new InetSocketAddress("c", 11211));
		String userID="pr";
		String password="pr";
		client.set(userID, 300, password);
		System.out.println(client.get(userID));
	}
	public static void main(String[] args) throws IOException {
		
		/*MemcachedClient client=new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		String userID="pr";
		String password="pr";
		
		
		client.set(userID, 300, password);
		System.out.println(client.get(userID));*/
		 MemcachedClient mcc = new MemcachedClient(new
			      InetSocketAddress("127.0.0.1", 11211));
			      System.out.println("Connection to server sucessfully");
			      System.out.println("set status:"+mcc.set("tutorialspoint", 900, "memcached").isCancelled());
			      
			      // Get value from cache
			      System.out.println("Get from Cache:"+mcc.get("tutorialspoint"));
			      
			      // now replace the existing data
			      System.out.println("Replace cache:"+mcc.replace("tutorialspoint", 900, "redis").isDone());
			      
			      // get the updated data
			      System.out.println("Get from Cache:"+mcc.get("tutorialspoint"));
	}
	
	
	
	
}
	

