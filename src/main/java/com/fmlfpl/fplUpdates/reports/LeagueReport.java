package com.fmlfpl.fplUpdates.reports;

import static com.fmlfpl.fplUpdates.FplUpdatesApplication.BREAK;
import static com.fmlfpl.fplUpdates.FplUpdatesApplication.LINEBREAK;

public class LeagueReport {
    //summary values
    int topScore = 0;
    public String topScoringTeam = "";

    int lowestScore = Integer.MAX_VALUE;
    public String lowestScoringTeam = "";

    int totalScore = 0;
    int totalTeams = 0;
    int averageScore = 0;

    int biggestDiff = 0;
    public String biggestDiffWinningTeam = "";
    public String biggestDiffLosingTeam = "";

    int smallestDiff = 0;
    int numDraws = 0;

    //Utility Methods
    public void checkTopScore(int score, String teamName){
        if(score > topScore){
            topScore = score;
            topScoringTeam = teamName;
        }
    }

    public void checkLowestScore(int score, String teamName){
        if(score < lowestScore){
            lowestScore = score;
            lowestScoringTeam = teamName;
        }
    }

    public void incrementTotalScore(int score){
        totalScore += score;
    }

    public void incrementTotalTeams(int numTeams){
        totalTeams += numTeams;
    }

    public void checkDiff(int points1, String team1, int points2, String team2){
        //omit draws from the diff, when calculating the smallest narrowest win margin we want to omit draws
        if(points1 == points2){return;}

        int diff = Math.abs(points1 - points2);

        if(diff > biggestDiff){
            this.biggestDiff = diff;

            if(points1 > points2){this.biggestDiffWinningTeam = team1; this.biggestDiffLosingTeam = team2;}
            else{this.biggestDiffWinningTeam = team2; this.biggestDiffLosingTeam = team1;}
        }
    }

    public void calculateAverage(){
        if(totalTeams < 1){ averageScore = 0;}
        else {averageScore = totalScore / totalTeams;};
    }

    public void process(int points1, String name1, int points2, String name2){
        this.checkTopScore(points1, name1);
        this.checkTopScore(points2, name2);
        this.checkLowestScore(points1, name1);
        this.checkLowestScore(points2, name2);
        this.checkDiff(points1, name1, points2, name2);
        this.incrementTotalScore(points1 + points2);
        this.incrementTotalTeams(2);
        this.calculateAverage();
    }

    public String printReport(){
        String returnString = "";

        returnString += LINEBREAK;
        returnString += "League Roundup: " + BREAK;
        returnString += "The team with the top score was: " + getTopScore() + ", by: " + topScoringTeam + BREAK;
        returnString += "The team with the lowest score was: " + getLowestScore() + ", by: " + lowestScoringTeam + BREAK;
        returnString += "The biggest winning margin was: " + getBiggestDiff() + ", by: " + biggestDiffWinningTeam + " against " + biggestDiffLosingTeam + BREAK;
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

    public String getTopScoringTeam() {
        return topScoringTeam;
    }

    public void setTopScoringTeam(String topScoringTeam) {
        this.topScoringTeam = topScoringTeam;
    }

    public int getLowestScore() {
        return lowestScore;
    }

    public void setLowestScore(int lowestScore) {
        this.lowestScore = lowestScore;
    }

    public String getLowestScoringTeam() {
        return lowestScoringTeam;
    }

    public void setLowestScoringTeam(String lowestScoringTeam) {
        this.lowestScoringTeam = lowestScoringTeam;
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

    public String getBiggestDiffWinningTeam() {
        return biggestDiffWinningTeam;
    }

    public void setBiggestDiffWinningTeam(String biggestDiffWinningTeam) {
        this.biggestDiffWinningTeam = biggestDiffWinningTeam;
    }

    public String getBiggestDiffLosingTeam() {
        return biggestDiffLosingTeam;
    }

    public void setBiggestDiffLosingTeam(String biggestDiffLosingTeam) {
        this.biggestDiffLosingTeam = biggestDiffLosingTeam;
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
