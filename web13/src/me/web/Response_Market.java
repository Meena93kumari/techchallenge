
	
	package me.web;

	import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import java.io.PrintWriter;
	import java.net.HttpURLConnection;
	import java.net.URL;

	import org.codehaus.jackson.map.ObjectMapper;

import me.model.ObjResponse;
import oauth.signpost.OAuthConsumer;
	import oauth.signpost.basic.DefaultOAuthConsumer;
	import oauth.signpost.exception.OAuthCommunicationException;
	import oauth.signpost.exception.OAuthExpectationFailedException;
	import oauth.signpost.exception.OAuthMessageSignerException;

	/**
	 * Servlet implementation class respond_appdirect
	 */
	@WebServlet("/Response_Market")
	public class Response_Market extends HttpServlet {
		private static final long serialVersionUID = 1L;

	    /**
	     * Default constructor. 
	     */
	    

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.setContentType("application/json");
			PrintWriter out=response.getWriter();
			String eventUrl=(String)request.getParameter("eventUrl");
			
			System.out.println(eventUrl);
			ObjectMapper  mapper=new ObjectMapper();
			//response.setStatus(200);
			
	        ObjResponse responseObject = new ObjResponse(true,"new-account-identifier");
	        String json = mapper.writeValueAsString(responseObject);
	        out.print(json);
	        System.out.println(json);
	        //System.out.println(eventUrl);
	        
	        
	        OAuthConsumer consumer = new DefaultOAuthConsumer("techprod-153475", "m6dDr2nEsNz1YavR");
	        URL url = new URL(eventUrl);
	        HttpURLConnection req = (HttpURLConnection) url.openConnection();
	       
	        req.setRequestProperty("Accept", "application/json");
	        try {
				consumer.sign(req);
			} catch (OAuthMessageSignerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (OAuthExpectationFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (OAuthCommunicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        req.connect();
	        System.out.println(eventUrl);
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader (req.getInputStream()));
	        String lines = "";
	        while((lines=br.readLine())!=null){
	        	System.out.println(lines);
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


