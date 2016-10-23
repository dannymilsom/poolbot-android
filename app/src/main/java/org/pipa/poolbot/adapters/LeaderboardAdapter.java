package org.pipa.poolbot.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pipa.poolbot.R;
import org.pipa.poolbot.models.Player;

import java.util.ArrayList;

/**
 * Custom adapter for rendering a list of players.
 */
public class LeaderboardAdapter extends ArrayAdapter<Player> {

    public LeaderboardAdapter(Context context, ArrayList<Player> players) {
        super(context, 0, players);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.leaderboard_item, parent, false);
        }

        // Lookup views
        TextView tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
        TextView tvEloScore = (TextView) convertView.findViewById(R.id.tvEloScore);
        ImageView ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatarImage);

        // Populate views with data from player instance
        tvUsername.setText(player.getName());
        tvEloScore.setText(Integer.toString(player.getSeasonElo()));
        Picasso.with(getContext()).load("http://www.sportsworldcards.com/ekmps/shops/sportsworld/images/bristol-city-gerry-gow-68-ava-americana-football-special-79-english-football-sticker-53160-p.jpg").into(ivAvatar);

        // Return the completed view to render on screen
        return convertView;
    }

}