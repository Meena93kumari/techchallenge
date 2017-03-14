package me.web;

import java.io.IOException;
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
@WebServlet("/respond_appdirect")
public class respond_appdirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public respond_appdirect() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		String eventUrl=(String)request.getParameter("io");
		
		System.out.println(eventUrl);
		ObjectMapper  mapper=new ObjectMapper();
		//response.setStatus(200);
		
        ObjResponse responseObject = new ObjResponse(true,"new-account-identifier");
        String json = mapper.writeValueAsString(responseObject);
        out.print(json);
        //System.out.println(eventUrl);
        OAuthConsumer consumer = new DefaultOAuthConsumer("mynewpro-152807", "atbYdAo3u8SmRZZ2");
        URL url = new URL(eventUrl);
        HttpURLConnection req = (HttpURLConnection) url.openConnection();
       
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
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
