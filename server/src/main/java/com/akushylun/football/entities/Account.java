package com.akushylun.football.entities;

public class Account {

    private int id;
    private String username;
    private String password;

    private Account(Builder builder) {
	this.id = builder.id;
	this.username = builder.username;
	this.password = builder.password;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public static class Builder {
	private int id;
	private String username;
	private String password;

	public Builder withId(int id) {
	    this.id = id;
	    return this;
	}

	public Builder withUserName(String username) {
	    this.username = username;
	    return this;
	}

	public Builder withPassword(String password) {
	    this.password = password;
	    return this;
	}

	public Account build() {
	    return new Account(this);
	}

    }

}
