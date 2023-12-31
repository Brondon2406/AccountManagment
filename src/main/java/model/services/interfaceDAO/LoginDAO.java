package model.services.interfaceDAO;

import java.sql.SQLException;
import java.util.List;

import model.entities.Login;

public interface LoginDAO {
	public Login getLoginById(int id) throws SQLException;
	public Login getLoginByLogin(String login) throws SQLException;
	public List<Login> getAllLogin() throws SQLException;
	public Login createLogin(Login login) throws SQLException;
	public boolean updateLogin(Login login) throws SQLException;
}
