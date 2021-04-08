package com.fmlfpl.fplUpdates.reports;

import static com.fmlfpl.fplUpdates.util.DiscordIDsUtility.getDiscordIDs;

import static com.fmlfpl.fplUpdates.FplUpdatesApplication.BREAK;
import static com.fmlfpl.fplUpdates.FplUpdatesApplication.LINEBREAK;

public class LeagueReport {
    //summary values
    int topScore = 0;
    public int topScoringTeamID = -1;

    int lowestScore = Integer.MAX_VALUE;
    public int lowestScoringTeamID = -1;

    int totalScore = 0;
    int totalTeams = 0;
    int averageScore = 0;

    int biggestDiff = 0;
    public int biggestDiffWinningTeamID = -1;
    public int biggestDiffLosingTeamID = -1;

    int smallestDiff = 0;
    int numDraws = 0;

    //Utility Methods
    public void checkTopScore(int score, int teamID){
        if(score > topScore){
            topScore = score;
            topScoringTeamID = teamID;
        }
    }

    public void checkLowestScore(int score, int teamID){
        if(score < lowestScore){
            lowestScore = score;
            lowestScoringTeamID = teamID;
        }
    }

    public void incrementTotalScore(int score){
        totalScore += score;
    }

    public void incrementTotalTeams(int numTeams){
        totalTeams += numTeams;
    }

    public void checkDiff(int points1, int id1, int points2, int id2){
        //omit draws from the diff, when calculating the smallest narrowest win margin we want to omit draws
        if(points1 == points2){return;}

        int diff = Math.abs(points1 - points2);

        if(diff > biggestDiff){
            this.biggestDiff = diff;

            if(points1 > points2){this.biggestDiffWinningTeamID = id1; this.biggestDiffLosingTeamID = id2;}
            else{this.biggestDiffWinningTeamID = id2; this.biggestDiffLosingTeamID = id1;}
        }
    }

    public void calculateAverage(){
        if(totalTeams < 1){ averageScore = 0;}
        else {averageScore = totalScore / totalTeams;};
    }

    public void process(int points1, int id1, int points2, int id2){
        this.checkTopScore(points1, id1);
        this.checkTopScore(points2, id2);
        this.checkLowestScore(points1, id1);
        this.checkLowestScore(points2, id2);
        this.checkDiff(points1, id1, points2, id2);
        this.incrementTotalScore(points1 + points2);
        this.incrementTotalTeams(2);
        this.calculateAverage();
    }

    public String printReport(){
        String returnString = "";

        returnString += LINEBREAK;
        returnString += "League Roundup: " + BREAK;
        returnString += "The team with the top score was: " + getTopScore() + ", by: " + getDiscordIDs().getDiscordIDGivenFplID(topScoringTeamID) + BREAK;
        returnString += "The team with the lowest score was: " + getLowestScore() + ", by: " + getDiscordIDs().getDiscordIDGivenFplID(lowestScoringTeamID) + BREAK;
        returnString += "The biggest winning margin was: " + getBiggestDiff() + ", by: " + getDiscordIDs().getDiscordIDGivenFplID(biggestDiffWinningTeamID) + " against " + getDiscordIDs().getDiscordIDGivenFplID(biggestDiffLosingTeamID) + BREAK;
        returnString += "The combined points total in this league was: " + getTotalScore() + BREAK;
        returnString += "The average weekly score in this league was: " + getAverageScore() + BREAK;
        returnString += LINEBREAK;

        return returnString;
    }

    //Getters and Setters

    public int getTopScore() {
        return topScore;
    }

    public void setTopScore(int topScore) {
        this.topScore = topScore;
    }

    public int getTopScoringTeamID() {
        return topScoringTeamID;
    }

    public void setTopScoringTeamID(int topScoringTeamID) {
        this.topScoringTeamID = topScoringTeamID;
    }

    public int getLowestScore() {
        return lowestScore;
    }

    public void setLowestScore(int lowestScore) {
        this.lowestScore = lowestScore;
    }

    public int getLowestScoringTeamID() {
        return lowestScoringTeamID;
    }

    public void setLowestScoringTeam(int lowestScoringTeamID) {
        this.lowestScoringTeamID = lowestScoringTeamID;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalTeams() {
        return totalTeams;
    }

    public void setTotalTeams(int totalTeams) {
        this.totalTeams = totalTeams;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getBiggestDiff() {
        return biggestDiff;
    }

    public void setBiggestDiff(int biggestDiff) {
        this.biggestDiff = biggestDiff;
    }

    public int getBiggestDiffWinningTeamID() {
        return biggestDiffWinningTeamID;
    }

    public void setBiggestDiffWinningTeamID(int biggestDiffWinningTeamID) {
        this.biggestDiffWinningTeamID = biggestDiffWinningTeamID;
    }

    public int getBiggestDiffLosingTeamID() {
        return biggestDiffLosingTeamID;
    }

    public void setBiggestDiffLosingTeam(int biggestDiffLosingTeamID) {
        this.biggestDiffLosingTeamID = biggestDiffLosingTeamID;
    }

    public int getSmallestDiff() {
        return smallestDiff;
    }

    public void setSmallestDiff(int smallestDiff) {
        this.smallestDiff = smallestDiff;
    }

    public int getNumDraws() {
        return numDraws;
    }

    public void setNumDraws(int numDraws) {
        this.numDraws = numDraws;
    }
}
