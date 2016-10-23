package org.pipa.poolbot;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * HTTP client which fetches data from the Poolbot API.
 */
public class PoolbotAPIClient {

    private String TOKEN;
    private String API_BASE_URL;
    private Context context;
    private AsyncHttpClient client;


    /**
     * Obtains the customisable server URI, and prepares the client
     * to make requests with an Authorization header.
     */
    public PoolbotAPIClient(Context context) {
        this.context = context;

        TOKEN = context.getResources().getString(R.string.server_token);
        API_BASE_URL = context.getResources().getString(R.string.server_url);

        client = new AsyncHttpClient();
        client.addHeader("Authorization", "Token " + TOKEN);
    }

    /**
     * Joins the base API URL and the endpoint specific string.
     */
    private String buildUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    /**
     * Returns a JSONArray containing all poolbot player data,
     * excluding any non active users and ordering the results
     * by season elo points.
     */
    public void getPlayers(JsonHttpResponseHandler handler) {
        String url = buildUrl("player/");
        RequestParams params = new RequestParams();
        params.put("active", "True");
        params.put("ordering", "-season_elo");
        client.get(url, params, handler);
    }

}