package com.company.tehprojectum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    @Value("${tehprojectum.token.header}")
    private String tokenHeader;

//    @Value("${tehprojectum.username.header}")
//    private String usernameHeader;
//
//    @Value("${tehprojectum.password.header}")
//    private String passwordHeader;

  @Autowired
  private TokenUtils tokenUtils;

  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String authToken = httpRequest.getHeader(this.tokenHeader);
    String username = this.tokenUtils.getUsernameFromToken(authToken);

    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

        if (this.tokenUtils.validateToken(authToken, userDetails)) {


            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));



            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    chain.doFilter(request, response);
  }


//    private void checkLogin(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
//        String authorization = httpRequest.getHeader("Authorization");
//        String username = httpRequest.getHeader(usernameHeader);
//        String password = httpRequest.getHeader(passwordHeader);
//
//        if (authorization != null) {
//            checkBasicAuthorization(authorization, httpResponse);
//            doNotContinueWithRequestProcessing(httpRequest);
//        } else if (username != null && password != null) {
//            checkUsernameAndPassword(username, password, httpResponse);
//            doNotContinueWithRequestProcessing(httpRequest);
//        }
//    }


}
