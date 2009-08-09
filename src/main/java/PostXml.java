import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

public class PostXml {

    public static void main(String[] args) throws Exception {
    	String strURL;
    	File input;
    	if (args.length == 0) {
    		strURL = "http://localhost:8080/endpoint";
    		input = new File("c:\\temp\\repo\\sampleinput.xml");
    	} else {
    		strURL = args[0];
    		input = new File(args[1]);
    	}
        PostMethod post = new PostMethod(strURL);
        RequestEntity entity = new FileRequestEntity(input, "text/xml; charset=ISO-8859-1");
        post.setRequestEntity(entity);
        HttpClient httpclient = new HttpClient();
        try {
            int result = httpclient.executeMethod(post);
            System.out.println("Response status code: " + result);
            System.out.println("Response body: ");
            System.out.println(post.getResponseBodyAsString());
        } finally {
            post.releaseConnection();
        }
    }
}