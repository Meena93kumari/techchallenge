package me.util;
import java.io.*;
import oauth.signpost.*;
import oauth.signpost.basic.DefaultOAuthConsumer;
import java.net.HttpURLConnection;
import java.net.URL;
import oauth.signpost.exception.*;
import com.meena.bin.*;
import org.codehaus.jackson.map.ObjectMapper;
public class HttpConnAndOath {
	public HttpURLConnection getinputstreamJsonUrl(String eventUrl) throws Exception  {
		OAuthConsumer newconsumer = new DefaultOAuthConsumer("techprod2-154387", "qkRDgpFdlzLmHPOu");
        URL url = new URL(eventUrl);
        HttpURLConnection req = (HttpURLConnection) url.openConnection();
        req.setRequestProperty("Accept", "application/json");
		try{
			newconsumer.sign(req);
		}
		catch( OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e){
			e.printStackTrace();
		}
		req.connect();
		return req;
		
	}
	public String getJsonStringfromInputstream(HttpURLConnection req)throws IOException{
		String json="";
	try{
		InputStream input=req.getInputStream();
		InputStreamReader read=new InputStreamReader(input);
		BufferedReader br=new BufferedReader(read);
		String line=br.readLine();
		while(line!=null){
			json=json+line;
			line=br.readLine();
		}
		br.close();
	}
	catch(IOException e){
		e.printStackTrace();
	}
    return json;
}
	public Mainbean mapppingJsontobeans(String Json) throws Exception{
		Mainbean mainbean=null;
		try{
		ObjectMapper mapper=new ObjectMapper();
		 mainbean=mapper.readValue(Json,Mainbean.class);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return mainbean;
	}
	
}