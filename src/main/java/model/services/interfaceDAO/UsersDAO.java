package model.services.interfaceDAO;

import java.sql.SQLException;
import java.util.List;

import model.entities.Users;

public interface UsersDAO {
	
	public Users getUserById(int id) throws SQLException;
	public Users getUserByLogin(String login) throws SQLException;
	public Users getUserByEmail(String email) throws SQLException;
	public List<Users> getAllUsers() throws SQLException;
	public List<Users> getUsersByProfile(int idProfile) throws SQLException;
	public List<Users> getUsersByStatus(int idStatus) throws SQLException;
	public List<Users> getUsersByBranchesId(int idBranch) throws SQLException;
	public Users createUsers(Users use) throws SQLException;
	public boolean updateUsers(Users user) throws SQLException;
}
