package DaoClasses;
import java.sql.*;
import com.meena.bin.*;

import me.util.DBConnectionManager;
public interface BusinessDaoInteface {
	String addSubcription(Mainbean mainbean)throws ClassNotFoundException,SQLException;
	void removesubscription(String accntidentity)throws ClassNotFoundException,SQLException;
}
