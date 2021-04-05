package com.fmlfpl.fplUpdates.util;
import java.util.HashMap;

public class DiscordIDsUtility {

    private static DiscordIDsUtility discordIDsUtility;
    //order: <key>fpl id, <value>discord id
    private HashMap<String, String> idMappings = new HashMap<String, String>();

    private DiscordIDsUtility(){
        //FMLFPL discord team names
        this.idMappings.put("10217", "@Null#2610");
    }

    public static DiscordIDsUtility getDiscordIDs(){
        if(discordIDsUtility == null){
            discordIDsUtility = new DiscordIDsUtility();
        }
        return discordIDsUtility;
    }

    public HashMap<String, String> getIdMappings() {
        return idMappings;
    }

    public void setIdMappings(HashMap<String, String> idMappings) {
        this.idMappings = idMappings;
    }

    public String getDiscordIDGivenFplID(int fplid){
        String idNotFound = "Unknown discord id for FPL ID: " + fplid;

        if (this.getIdMappings().containsKey(Integer.toString(fplid))){
            return this.getIdMappings().get(Integer.toString(fplid));
        }
        else{
            return idNotFound;
        }
    }
}
