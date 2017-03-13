package com.company.tehprojectum.dao.repository;

import com.company.tehprojectum.domain.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * A.K.A. UserDAO
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

  public User findByUsername( String username); //@Param("login")

   User getOne(Long sid);//Integer

}
