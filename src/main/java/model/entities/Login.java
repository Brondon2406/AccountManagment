package model.entities;

import java.util.Date;

public class Login {
	private int id;
	private String login;
	private String password;
	private int idUser;
	private String tokenlogin;
	private Date creationDate;
	private Date modificationDateToken;
	
	public Login() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getTokenlogin() {
		return tokenlogin;
	}

	public void setTokenlogin(String tokenlogin) {
		this.tokenlogin = tokenlogin;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDateToken() {
		return modificationDateToken;
	}

	public void setModificationDateToken(Date modificationDateToken) {
		this.modificationDateToken = modificationDateToken;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", login=" + login + ", password=" + password + ", idUser=" + idUser
				+ ", tokenlogin=" + tokenlogin + ", creationDate=" + creationDate + ", modificationDateToken="
				+ modificationDateToken + "]";
	}
}
