package com.fmlfpl.fplUpdates.mappings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fmlfpl.fplUpdates.util.DiscordIDsUtility;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Team {
    String endpointPrefix = "https://fantasy.premierleague.com/api/entry/";
    String endpointSuffix = "/event/29/picks/";

    String teamName;
    int teamID;
    String discordID;
    String activeChip ;
    int benchPoints;

    EventHistory thisGameweek;

    public Team(String teamName, int teamID) {
        this.teamName = teamName;
        this.teamID = teamID;
        this.discordID = DiscordIDsUtility.getDiscordIDs().getDiscordIDGivenFplID(teamID);
        this.fetchRawTeamData(teamID);
    }

    private void fetchRawTeamData(int teamID){
        String endpoint = endpointPrefix + teamID + endpointSuffix;

        Document doc = null;
        try {
            Connection connection = Jsoup.connect(endpoint);
            doc = Jsoup.connect(endpoint).ignoreContentType(true).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong fetching the json...");
        }

        //Chip information appears outside the team json
        String active_chip = "active_chip";
        String chipInfo = doc.body().toString();
        chipInfo = chipInfo.substring(chipInfo.indexOf(active_chip) + 14);
        chipInfo = chipInfo.substring(0, chipInfo.indexOf("\""));

        //Kludge, order of elements is not guaranteed due to inconsistent metadata getting added, proper solution is to find out all the metadata that could be included and map that too
        String rawResponse = doc.body().toString();
        rawResponse = rawResponse.substring(rawResponse.indexOf("entry_history") + 15); //substring from entry history to end
        rawResponse = rawResponse.substring(0, rawResponse.indexOf("},") + 1); //trim everything after the closing bracket of event history

        if("ull," != chipInfo){
            rawResponse = rawResponse.substring(0, rawResponse.length()-1) + ", \"active_chip\":\"" + chipInfo + "\"}";
            rawResponse.substring(0);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            thisGameweek = mapper.readValue(rawResponse, EventHistory.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong with the object mapper");
        }
    }

    public String getEndpointPrefix() {
        return endpointPrefix;
    }

    public void setEndpointPrefix(String endpointPrefix) {
        this.endpointPrefix = endpointPrefix;
    }

    public String getEndpointSuffix() {
        return endpointSuffix;
    }

    public void setEndpointSuffix(String endpointSuffix) {
        this.endpointSuffix = endpointSuffix;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getDiscordID() {
        return discordID;
    }

    public void setDiscordID(String discordID) {
        this.discordID = discordID;
    }

    public String getActiveChip() {
        return activeChip;
    }

    public void setActiveChip(String activeChip) {
        this.activeChip = activeChip;
    }

    public int getBenchPoints() {
        return benchPoints;
    }

    public void setBenchPoints(int benchPoints) {
        this.benchPoints = benchPoints;
    }

    public EventHistory getThisGameweek() {
        return thisGameweek;
    }

    public void setThisGameweek(EventHistory thisGameweek) {
        this.thisGameweek = thisGameweek;
    }
}
