package com.company.tehprojectum.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * just for getting spring-userdetails-user by id
 * Created by kdiv on 3/10/17.
 */
public interface SpringUserDetailsServiceExtended {
    UserDetails loadUserById(Long id) throws UsernameNotFoundException;
}
