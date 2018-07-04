package com.journaldev.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import com.journaldev.servlet.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.spy.memcached.MemcachedClient;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "pr";
	private final String password = "pr";
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.sendRedirect("index.jsp");
		
	}



	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		//HttpSession session;
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.invalidate();
		}
		if(userID.equals(user) && password.equals(pwd)){
			HttpSession session1 = request.getSession();
			session1.setAttribute("user", "Priya");
			session1.setMaxInactiveInterval(30*60*60);
			/*MemcachedClient client=new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			 System.out.println("set status:"+client.add("user", 900, "Priya").isDone());
			 System.out.println("Get from Cache:"+client.get("user"));*/
			/*MemcachedClient client1=new MemcachedClient(new InetSocketAddress("memcached.qyqdpt.cfg.apse1.cache.amazonaws.com", 11211));
			client1.set("password", 300, userID);
			MemcachedClient client2=new MemcachedClient(new InetSocketAddress("memcached.qyqdpt.cfg.apse1.cache.amazonaws.com", 11211));
			client2.set("user", 300, user);*/
			//Cookie userName = new Cookie("user", user);
			//userName.setMaxAge(30*60);
			//response.addCookie(userName);
			response.sendRedirect("LoginSuccess.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out= response.getWriter();
			out.println("<center><font color=red>Either user name or password is wrong.</font></center>");
			rd.include(request, response);
		}

	}

}
