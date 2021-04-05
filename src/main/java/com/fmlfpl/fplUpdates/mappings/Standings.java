package com.fmlfpl.fplUpdates.mappings;

public class Standings {

    int id;
    int division;
    int entry;
    String player_name;
    int rank;
    int last_rank;
    int rank_sort;
    int total;
    String entry_name;
    int matches_played;
    int matches_won;
    int matches_drawn;
    int matches_lost;
    int points_for;

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getLast_rank() {
        return last_rank;
    }

    public void setLast_rank(int last_rank) {
        this.last_rank = last_rank;
    }

    public int getRank_sort() {
        return rank_sort;
    }

    public void setRank_sort(int rank_sort) {
        this.rank_sort = rank_sort;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEntry_name() {
        return entry_name;
    }

    public void setEntry_name(String entry_name) {
        this.entry_name = entry_name;
    }

    public int getMatches_played() {
        return matches_played;
    }

    public void setMatches_played(int matches_played) {
        this.matches_played = matches_played;
    }

    public int getMatches_won() {
        return matches_won;
    }

    public void setMatches_won(int matches_won) {
        this.matches_won = matches_won;
    }

    public int getMatches_drawn() {
        return matches_drawn;
    }

    public void setMatches_drawn(int matches_drawn) {
        this.matches_drawn = matches_drawn;
    }

    public int getMatches_lost() {
        return matches_lost;
    }

    public void setMatches_lost(int matches_lost) {
        this.matches_lost = matches_lost;
    }

    public int getPoints_for() {
        return points_for;
    }

    public void setPoints_for(int points_for) {
        this.points_for = points_for;
    }
}
