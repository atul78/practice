package atul.Trading;

/**
 * Created by agosain on 5/23/2017.

import java.io.IOException;
import org.mortbay.jetty.client.*;
import org.mortbay.io.Buffer;
import oauth.signpost.*;
import oauth.signpost.jetty.*;
public class TradekingStreaming {
    public static void main(String[] args) throws Exception {
        String CONSUMER_KEY = "<CONSUMER_KEY>";
        String CONSUMER_SECRET = "<CONSUMER_SECRET>";
        String ACCESS_TOKEN = "<ACCESS_TOKEN>";
        String ACCESS_TOKEN_SECRET = "<ACCESS_TOKEN_SECRET>";
        // create a consumer object and configure it with the access
        // token and token secret obtained from the service provider
        OAuthConsumer consumer = new JettyOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
        // create an HTTP request to a protected resource
        ContentExchange request = new ContentExchange(true) {
            // tell me what kind of response code we got
            protected void onResponseComplete() throws IOException {
                int status = getResponseStatus();
                if (status == 200)
                    System.out.println("Successfully connected");
                else
                    System.out.println("Error Code Received: " + status);
            }
            // print out any response data we get along the stream
            protected void onResponseContent(Buffer data) {
                System.out.println(data);
            }
        };
        // setup the request
        request.setMethod("GET");
        request.setURL("https://stream.tradeking.com/v1/market/quotes.xml?symbols=F");
        // sign the request
        consumer.sign(request);
        // send the request
        HttpClient client = new HttpClient();
        client.start();
        client.send(request);
        request.waitForDone();
    }
}
*/