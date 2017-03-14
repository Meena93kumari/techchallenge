package DaoClasses;
import java.sql.*;
import com.meena.bin.*;

import me.util.DBConnectionManager;

public class BusinessDao implements BusinessDaoInteface{
    public String addSubcription(Mainbean mainbean)throws ClassNotFoundException,SQLException {
    	DBConnectionManager db=new DBConnectionManager();
    	Connection con=db.getConnection("jdbc:mysql://localhost:3306/Subscription", "root", "password");
    	PreparedStatement pst = con.prepareStatement("Insert into subscription values (null,?,?,?,?,?,?,?,?)");
    	String eventtype=mainbean.getType();
    	String creatoruid=mainbean.getCreator().getUuid();
    	String payloaduid=mainbean.getPayload().getCompany().getUuid();
    	String name_u=mainbean.getCreator().getFirstName()+mainbean.getCreator().getLastName();
    	String emailid=mainbean.getCreator().getEmail();
    	String editioncode=mainbean.getPayload().getOrder().getEditionCode();
    	String pricing_du=mainbean.getPayload().getOrder().getPricingDuration();
    	String accnt_identify=mainbean.getCreator().getFirstName()+editioncode;
    	pst.setString(1,eventtype);
    	pst.setString(2,creatoruid);
    	pst.setString(3,payloaduid);
    	pst.setString(4,name_u);
    	pst.setString(5,emailid);
    	pst.setString(6,editioncode);
    	pst.setString(7,pricing_du);
    	pst.setString(8,accnt_identify);
    	pst.execute();
    	return accnt_identify;
}
    
    public void removesubscription(String accntidentity)throws ClassNotFoundException,SQLException{
    	DBConnectionManager db=new DBConnectionManager();
    	Connection con=db.getConnection("jdbc:mysql://localhost:3306/Subscription", "root", "password");
    	Statement st=con.createStatement();
    	String sql="delete* from subscription where accntidentifier="+accntidentity;
    	st.executeQuery(sql);
   	
    }
    
 
}