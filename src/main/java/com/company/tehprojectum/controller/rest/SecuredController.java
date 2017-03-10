package com.company.tehprojectum.controller.rest;

import com.company.tehprojectum.model.security.CustomUserDetails;
import com.company.tehprojectum.security.TokenUtils;
import com.company.tehprojectum.service.SpringUserDetailsServiceExtended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

//https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/

@RestController
@RequestMapping("/user")
public class SecuredController {

    @Value("${tehprojectum.token.header}")
    private String tokenHeader;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private SpringUserDetailsServiceExtended userDetailsServiceExt;


    /**
  This is an example of some different kinds of granular restriction for endpoints. You can use the built-in SPEL expressions
  in @PreAuthorize such as 'hasRole()' to determine if a user has access. However, if you require logic beyond the methods
  Spring provides then you can encapsulate it in a service and register it as a bean to use it within the annotation as
  demonstrated below with 'securityService'.
  **/
  @RequestMapping(method = RequestMethod.GET)
  @PreAuthorize("@securityService.hasProtectedAccess()") //@PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> getDaHoney() {
    return ResponseEntity.ok(":O");
  }

 /**http://www.baeldung.com/get-user-in-spring-security **/
    @RequestMapping(value = "/uzer/1", method = RequestMethod.GET)
    @PreAuthorize("@securityService.hasProtectedAccess()")
    @ResponseBody
    public String currentUserName(Principal principal) {
        /**

          Authentication auth = httpServletRequest.getUserPrincipal();

         // assume integrated custom UserDetails called MyCustomUserDetails
         // by default, typically instance of UserDetails

         MyCustomUserDetails userDetails = (MyCustomUserDetails) auth.getPrincipal();
         String firstName = userDetails.getFirstName();
         String lastName = userDetails.getLastName();

         **/



        return principal.getName();
    }

    @RequestMapping(value = "/user/11", method = RequestMethod.GET)
    @PreAuthorize("@securityService.hasProtectedAccess()")
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    @RequestMapping(value = "/sub/1", method = RequestMethod.GET)
    @PreAuthorize("@securityService.hasProtectedAccess()")
    @ResponseBody
    public ResponseEntity<?> getAccess() {
        return ResponseEntity.ok("PWNED!!");
    }

//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE })
//    @ResponseBody
//    public CustomerDetails findById(@PathVariable("id") final Long id,final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
//        return new CustomerDetails(randomAlphabetic(6));
//    }
//
//    http://www.baeldung.com/spring-requestmapping
// http://howtodoinjava.com/spring/spring-restful/spring-restful-client-resttemplate-example/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET
    //        , consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    @ResponseBody
    @PreAuthorize("@securityService.hasProtectedAccess()") // the same is @PreAuthorize("hasRole('ADMIN')")
    //public ResponseEntity<?> getUser( Long id
    public Object getUser(@PathVariable("id") Long id
                           //final Long id
                                      // , final UriComponentsBuilder uriBuilder
            //, final HttpServletResponse response
            ,HttpServletResponse response
            , HttpServletRequest request
    ) {

         String token = request.getHeader(this.tokenHeader);
        String username = this.tokenUtils.getUsernameFromToken(token);
        CustomUserDetails user = (CustomUserDetails) this.userDetailsService.loadUserByUsername(username);
//        if (id.equals(user.getId())) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.badRequest().body("NOLE");
//        }
//    }
        //return ResponseEntity.ok(user+"well");
        CustomUserDetails u = (CustomUserDetails) this.userDetailsServiceExt.loadUserById(id);//not just User entity
        response.setStatus(u == null ? HttpServletResponse.SC_NOT_FOUND : HttpServletResponse.SC_OK);
        //"u" and "user" ARE the same! Difference is in getting way
        return u;
    }
}
