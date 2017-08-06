package com.akushylun.football.entities;

public class Team {

    private int id;
    private String name;
    private int gamesWon;
    private int gamesLost;
    private int gamesDraw;

    public Team() {
    }

    private Team(Builder builder) {
	this.id = builder.id;
	this.name = builder.name;
	this.gamesWon = builder.gamesWon;
	this.gamesLost = builder.gamesLost;
	this.gamesDraw = builder.gamesDraw;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getGamesWon() {
	return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
	this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
	return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
	this.gamesLost = gamesLost;
    }

    public int getGamesDraw() {
	return gamesDraw;
    }

    public void setGamesDraw(int gamesDraw) {
	this.gamesDraw = gamesDraw;
    }

    public static class Builder {

	private int id;
	private String name;
	private int gamesWon;
	private int gamesLost;
	private int gamesDraw;

	public Builder withId(int id) {
	    this.id = id;
	    return this;
	}

	public Builder withName(String name) {
	    this.name = name;
	    return this;
	}

	public Builder withGamesWon(int gamesWon) {
	    this.gamesWon = gamesWon;
	    return this;
	}

	public Builder withGamesLost(int gamesLost) {
	    this.gamesLost = gamesLost;
	    return this;
	}

	public Builder withDraw(int gamesDraw) {
	    this.gamesDraw = gamesDraw;
	    return this;
	}

	public Team build() {
	    return new Team(this);
	}

    }

}
