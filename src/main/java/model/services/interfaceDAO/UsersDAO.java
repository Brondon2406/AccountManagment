package model.services.interfaceDAO;

import java.util.List;

import model.entities.Users;

public interface UsersDAO {
	
	public Users getUserById(int id);
	public Users getUserByLogin(String login);
	public Users getUserByEmail(String email);
	public List<Users> getAllUsers();
	public List<Users> getUsersByProfile(int idProfile);
	public List<Users> getUsersByStatus(int idStatus);
	public List<Users> getUsersByBranchesId(int idBranch);
}
