package com.abogiida.erdata.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.abogiida.erdata.security.SuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired	
	private UserDetailsService userDetailsService;	
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
		  auth.userDetailsService(userDetailsService)
	          .passwordEncoder(bCryptPasswordEncoder);
	  }

	  
	  @Bean
	  public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	        return new SuccessHandler();
	    }
	  
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
		 
		 http.authorizeRequests()
		     .antMatchers("/").permitAll()
		     .antMatchers("/actuator/**").permitAll()
		     .antMatchers("/login").permitAll()
		     .antMatchers("/register").permitAll()
		     .antMatchers("/register/recieverRegistration").permitAll()
		     .antMatchers("/index").permitAll()
		     .antMatchers("/profile").hasAnyAuthority("DONOR","RECIEVER")
		     .antMatchers("/job").hasAnyAuthority("DONOR","RECIEVER")
		     .antMatchers("/news").hasAuthority("DONOR")
		     .antMatchers("/jobView").hasAuthority("RECIEVER")
		     .antMatchers("/newsView").hasAnyAuthority("DONOR","RECIEVER")
		     .antMatchers("/freeAid").hasAuthority("DONOR")
		     .antMatchers("/recieverFreeAid").hasAuthority("RECIEVER")
		     .antMatchers("/freeAid/**").hasAuthority("DONOR")
		     .antMatchers("/comment").hasAnyAuthority("DONOR","RECIEVER")
		     .anyRequest().authenticated()
		     .and()
		     	.formLogin()
		     			.loginPage("/login")
		     			.failureUrl("/login?error=true")
		     			.successHandler(myAuthenticationSuccessHandler())
		     			
		     .and()
		     	.logout()
		     			.invalidateHttpSession(true)
		     			.clearAuthentication(true)
		     			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		     			.logoutSuccessUrl("/login?logout")
	     	.and()
		     	.exceptionHandling()
		     	.accessDeniedPage("/access-denied");
	  }
	 
	 @Override
	 public void configure(WebSecurity webSecurity) throws Exception {
		 
		 webSecurity.ignoring()
		 			.antMatchers("/resources/**","/static/**","/css/**","/js/**","/images/**");
	 }
}
