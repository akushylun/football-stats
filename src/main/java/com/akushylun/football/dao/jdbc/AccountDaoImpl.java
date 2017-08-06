package com.akushylun.football.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.akushylun.football.dao.AccountDao;
import com.akushylun.football.entities.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

    private static final String GET_ACCOUNT = "SELECT * FROM account WHERE username = ?";
    private static final String SAVE_ACCOUNT = "INSERT into account (id, password, username) VALUES (?,?,?)";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account findByUsername(String username) {
	return jdbcTemplate.queryForObject(GET_ACCOUNT, new Object[] { username }, new AccountRowMapper());
    }

    private static final class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
	    return new Account.Builder().withId(rs.getInt("id")).withUserName(rs.getString("username"))
		    .withPassword(rs.getString("password")).build();
	}
    }

    @Override
    public void save(Account account) {
	jdbcTemplate.update(SAVE_ACCOUNT, account.getId(), account.getPassword(), account.getUsername());
    }

}
