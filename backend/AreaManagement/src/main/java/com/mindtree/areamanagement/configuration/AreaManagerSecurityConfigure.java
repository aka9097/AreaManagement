package com.mindtree.areamanagement.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mindtree.areamanagement.modules.admin.service.AdminService;
import com.mindtree.areamanagement.modules.admin.service.impl.AdminServiceImpl;
import com.mindtree.areamanagement.modules.user.service.UserService;

@Configuration
@EnableWebSecurity
@Order(2)
public class AreaManagerSecurityConfigure extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	
//	@Bean
//	public HttpSessionEventPublisher httpSessionEventPublisher() {
//	    return new HttpSessionEventPublisher();
//	}
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}

    @Override
    protected void configure(HttpSecurity http) 
      throws Exception {
        http.csrf().disable()
          .authorizeRequests()
          .antMatchers("/genies/areamanager/{email}","/genie/status/{genieId}","/areamanager/**","/user").permitAll()//.hasAuthority("AREAMANAGER")
          .antMatchers("/user/**","/user","/areamanager/**","genie/areamanager/{email}","/location","/areamanagerupdateprofile/**","/raiseGenie/{email}","/genie/{genieId}","/genie/user/{email}","/currentuser","/genies/{genieId}").permitAll()//.hasAuthority("USER")
          .antMatchers("/areamanagerLogin","/getUsers").permitAll()
          .antMatchers("/admin/**","/admin").permitAll()
          .antMatchers("/updateUserProfile").permitAll()
          .antMatchers("/address","/address/**").permitAll()
          .antMatchers("/allAddressDetails").permitAll()
          .antMatchers("/deleteAddress/{id}").permitAll()
          .antMatchers("/updateAddress/{id}").permitAll()
          .antMatchers("/areamanagers/**").permitAll()
          .antMatchers("/geniee/{userEmail}").permitAll()
          .antMatchers("/genie/{genieId}").permitAll()
          .antMatchers("/deleteUser/{email}").permitAll()
          .antMatchers("/genies/areamanager/{email}").permitAll()
          .antMatchers("/users","/users/**").permitAll()
          .antMatchers("/users","/users/**").permitAll()
          .antMatchers("/raiseGenie/**","/genie/**","/getAllGenieDetails","/location/**","/genie/user/{email}").permitAll()
//          .antMatchers("/admin/{email}/{password}").permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .formLogin()
          .loginPage("/login").permitAll()
          .and()
          .httpBasic()
          .and()
 		  .logout().invalidateHttpSession(true).deleteCookies("JSESSIONID").clearAuthentication(true)
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
          .logoutSuccessUrl("/").permitAll()
          .and().sessionManagement()
          .maximumSessions(5);
//          .sessionRegistry(sessionRegistry());
    }

	

}
