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

//    @Value("${tehprojectum.username.header}")
//    private String usernameHeader;
//
//    @Value("${tehprojectum.password.header}")
//    private String passwordHeader;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenUtils tokenUtils;

  @Autowired
  private UserDetailsService userDetailsService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<?> authenticationRequest(
          // HttpServletRequest httpRequest
          @RequestBody AuthenticationRequest authenticationRequest
          , Device device
  ) throws AuthenticationException {

	/* TODO: Move it to Authentication Service */
//		String username_login = httpRequest.getHeader("login");
//		String password = httpRequest.getHeader("pass");
//		Authentication authentication = new UsernamePasswordAuthenticationToken(username_login, password);


      // Perform the authentication
//      authentication = this.authenticationManager.authenticate(authentication);
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
    //  UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    //UserDetails userDetails = this.userDetailsService.loadUserByUsername(username_login);

    String token = this.tokenUtils.generateToken(userDetails, device);
    // Return the token
    return ResponseEntity.ok(new AuthenticationResponse(token));
  }



//  @RequestMapping(value = "${tehprojectum.route.authentication.refresh}", method = RequestMethod.GET)
//  public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
//    String token = request.getHeader(this.tokenHeader);
//    String username = this.tokenUtils.getUsernameFromToken(token);
//    CustomUserDetails user = (CustomUserDetails) this.userDetailsService.loadUserByUsername(username);
//    if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
//      String refreshedToken = this.tokenUtils.refreshToken(token);
//      return ResponseEntity.ok(new AuthenticationResponse(refreshedToken));
//    } else {
//      return ResponseEntity.badRequest().body(null);
//    }
//  }

//      @RequestMapping(value="/auz",method = RequestMethod.POST) //TestProject/auth/auz
//  public ResponseEntity<?> auzRequest(HttpServletRequest request, Device device) {

//          String username = request.getHeader("login");
//          String password = request.getHeader("pass");

//          Enumeration<String> username = request.getHeaderNames();// host user-agent  accept content-type content-length
//          String sEnum = null;
//          final StringBuffer sb = new StringBuffer();
//          while(username.hasMoreElements()) {
//              sEnum = username.nextElement();
//              sb.append(sEnum.toString());
//          }

//     Authentication authentication = new UsernamePasswordAuthenticationToken(username , password);
//          SecurityContextHolder.getContext().setAuthentication(authentication);
//          UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//          String token = this.tokenUtils.generateToken(userDetails, device);
//      return ResponseEntity.ok(new AuthenticationResponse(token));
//          return ResponseEntity.ok(sb.toString()+" !!!!!!!!!!!!!! !!!   " );
//          return null;
//  }

}
