package org.pipa.poolbot.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.pipa.poolbot.PoolbotAPIClient;
import org.pipa.poolbot.R;
import org.pipa.poolbot.adapters.LeaderboardAdapter;
import org.pipa.poolbot.models.Player;

import java.util.ArrayList;

/**
 * Populates a ListView with player data obtained by the API.
 */
public class LeaderboardFragment extends Fragment {

    private PoolbotAPIClient client;
    private ArrayList<Player> players = new ArrayList<>();
    private ListView lvLeaderboard;
    private LeaderboardAdapter leaderboardAdapter;

    @Override public View onCreateView(LayoutInflater inflater,
                                       ViewGroup container,
                                       Bundle savedInstanceState) {

        // inflate the fragment view
        View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        // cache some views
        lvLeaderboard = (ListView) view.findViewById(R.id.lv_leaderboard);

        // prepare the client and fetch data from the API
        client = new PoolbotAPIClient(getContext());
        fetchPlayerData();

        return view;
    }

    /**
     * Use the HTTP client to obtain player data, serialize it into
     * player instances and pass to the custom adapter for item rendering.
     */
    private void fetchPlayerData() {
        client.getPlayers(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // hold all players in a temp list
                ArrayList<Player> allPlayers = Player.fromJsonArray(response);

                // filter out players with no games this season
                for (Player player: allPlayers) {
                    if (player.getSeasonMatchCount() > 0) {
                        players.add(player);
                    }
                }

                // initalize the adapter and pass in the filtered list of players
                leaderboardAdapter = new LeaderboardAdapter(getContext(), players);
                lvLeaderboard.setAdapter(leaderboardAdapter);
            }
        });
    }

}
