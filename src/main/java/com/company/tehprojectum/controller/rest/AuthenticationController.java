package com.company.tehprojectum.controller.rest;

import com.company.tehprojectum.model.json.AuthenticationRequest;
import com.company.tehprojectum.model.json.AuthenticationResponse;
import com.company.tehprojectum.security.TokenUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${tehprojectum.route.authentication}")
public class AuthenticationController {

  private final Logger logger = Logger.getLogger(this.getClass());

  @Value("${tehprojectum.token.header}")
  private String tokenHeader;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenUtils tokenUtils;

  @Autowired
  private UserDetailsService userDetailsService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<?> authenticationRequest(
          @RequestBody AuthenticationRequest authenticationRequest
          , Device device
  ) throws AuthenticationException {

	/* TODO: Move it to Authentication Service */
      // Perform the authentication
    Authentication authentication = this.authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        authenticationRequest.getUsername(),
        authenticationRequest.getPassword()
      )
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // Reload password post-authentication so we can generate token
    UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

    String token = this.tokenUtils.generateToken(userDetails, device);
    // Return the token
    return ResponseEntity.ok(new AuthenticationResponse(token));
  }

}
