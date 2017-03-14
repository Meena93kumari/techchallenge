package me.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import com.meena.bin.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DaoClasses.*;
import me.services.*;
import me.util.*;
/**
 * Servlet implementation class CreateSubscription
 */
@WebServlet("/CreateSubscription")
public class CreateSubscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CreateSubscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		String eventUrl=(String)request.getParameter("eventUrl");
//		SendResponse demo=new SendResponse();
//		
//		try {
//			out.print(demo.SuccessResponse(response, "Hello Meena"));
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		HttpConnAndOath httpconn=new HttpConnAndOath();
		SendResponse responsenew=new SendResponse();
		try{
		HttpURLConnection http=httpconn.getinputstreamJsonUrl(eventUrl);
		String json=httpconn.getJsonStringfromInputstream(http);
		System.out.println(json);
		Mainbean mainbean=httpconn.mapppingJsontobeans(json);
		SubscriptionInterface service=new SubscriptionService();
		String accntid=service.accountExists(mainbean);
		
		if(accntid==null){
			 accntid=service.addNewSubscription(mainbean);
			out.print(responsenew.SuccessResponse(response, accntid));
		
		}
		else{
			out.print(responsenew.FailureResponse(response,accntid));
		}
	}
catch(Exception e){
	e.printStackTrace();
}

}
}