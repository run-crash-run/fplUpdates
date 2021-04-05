package com.fmlfpl.fplUpdates.mappings;

public class Match {
    int GW;
    Team team1;
    Team team2;

    public Match(int GW, Team team1, Team team2) {
        this.GW = GW;
        this.team1 = team1;
        this.team2 = team2;
    }

    public int getGW() {
        return GW;
    }

    public void setGW(int GW) {
        this.GW = GW;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
}
