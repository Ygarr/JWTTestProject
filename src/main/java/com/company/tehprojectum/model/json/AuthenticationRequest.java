package com.company.tehprojectum.model.json;

//Service?
public class AuthenticationRequest extends ModelBase {

	private static final long serialVersionUID = 6624726180748515507L;
	private String login;
	private String pass;

	public AuthenticationRequest() {
		super();
	}

	public AuthenticationRequest( String login, String pass) {
		this.setUsername(login);
		this.setPassword(pass);
	}

	public String getUsername() {
		return this.login;
	}

	public void setUsername(String username) {
		this.login = username;
	}

	public String getPassword() {
		return this.pass;
	}

	public void setPassword(String password) {
		this.pass = password;
	}

}
