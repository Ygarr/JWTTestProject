package com.company.tehprojectum.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User extends DomainBase {

  private static final long serialVersionUID = 2353528370345499815L;
  private Long id;
  private String login;
  private String pass;
  private String email;
  private Date lastPasswordReset;
  private String authorities;
  private String firstName;
  private String lastName;

  public User() {
    super();
  }

  public User(String username, String password, String email, Date lastPasswordReset, String authorities, String firstName, String lastName) {
    this.setUsername(username);
    this.setPassword(password);
    this.setEmail(email);
    this.setLastPasswordReset(lastPasswordReset);
    this.setAuthorities(authorities);

    this.setFirstName(firstName);
    this.setLastName(lastName);
  }

  @Id
	@Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
//for h2db:
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
//	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "login")
  public String getUsername() {
    return this.login;
  }

  public void setUsername(String username) {
    this.login = username;
  }

  @Column(name = "pass")
  public String getPassword() {
    return this.pass;
  }

  public void setPassword(String password) {
    this.pass = password;
  }

  @Column(name = "email")
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "last_password_reset")
  public Date getLastPasswordReset() {
    return this.lastPasswordReset;
  }

  public void setLastPasswordReset(Date lastPasswordReset) {
    this.lastPasswordReset = lastPasswordReset;
  }

  @Column(name = "authorities")
  public String getAuthorities() {
    return this.authorities;
  }

  public void setAuthorities(String authorities) {
    this.authorities = authorities;
  }


    @Column(name = "firstname")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastname")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
