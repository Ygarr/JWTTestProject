package com.company.tehprojectum.controller.rest;

import com.company.tehprojectum.model.security.CustomUserDetails;
import com.company.tehprojectum.security.TokenUtils;
import com.company.tehprojectum.service.SpringUserDetailsServiceExtended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET
    )
    @ResponseBody
    @PreAuthorize("@securityService.hasProtectedAccess()") // The same is @PreAuthorize("hasRole('ADMIN')")
    public Object getUser(@PathVariable("id") Long id
            ,HttpServletResponse response
            , HttpServletRequest request
    ) {

         String token = request.getHeader(this.tokenHeader);
        String username = this.tokenUtils.getUsernameFromToken(token);
        CustomUserDetails user = (CustomUserDetails) this.userDetailsService.loadUserByUsername(username);
        CustomUserDetails u = (CustomUserDetails) this.userDetailsServiceExt.loadUserById(id);
        response.setStatus(u == null ? HttpServletResponse.SC_NOT_FOUND : HttpServletResponse.SC_OK);
        //"u" and "user" ARE the same. Difference is in getting way
        return u;
    }
}
