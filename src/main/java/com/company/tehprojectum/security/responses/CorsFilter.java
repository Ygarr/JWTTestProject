package com.company.tehprojectum.security.responses;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Cross-origin resource sharing

@Component
public class CorsFilter implements Filter {

  @Value("${tehprojectum.token.header}")
  private String tokenHeader;//X-TOKEN

  @Value("${tehprojectum.username.header}")
  private String usernameHeader;

  @Value("${tehprojectum.password.header}")
  private String passwordHeader;

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) res;
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, " + tokenHeader+", "+usernameHeader+","+passwordHeader);
    response.addHeader("Content-Type", "application/json");
    chain.doFilter(req, res);
  }

  public void init(FilterConfig filterConfig) {}

  public void destroy() {}

}
