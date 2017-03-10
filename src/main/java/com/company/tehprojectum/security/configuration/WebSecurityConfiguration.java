package com.company.tehprojectum.security.configuration;

import com.company.tehprojectum.security.AuthenticationTokenFilter;
import com.company.tehprojectum.security.responses.EntryPointUnauthorizedHandler;
import com.company.tehprojectum.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /** http://stackoverflow.com/questions/41480102/how-spring-security-filter-chain-works **/
    /** https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#form-login-filter **/
        /**https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#jc-form**/

  @Autowired
  private EntryPointUnauthorizedHandler unauthorizedHandler;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder
      .userDetailsService(this.userDetailsService)
        .passwordEncoder(passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
        authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
        /****/
        /****/
//        authenticationTokenFilter.setUsernameParameter("login");
//        authenticationTokenFilter.setPasswordParameter("pass");
//        authenticationTokenFilter.afterPropertiesSet();

        return authenticationTokenFilter;
    }

//    @Bean
//    public AdditionalFilter additionalFilterBean() throws Exception {
//        AdditionalFilter authenticationTokenFilter = new AdditionalFilter();
//        authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
//        /****/
//        /****/
////        authenticationTokenFilter.setUsernameParameter("login");
////        authenticationTokenFilter.setPasswordParameter("pass");
////        authenticationTokenFilter.afterPropertiesSet();
//
//        return authenticationTokenFilter;
//    }

//    @Bean
//    public UsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter() throws Exception {
//        UsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
//        customUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
////        customUsernamePasswordAuthenticationFilter
////                .setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login","POST"));
////        customUsernamePasswordAuthenticationFilter.setUsernameParameter("login");
////        customUsernamePasswordAuthenticationFilter.setUsernameParameter("pass");
////        customUsernamePasswordAuthenticationFilter.afterPropertiesSet();
//
//        return customUsernamePasswordAuthenticationFilter;
//    }

  @Bean
  public SecurityService securityService() {
    return this.securityService;
  }


//    public AuthenticationTokenFilter authenticationTokenFilterBean2()
//            throws Exception {
//        AuthenticationTokenFilter customUsernamePasswordAuthenticationFilter = new AuthenticationTokenFilter();
//        customUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
//        //customUsernamePasswordAuthenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(loginUrl, "POST"));
//        customUsernamePasswordAuthenticationFilter.setUsernameParameter("login");
//        customUsernamePasswordAuthenticationFilter.setPasswordParameter("pass");
//        customUsernamePasswordAuthenticationFilter.afterPropertiesSet();
//        return customUsernamePasswordAuthenticationFilter;
//    }


  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
      .csrf()
        .disable()
      .exceptionHandling()
        .authenticationEntryPoint(this.unauthorizedHandler)
        .and()
      .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
      .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .antMatchers("/auth/**").permitAll()
//            .antMatchers("/auz/**").permitAll()
            .anyRequest().authenticated()


    ;


//      httpSecurity.addFilterBefore(customUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//              .formLogin().usernameParameter("login").passwordParameter("pass");


    // Custom JWT based authentication
    httpSecurity
      .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
//            .formLogin()
////            .formLogin()
////            .loginPage("/TestProject/auth/**")
//            .usernameParameter("login")
//            .passwordParameter("pass")

//            .usernameParameter("login")
//            .passwordParameter("pass")

    ;

//      httpSecurity
//              .addFilterBefore(authenticationTokenFilterBean2(), UsernamePasswordAuthenticationFilter.class).formLogin()
////            .formLogin()
////            .loginPage("/TestProject/auth/**")
//              .usernameParameter("login")
//              .passwordParameter("pass");

  }

}
