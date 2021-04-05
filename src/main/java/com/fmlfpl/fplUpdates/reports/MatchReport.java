package com.fmlfpl.fplUpdates.reports;

import com.fmlfpl.fplUpdates.mappings.Match;
import com.fmlfpl.fplUpdates.mappings.Result;
import com.fmlfpl.fplUpdates.mappings.Team;
import com.fmlfpl.fplUpdates.util.DiscordIDsUtility;

import java.util.ArrayList;
import java.util.List;

import static com.fmlfpl.fplUpdates.FplUpdatesApplication.BREAK;
import static com.fmlfpl.fplUpdates.FplUpdatesApplication.DIVIDER;
import static com.fmlfpl.fplUpdates.FplUpdatesApplication.LINEBREAK;

public class MatchReport {
    public List<Match> gwMatches = new ArrayList<Match>();

    public void process(Result r){
        Team team1 = new Team(r.getEntry_1_name(), r.getEntry_1_entry());
        Team team2 = new Team(r.getEntry_2_name(), r.getEntry_2_entry());

        gwMatches.add( new Match(r.getEvent(), team1, team2));
    }

    public String printReport(){
        String returnString = "Match Roundup" + BREAK;
        int count = 1;

        for(Match m : gwMatches){
            Team t1 = m.getTeam1();
            Team t2 = m.getTeam2();

            returnString += LINEBREAK;

            //team summary info
            returnString += "In match " + count++ + ", " + t1.getTeamName()+ " played against " + t2.getTeamName() + BREAK + DIVIDER;
            returnString += t1.getTeamName() + " is: " + DiscordIDsUtility.getDiscordIDs().getDiscordIDGivenFplID(t1.getTeamID()) + BREAK;
            returnString += t2.getTeamName() + " is: " + DiscordIDsUtility.getDiscordIDs().getDiscordIDGivenFplID(t2.getTeamID()) + BREAK;
            returnString += t1.getTeamName() + " link: <a>https://fantasy.premierleague.com/entry/" + t1.getTeamID() + "/event/" + t1.getThisGameweek().getEvent() + BREAK;
            returnString += t2.getTeamName() + "link: https://fantasy.premierleague.com/entry/" + t2.getTeamID() + "/event/" + t2.getThisGameweek().getEvent() + BREAK;

            //results
            returnString += DIVIDER + "Match Result: " + BREAK;
            returnString += "" + t1.getTeamName() + " " + t1.getThisGameweek().getPoints() + " ::: " + t2.getThisGameweek().getPoints() + " " + t2.getTeamName() + BREAK;

            returnString += DIVIDER + "Additional: " + BREAK;
            returnString += t1.getTeamName() + " had " + t1.getThisGameweek().getPoints_on_bench() + " points on the bench!" + BREAK;
            returnString += t2.getTeamName() + " had " + t2.getThisGameweek().getPoints_on_bench() + " points on the bench!" + BREAK;

            //check chip in play
            if(null != t1.getThisGameweek().getActive_chip()){ returnString += t1.getTeamName() + " used a chip: " + t1.getThisGameweek().getActive_chip() + BREAK;}
            if(null != t2.getThisGameweek().getActive_chip()){ returnString += t2.getTeamName() + " used a chip: " + t2.getThisGameweek().getActive_chip() + BREAK;}

            //check hits
            if(0 != t1.getThisGameweek().getEvent_transfers_cost()){ returnString +=t1.getTeamName() + " took a hit of: " + t1.getThisGameweek().getEvent_transfers_cost() + BREAK;}
            if(0 != t2.getThisGameweek().getEvent_transfers_cost()){ returnString +=t2.getTeamName() + " took a hit of: " + t2.getThisGameweek().getEvent_transfers_cost() + BREAK;}

            returnString += LINEBREAK;

        }

        return returnString + BREAK;
    }
}
