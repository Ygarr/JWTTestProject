package com.company.tehprojectum.security.responses;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Cross-origin resource sharing
@Component
public class CorsFilter implements Filter {

  @Value("${tehprojectum.token.header}")
  private String tokenHeader;//X-TOKEN

//  @Value("${tehprojectum.username.header}")
  @Value("login")
  private String usernameHeader;

//  @Value("${tehprojectum.password.header}")
  @Value("pass")
  private String passwordHeader;

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) res;
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, " + tokenHeader+", "+usernameHeader+", "+passwordHeader);
    response.addHeader("Content-Type", "application/json");
    chain.doFilter(req, res);
  }

  public void init(FilterConfig filterConfig) {}

  public void destroy() {}

}
