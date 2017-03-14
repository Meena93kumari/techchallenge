package me.util;
import java.io.*;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import me.model.ObjResponse;
public class SendResponse {
     public String SuccessResponse(HttpServletResponse response,String new_accountidentifier)throws Exception{
    	 String res=null;
    	 try{
    	 ObjectMapper mapper=new ObjectMapper();
    	 ObjResponse object=new ObjResponse(true,new_accountidentifier);
    	 
    	 res=mapper.writeValueAsString(object);
    	  
     }
    	 catch(Exception e){
    		 e.printStackTrace();
    	 }
    	 return res;
}
     public String FailureResponse(HttpServletResponse response,String new_accountidentifier)throws Exception{
    	 String res=null;
    	 try{
    	 ObjectMapper mapper=new ObjectMapper();
    	 ObjResponse object=new ObjResponse(false,new_accountidentifier);
    	 res=mapper.writeValueAsString(object);
    	  
     }
    	 catch(Exception e){
    		 e.printStackTrace();
    	 }
    	 return res;
}
     
     
     
     
     
     
     
     
     
}