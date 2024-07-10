package com.example.ctrl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity


public class WebSecurityController extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource  ds;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		auth.jdbcAuthentication()
			.dataSource(ds) 
			.withDefaultSchema()	// two tables will be created in H2 DB
			.withUser("Nalla")
				.password(encoder.encode("nalla"))
					.roles("USER")
			.and()
				.withUser("Admin")
					.password(encoder.encode("admin"))
						.roles("ADMIN")
			.and()
				.withUser("Mgr")
					.password(encoder.encode("mgr"))
						.roles("MANAGER");			
	}
 
//RESTART the Server
// Role Based resource access
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			 .antMatchers("/admin").hasRole("ADMIN")
			 .antMatchers("/user").hasAnyRole("ADMIN", "USER")
			 .antMatchers("/").permitAll()
			 .antMatchers("/mgr").hasRole("MANAGER")
			 .and().formLogin();
			 
		//h2 console
			http.csrf().disable();
			http.headers().frameOptions().disable();
	}
}

