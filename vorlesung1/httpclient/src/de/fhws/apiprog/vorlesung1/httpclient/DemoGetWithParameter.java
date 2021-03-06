package de.fhws.apiprog.vorlesung1.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DemoGetWithParameter {
	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		URIBuilder uriBuilder = new URIBuilder( "http://staging.applab.fhws.de:8080/api/demo/ping" );
		uriBuilder.setParameter("text", "wert");
		HttpGet httpGet = new HttpGet( uriBuilder.build() );
		CloseableHttpResponse response1 = httpclient.execute(httpGet);

		try {
			System.out.println(response1.getStatusLine());
			
			StatusLine status = response1.getStatusLine();
			System.out.println("StatusCode: " + status.getStatusCode() );
			
			Header[] allHeaders = response1.getAllHeaders();
			
			for( Header header : allHeaders )
			{
				System.out.println( header.getName() + ":" + header.getValue() );
			}
			
			HttpEntity entity1 = response1.getEntity();			
			String text = EntityUtils.toString(entity1);
			
			System.out.println(text);
			
			EntityUtils.consume(entity1);
		} finally {
			response1.close();
		}
	}
}
