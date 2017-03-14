package me.services;
import java.sql.*;
import com.meena.bin.*;
import DaoClasses.*;
import me.util.*;
 
public class SubscriptionService implements SubscriptionInterface {
	
     public String accountExists(Mainbean mainbean)throws ClassNotFoundException,SQLException{
    	 DBConnectionManager db=new DBConnectionManager();
       	Connection con=db.getConnection("jdbc:mysql://localhost:3306/Subscription", "root", "password");
       	String s=mainbean.getCreator().getUuid();
    	
    	 PreparedStatement pst=con.prepareStatement("select * from subscription where creatoruid= ?");
    	 pst.setString(1,s);
    	 
    	 ResultSet rs=pst.executeQuery();
    	
    	 if(rs!=null && rs.next())
    		 return rs.getString("accntidentifier");
    	 else return null;
     }
     
	
	
      public String  addNewSubscription(Mainbean mainbean)throws ClassNotFoundException,SQLException{
    	 
    	  BusinessDaoInteface business=new BusinessDao();
    	  return business.addSubcription(mainbean);
    	  
      }
      
      
      public void cancelsubscription(String accntidentity)throws ClassNotFoundException,SQLException{
    	 
    	  BusinessDaoInteface business=new BusinessDao();
    	  business.removesubscription(accntidentity);
    	  
    	  
      }
      
}
