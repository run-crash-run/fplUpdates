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
        Team team1 = new Team(r.getEntry_1_name(), r.getEntry_1_entry(), r.getEvent());
        Team team2 = new Team(r.getEntry_2_name(), r.getEntry_2_entry(), r.getEvent());

        gwMatches.add( new Match(r.getEvent(), team1, team2));
    }

    public String printReport(int averageScore){
        String returnString = "Match Roundup" + BREAK ;
        int count = 1;

        for(Match m : gwMatches){
            Team t1 = m.getTeam1();
            Team t2 = m.getTeam2();

            returnString += LINEBREAK;

            String team1Discord = DiscordIDsUtility.getDiscordIDs().getDiscordIDGivenFplID(t1.getTeamID()) ;
            String team2Discord = DiscordIDsUtility.getDiscordIDs().getDiscordIDGivenFplID(t2.getTeamID()) ;

            //team summary info
            returnString += "In match " + count++ + ", " + team1Discord + " played against " + team2Discord + BREAK;

            //results
            returnString += DIVIDER + "Match Result: " + BREAK;

//            int team1Points = 0;
//            int team2Points = 0;
//
//            if (0 == t1.getTeamID()){
//                team1Points = averageScore;
//            }
//            else{team1Points = t1.getThisGameweek().getPoints();}
//            if (0 == t2.getTeamID()){
//                team2Points = averageScore;
//            }
//            else{team2Points = t2.getThisGameweek().getPoints();}



            returnString += "" + team1Discord + " " + t1.getThisGameweek().getPoints() + " ::: " + t2.getThisGameweek().getPoints() + " " + team2Discord + BREAK;

            returnString += DIVIDER + "Additional: " + BREAK;
            returnString += team1Discord + " had " + t1.getThisGameweek().getPoints_on_bench() + " points on the bench!" + BREAK;
            returnString += team2Discord + " had " + t2.getThisGameweek().getPoints_on_bench() + " points on the bench!" + BREAK;

            //check chip in play
            if(null != t1.getThisGameweek().getActive_chip()){ returnString += team1Discord + " used a chip: " + t1.getThisGameweek().getActive_chip() + BREAK;}
            if(null != t2.getThisGameweek().getActive_chip()){ returnString += team2Discord + " used a chip: " + t2.getThisGameweek().getActive_chip() + BREAK;}

            //check hits
            if(0 != t1.getThisGameweek().getEvent_transfers_cost()){ returnString += team1Discord + " took a hit of: " + t1.getThisGameweek().getEvent_transfers_cost() + BREAK;}
            if(0 != t2.getThisGameweek().getEvent_transfers_cost()){ returnString += team2Discord + " took a hit of: " + t2.getThisGameweek().getEvent_transfers_cost() + BREAK;}

            returnString += DIVIDER;
            returnString +=  team1Discord  + " is: " + t1.getTeamName() + BREAK;
            returnString +=  team2Discord  + " is: " + t2.getTeamName() + BREAK;
            returnString += team1Discord + " link: <a>https://fantasy.premierleague.com/entry/" + t1.getTeamID() + "/event/" + t1.getThisGameweek().getEvent() + BREAK;
            returnString += team2Discord + "link: https://fantasy.premierleague.com/entry/" + t2.getTeamID() + "/event/" + t2.getThisGameweek().getEvent() + BREAK;

            returnString += LINEBREAK;
        }

        return returnString + BREAK;
    }
}
