//package com.mindtree.areamanagement.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.mindtree.areamanagement.modules.admin.service.impl.AdminServiceImpl;
//
//@Configuration
//@EnableWebSecurity
//@Order(1)
//public class AdminSecurityConfigure extends WebSecurityConfigurerAdapter{
//
//	@Autowired
//	private AdminServiceImpl adminService;
//	
//	@Bean
//	public AuthenticationProvider authProviderforAdmin() {
//		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//		provider.setUserDetailsService(adminService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		return provider;
//	}
//	@Override
//	protected void configure(HttpSecurity http) 
//		      throws Exception {
//		http.csrf().disable()
//        .authorizeRequests()
////        .antMatchers("/genies/areamanager/{email}","/genie/status/{genieId}","/areamanager/**","/user").hasAuthority("AREAMANAGER")
//        .antMatchers("/user/**","/user","/areamanager/**","/areamanagerupdateprofile/**","/raiseGenie/{email}","/genie/{genieId}","/genie/user/{email}","/currentuser").permitAll()//.hasAuthority("USER")
//        .antMatchers("/getUsers").permitAll()
//        .antMatchers("/admin/**","/admin").permitAll()
//        .antMatchers("/updateUserProfile").permitAll()
//        .antMatchers("/address","/address/**").permitAll()
//        .antMatchers("/allAddressDetails").permitAll()
//        .antMatchers("/deleteAddress/{id}").permitAll()
//        .antMatchers("/updateAddress/{id}").permitAll()
//        .antMatchers("/admin/updateprofile").permitAll()
//        .antMatchers("/location").permitAll()
//        .antMatchers("/users").permitAll()
//        .antMatchers("/areamanagers").permitAll()
//        .antMatchers("/areamanager/{email}").permitAll()
//        .antMatchers("/user/{email}").permitAll()
//        .antMatchers("/location/{locationName}").permitAll()
//        .antMatchers("/location/{id}").permitAll()
//        .antMatchers("/location").permitAll()
//        .antMatchers("/location/{locationName}").permitAll()
//        .antMatchers("/user/{email}").permitAll()
//        .antMatchers("/deleteUser/{email}").permitAll()
//        .antMatchers("/areamanagers/{locationName}").permitAll()
//        .antMatchers("/users/{locationName}").permitAll()
//        .antMatchers("/getGenie/{genieId}").permitAll()
//        .antMatchers("/genie/{genieId}").permitAll()
//        .antMatchers("/genie").permitAll()
//    
//        .antMatchers("/admin/{email}/{password}").permitAll()
//        .antMatchers("/raiseGenie/**","/genie/**","/getAllGenieDetails","/location/**","/genie/user/{email}").permitAll()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .formLogin()
//        .loginPage("/adminLogin").permitAll()
//        .and()
//        .httpBasic()
//        .and()
//		  .logout().invalidateHttpSession(true).deleteCookies("JSESSIONID").clearAuthentication(true)
//        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//        .logoutSuccessUrl("/").permitAll()
//        .and().sessionManagement()
//        .maximumSessions(5);
////        .sessionRegistry(sessionRegistry());
//  }
//}
