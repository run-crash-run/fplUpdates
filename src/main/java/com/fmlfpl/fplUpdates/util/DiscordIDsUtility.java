package com.fmlfpl.fplUpdates.util;

import com.fmlfpl.fplUpdates.mappings.Standings;

import java.util.HashMap;

public class DiscordIDs {

    private static DiscordIDs discordIDs = new DiscordIDs();

    String fplID;
    String discordID;

    HashMap<String, Standings> League = new HashMap<String, Standings>();

    public void process(Standings s){
        //API will apply the tie breakers and return only one team for each position
        League.put(Integer.toString(s.getRank()), s);
    }




}
