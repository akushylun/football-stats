package com.akushylun.football.dao;

import java.util.List;

import com.akushylun.football.entities.Team;

public interface TeamDao {

    List<Team> getTeamList();

    Team getTeam(int id);

    void createTeam(Team team);

    void deleteTeam(int id);

    void updateTeam(Team team, int id);

}
