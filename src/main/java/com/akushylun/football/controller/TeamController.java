package com.akushylun.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akushylun.football.dao.TeamDao;
import com.akushylun.football.entities.Team;

@RestController
@RequestMapping("/teams")
public class TeamController {

    TeamDao dao;

    @Autowired
    public TeamController(TeamDao dao) {
	this.dao = dao;
    }

    @RequestMapping(method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public List<Team> getTeams() {
	return dao.getTeamList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Team getTeam(@PathVariable int id) {
	return dao.getTeam(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeam(@PathVariable int id) {
	dao.deleteTeam(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateTeam(@RequestBody Team team, @PathVariable int id) {
	dao.updateTeam(team, id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createTeam(@RequestBody Team team) {
	dao.createTeam(team);
    }
}
