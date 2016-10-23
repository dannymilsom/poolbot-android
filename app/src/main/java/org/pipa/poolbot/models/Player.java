package org.pipa.poolbot.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a pool player / slack user.
 */
public class Player implements Serializable {

    private String slackId;
    private String name;
    private Boolean active;
    private Date joined;
//    private Integer age;
    private String nickname;
    private String country;

    private String avatar;

    private Integer totalElo;
    private Integer totalWinCount;
    private Integer totalLossCount;
    private Integer totalMatchCount;
    private Integer totalGranniesGivenCount;
    private Integer totalGranniesTakenCount;

    private Integer seasonElo;
    private Integer seasonWinCount;
    private Integer seasonLossCount;
    private Integer seasonMatchCount;
    private Integer seasonGrannies_GivenCount;
    private Integer seasonGranniesTakenCount;

    public String getSlackId() {
        return slackId;
    }

    public void setSlackId(String id) {
        this.slackId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
//        this.avatar = avatar;
        this.avatar = "http://www.sportsworldcards.com/ekmps/shops/sportsworld/images/bristol-city-gerry-gow-68-ava-americana-football-special-79-english-football-sticker-53160-p.jpg";
    }

    public Integer getTotalWinCount() {
        return totalWinCount;
    }

    public void setTotalWinCount(Integer winCount) {
        this.totalWinCount = winCount;
    }

    public Integer getTotalLossCount() {
        return totalLossCount;
    }

    public void setTotalLossCount(Integer lossCount) {
        this.totalLossCount = lossCount;
    }

    public Integer getTotalMatchCount() {
        return totalMatchCount;
    }

    public void setTotalMatchCount(Integer matchCount) {
        this.totalMatchCount = matchCount;
    }

    public Integer getTotalGranniesGivenCount() {
        return totalGranniesGivenCount;
    }

    public void setTotalGranniesGivenCount(Integer granniesGiven) {
        this.totalGranniesGivenCount = granniesGiven;
    }

    public Integer getTotalGranniesTakenCount() {
        return totalGranniesTakenCount;
    }

    public void setTotalGranniesTakenCount(Integer granniesTaken) {
        this.totalGranniesTakenCount = granniesTaken;
    }

    public Integer getTotalElo() {
        return totalElo;
    }

    public void setTotalElo(Integer eloScore) {
        this.totalElo = eloScore;
    }

    public Integer getSeasonWinCount() {
        return seasonWinCount;
    }

    public void setSeasonWinCount(Integer winCount) {
        this.seasonWinCount = winCount;
    }

    public Integer getSeasonLossCount() {
        return seasonLossCount;
    }

    public void setSeasonLossCount(Integer lossCount) {
        this.seasonLossCount = lossCount;
    }

    public Integer getSeasonMatchCount() {
        return seasonMatchCount;
    }

    public void setSeasonMatchCount(Integer matchCount) {
        this.seasonMatchCount = matchCount;
    }

    public Integer getSeasonGrannies_GivenCount() {
        return seasonGrannies_GivenCount;
    }

    public void setSeasonGranniesGivenCount(Integer granniesGiven) {
        this.seasonGrannies_GivenCount = granniesGiven;
    }

    public Integer getSeasonGranniesTakenCount() {
        return seasonGranniesTakenCount;
    }

    public void setSeasonGranniesTakenCount(Integer granniesTaken) {
        this.seasonGranniesTakenCount = granniesTaken;
    }

    public Integer getSeasonElo() {
        return seasonElo;
    }

    public void setSeasonElo(Integer eloScore) {
        this.seasonElo = eloScore;
    }

    // decode a representation of a player from the JSON serialized data
    // into a new player instance
    public static Player fromJson(JSONObject jsonObject) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Player player = gson.fromJson(jsonObject.toString(), Player.class);
        return player;
    }


    // decodes json array into player instances
    public static ArrayList<Player> fromJsonArray(JSONArray jsonArray) {
        JSONObject playerJson;

        ArrayList<Player> players = new ArrayList<Player>(jsonArray.length());

        for (int i=0; i < jsonArray.length(); i++) {
            try {
                playerJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Player player = Player.fromJson(playerJson);
            if (player != null) {
                players.add(player);
            }
        }

        return players;
    }

}
