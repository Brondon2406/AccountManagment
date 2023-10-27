package model.entities;

public class Login {
	private int id;
	private String login;
	private String password;
	private int idUser;
	
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

	@Override
	public String toString() {
		return "Login [id=" + id + ", login=" + login + ", password=" + password + ", idUser=" + idUser + "]";
	}
}
