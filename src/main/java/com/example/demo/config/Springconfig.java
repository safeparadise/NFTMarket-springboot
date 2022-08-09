package com.example.demo.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class Springconfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.usersByUsernameQuery("select username,password, enabled from users where username = ? ")
		.authoritiesByUsernameQuery("select username,roles from authorities where username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/","/css/**","/js/**","/img/**","/loginUser/**","/productsTbl","/pro","/product/**","/edit/**")
		.permitAll().antMatchers("/products/**").hasAuthority("ADMIN")
		.anyRequest().authenticated().and().formLogin().loginPage("/login").usernameParameter("username").permitAll().and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/notfound");
	}

	
}
