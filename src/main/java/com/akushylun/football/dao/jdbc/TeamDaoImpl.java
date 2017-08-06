package com.akushylun.football.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.akushylun.football.dao.TeamDao;
import com.akushylun.football.entities.Team;

@Repository
public class TeamDaoImpl implements TeamDao {

    private static final String GET_TEAMS = "SELECT * FROM team";
    private static final String GET_TEAM_BY_ID = "SELECT * FROM team WHERE id = ?";
    private static final String CREATE_TEAM = "INSERT INTO team (id, name, gamesWon, gamesLost, gamesDraw) VALUES (?,?,?,?,?)";
    private static final String DELETE_TEAM = "DELETE FROM team WHERE id = ?";
    private static final String UPDATE_TEAM = "UPDATE team SET name = ?, gamesWon = ?, gamesLost = ?, gamesDraw = ? WHERE id = ?";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public TeamDaoImpl(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Team> getTeamList() {
	List<Team> teams = jdbcTemplate.query(GET_TEAMS, new BeanPropertyRowMapper(Team.class));
	return teams;
    }

    @Override
    public Team getTeam(int id) {
	return jdbcTemplate.queryForObject(GET_TEAM_BY_ID, new Object[] { id }, new TeamRowMapper());
    }

    @Override
    public void createTeam(Team team) {
	jdbcTemplate.update(CREATE_TEAM, team.getId(), team.getName(), team.getGamesWon(), team.getGamesLost(),
		team.getGamesDraw());
    }

    @Override
    public void deleteTeam(int id) {
	jdbcTemplate.update(DELETE_TEAM, id);
    }

    @Override
    public void updateTeam(Team team, int id) {
	jdbcTemplate.update(UPDATE_TEAM, team.getName(), team.getGamesWon(), team.getGamesLost(), team.getGamesDraw(),
		id);
    }

    private static final class TeamRowMapper implements RowMapper<Team> {

	@Override
	public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
	    return new Team.Builder().withId(rs.getInt("id")).withName(rs.getString("name"))
		    .withGamesWon(rs.getInt("gamesWon")).withGamesLost(rs.getInt("gamesLost"))
		    .withDraw(rs.getInt("gamesDraw")).build();

	}
    }
}
