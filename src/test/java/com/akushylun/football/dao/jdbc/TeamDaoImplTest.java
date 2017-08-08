package com.akushylun.football.dao.jdbc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.akushylun.football.dao.TeamDao;
import com.akushylun.football.entities.Team;

public class TeamDaoImplTest {

    private EmbeddedDatabase db;
    TeamDao teamDao;

    @Before
    public void setUp() {
	db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:schema.sql")
		.addScript("classpath:test-data.sql").build();
    }

    @Test
    public void testFindById() {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(db);
	teamDao = new TeamDaoImpl(jdbcTemplate);
	Team team = teamDao.getTeam(1);

	Assert.assertNotNull(team);
	Assert.assertEquals(1, team.getId());
	Assert.assertEquals("Manchester", team.getName());
	Assert.assertEquals(10, team.getGamesWon());
	Assert.assertEquals(2, team.getGamesLost());
	Assert.assertEquals(5, team.getGamesDraw());

    }

    @After
    public void tearDown() {
	db.shutdown();
    }

}
