package com.akushylun.football.dao;

import com.akushylun.football.entities.Account;

public interface AccountDao {

    public Account findByUsername(String username);

    public void save(Account build);

}
