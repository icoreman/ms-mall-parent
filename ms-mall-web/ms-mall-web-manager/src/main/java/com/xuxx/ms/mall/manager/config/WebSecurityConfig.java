package com.xuxx.ms.mall.manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().headers().frameOptions().sameOrigin();

		// 允许所有用户访问"/"和"/index.html"
		http.authorizeRequests().antMatchers("/*.html", "/css/**", "/img/**", "/js/**", "/plugins/**").permitAll()
				.anyRequest().authenticated() // 其他地址的访问均需验证权限
				.and().formLogin().failureForwardUrl("/login.html").defaultSuccessUrl("/admin/index.html").permitAll().and().logout()
				.logoutSuccessUrl("/login.html");

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
