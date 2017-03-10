package com.company.tehprojectum.service.impl;

import com.company.tehprojectum.domain.entity.User;
import com.company.tehprojectum.model.security.factory.CustomUserDetailsFactory;
import com.company.tehprojectum.dao.repository.UserRepository;

import com.company.tehprojectum.service.SpringUserDetailsServiceExtended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringUserDetailsServiceImpl implements UserDetailsService, SpringUserDetailsServiceExtended {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = this.userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
    } else {
      return CustomUserDetailsFactory.create(user);
    }
  }

  @Override
  public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
    User user = this.userRepository.getOne(id);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("No user found with id '%s'.", id));
    } else {
      return CustomUserDetailsFactory.create(user);
    }
  }

}
