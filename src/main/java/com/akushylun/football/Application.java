package com.akushylun.football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.akushylun.football.dao.AccountDao;
import com.akushylun.football.entities.Account;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

    @Configuration
    class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	AccountDao accountDao;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
	    return new UserDetailsService() {

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		    Account account = accountDao.findByUsername(username);
		    if (account != null) {
			return new User(account.getUsername(), account.getPassword(), true, true, true, true,
				AuthorityUtils.createAuthorityList("USER"));
		    } else {
			throw new UsernameNotFoundException("could not find the user '" + username + "'");
		    }
		}

	    };
	}
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();
	}

    }

}
