package me.util;
import java.io.*;
import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static PreparedStatement pst=null;
       public void init(ServletConfig config)throws ServletException{
    	   super.init(config);
    	   try{
    		   Class.forName("com.mysql.jdbc.Driver");
    		   Connection con=DriverManager.getConnection("jdbc:myql://localhost:3307/Employee_db","root","password");
    	   pst=con.prepareStatement("select* from employee where user_name=? and pass_word=?");
    	   }
    	   catch(Exception e){
    		   e.printStackTrace();
    	   }
    	   
    	   
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
	
	try{
		pst.setString(1,uid);
		pst.setString(2, pwd);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			RequestDispatcher rd=request.getRequestDispatcher("welcome.html");
			rd.forward(request, response);
		}
		else{
			response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			out.println("<p style=color:red;font-size=20px;>Invalid User_name or password</p>");
			RequestDispatcher rd=request.getRequestDispatcher("formfill.html");
			rd.include(request, response);
		}
	}
	catch(Exception e){
		e.printStackTrace();
		
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
