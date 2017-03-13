package com.company.tehprojectum.security.responses;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

  //@Override not for 8 but for 6 level
  public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Failed to log in. Check your password.");//Access Denied
  }

}
