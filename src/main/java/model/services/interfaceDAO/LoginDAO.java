package model.services.interfaceDAO;

import java.util.List;

import model.entities.Login;

public interface LoginDAO {
	public Login getLoginById();
	public List<Login> getAllLogin();
}
