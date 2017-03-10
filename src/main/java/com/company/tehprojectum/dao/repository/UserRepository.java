package com.company.tehprojectum.dao.repository;

import com.company.tehprojectum.domain.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * AKA UserDAO
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

  public User findByUsername( String username); //@Param("login")

  //public User findById (Long id);
   User getOne(Long sid);//Integer

//  User deleteUser(User user);
//
//  User save(User user);

//  User updateByUpdater(Updater<User> updater);
}
