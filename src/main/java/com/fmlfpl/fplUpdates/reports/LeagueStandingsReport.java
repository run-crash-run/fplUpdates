package com.fmlfpl.fplUpdates.reports;

import com.fmlfpl.fplUpdates.mappings.Standings;
import com.fmlfpl.fplUpdates.util.DiscordIDsUtility;

import java.util.HashMap;

import static com.fmlfpl.fplUpdates.FplUpdatesApplication.LINEBREAK;
import static com.fmlfpl.fplUpdates.FplUpdatesApplication.BREAK;

public class LeagueStandingsReport {

    private final String empty = "......................................";
    public String LeagueName;

    HashMap<String, Standings> League = new HashMap<String, Standings>();

    public void process(Standings s){
        //API will apply the tie breakers and return only one team for each position
        League.put(Integer.toString(s.getRank()), s);
    }

    public String printReport(){
        String returnString = "League Name: " + LeagueName + BREAK;
        returnString += LINEBREAK;
        returnString += "NOTE: THESE ARE THE CURRENT STANDINGS AS OF THE CURRENT GAMEWEEK!" + BREAK;
        returnString += LINEBREAK;

        for(int i = 1; i <= League.size(); i++){
            Standings s = League.get(Integer.toString(i));

            returnString +=
                    i + ": Points: " + s.getTotal() +
                    //", " + s.getPlayer_name() + empty.substring(s.getPlayer_name().length()) +
                    ", " + DiscordIDsUtility.getDiscordIDs().getDiscordIDGivenFplID(s.getEntry()) + empty.substring(DiscordIDsUtility.getDiscordIDs().getDiscordIDGivenFplID(s.getEntry()).length()) +
                    ", (" + s.getMatches_won() +
                    ", " + s.getMatches_drawn() +
                    ", " + s.getMatches_lost() + ")" +
                    ", Overall Points: " + s.getPoints_for() +
                    ", Previous Rank: " + s.getLast_rank() +
                    BREAK;
        }

        returnString += LINEBREAK;
        return returnString + LINEBREAK;
    }

    public void setLeagueName(String leagueName){
        this.LeagueName = leagueName;
    }

    public String getLeagueName(){
        return this.LeagueName;
    }
}
