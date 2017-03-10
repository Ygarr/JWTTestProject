package com.company.tehprojectum.model.security.factory;

import com.company.tehprojectum.domain.entity.User;
import com.company.tehprojectum.model.security.CustomUserDetails;

import org.springframework.security.core.authority.AuthorityUtils;

public class CustomUserDetailsFactory {

  public static CustomUserDetails create(User user) {
    return new CustomUserDetails(
      user.getId(),
      user.getUsername(),
      user.getPassword(),
      user.getEmail(),
      user.getLastPasswordReset(),
            user.getFirstName(),
            user.getLastName(),
      AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities())
    );
  }

}
