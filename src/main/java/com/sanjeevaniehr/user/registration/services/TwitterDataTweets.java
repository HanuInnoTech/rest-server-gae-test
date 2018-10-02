package com.sanjeevaniehr.user.registration.services;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterDataTweets {

	public JSONObject getTweets(String searchKeyword) throws JSONException {
		String Keyword = searchKeyword;

		JSONArray returnArray = null;
		JSONObject returnJsonobjectArray = new JSONObject();
		returnArray = new JSONArray();
		System.out.println(Keyword);

		System.out.println("inside getTweets");
		// try {
		//
		// Client client = Client.create();
		//
		// WebResource webResource = client
		// .resource("http://ec2-54-198-19-189.compute-1.amazonaws.com:8080/Sanjeevani/rest/SV/getEHRReportsData");
		//
		// ClientResponse response = webResource.accept("application/json")
		// .get(ClientResponse.class);
		//
		// if (response.getStatus() != 200) {
		// throw new RuntimeException("Failed : HTTP error code : "
		// + response.getStatus());
		// }
		//
		// String output = response.getEntity(String.class);
		//
		// System.out.println("Output from Server .... \n");
		// System.out.println(output);
		//
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		String TWITTER_CONSUMER_KEY = "iMoVwp1bB59UFu4EE3U0eA91b";
		String TWITTER_SECRET_KEY = "Fvos2hWK6nClK9d43Ugz4dWmufv9FWO7gDGc8mafeOXVUAMJ4g";
		String TWITTER_ACCESS_TOKEN = "3004745283-GMbGQuyDdBBfIqZoUnAr7w2NAp8wflEomyAuzob";
		String TWITTER_ACCESS_TOKEN_SECRET = "vylSp9bOhHc6biaeR62SrqIx4UIpakP9vBNIdojXqG1BI";

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(TWITTER_CONSUMER_KEY).setOAuthConsumerSecret(TWITTER_SECRET_KEY)
				.setOAuthAccessToken(TWITTER_ACCESS_TOKEN).setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		// Twitter twitter = tf.getInstance();
		// try {
		// Query query = new Query("MrEdPanama");
		// QueryResult result;
		// do {
		// result = twitter.search(query);
		// List<Status> tweets = result.getTweets();
		// for (Status tweet : tweets) {
		// System.out.println("@" + tweet.getUser().getScreenName() + " - " +
		// tweet.getText());
		// }
		// } while ((query = result.nextQuery()) != null);
		// System.exit(0);
		// } catch (TwitterException te) {
		// te.printStackTrace();
		// System.out.println("Failed to search tweets: " + te.getMessage());
		// System.exit(-1);
		// }
		Twitter twitter = tf.getInstance();

		// AccessToken accessToken = new AccessToken(TWITTER_ACCESS_TOKEN,
		// TWITTER_ACCESS_TOKEN_SECRET);
		// twitter.setOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_SECRET_KEY);
		// twitter.setOAuthAccessToken(accessToken);

		try {

			Query query = new Query(Keyword);
			// Query query1 = new Query(state);

			QueryResult result;
			result = twitter.search(query);
			List<Status> tweets = result.getTweets();
			for (Status tweet : tweets) {
				JSONObject returnJson = null;
				returnJson = new JSONObject();
				// System.out.println("@" + tweet.getUser().getScreenName() + " - " +
				// tweet.getText());
				System.out.println("@" + tweet.getText());
				returnJson.put("username", tweet.getUser().getScreenName());
				returnJson.put("Message", tweet.getText());
				returnArray.put(returnJson);

			}
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}
		return returnJsonobjectArray.put("twitterTweets", returnArray);
	}
}