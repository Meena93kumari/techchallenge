package me.services;
import java.sql.*;
import com.meena.bin.*;
import DaoClasses.*;
import me.util.*;
public interface SubscriptionInterface {
	String accountExists(Mainbean mainbean)throws ClassNotFoundException,SQLException;
	String  addNewSubscription(Mainbean mainbean)throws ClassNotFoundException,SQLException;
	void cancelsubscription(String accntidentity)throws ClassNotFoundException,SQLException;
}
