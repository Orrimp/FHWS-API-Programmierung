package de.fhws.apiprog.vorlesung1.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DemoPost {
	
	public static void main( String[] args ) throws Exception
	{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://staging.applab.fhws.de:8080/api/demo/ping");
		HttpEntity entity = new StringEntity("HALLO");
		httpPost.setEntity(entity);
		
		CloseableHttpResponse response2 = httpclient.execute(httpPost);

		try {
			System.out.println(response2.getStatusLine());
			HttpEntity entity1 = response2.getEntity();			
			String text = EntityUtils.toString(entity1);
			System.out.println(text);
			EntityUtils.consume(entity1);
		} finally {
			response2.close();
		}
	}
}
