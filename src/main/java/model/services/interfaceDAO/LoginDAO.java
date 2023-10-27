package model.services.interfaceDAO;

import java.sql.SQLException;
import java.util.List;

import model.entities.Login;

public interface LoginDAO {
	public Login getLoginById(int id) throws SQLException;
	public List<Login> getAllLogin() throws SQLException;
}
