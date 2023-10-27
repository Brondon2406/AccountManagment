package model.services.implementationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.databaseConnector.DatabaseConnection;
import model.entities.Users;
import model.services.interfaceDAO.UsersDAO;
import model.utils.UtilsAccount;

public class UsersImplDAO implements UsersDAO{
	
	static Connection con = DatabaseConnection.getConnection();
	private String query = "";
	private Users user;
	private List<Users> listUsers = new ArrayList<>();

	@Override
	public Users getUserById(int id) throws SQLException {
		if (id > 0) {
			try {
				query = "SELECT * FROM USERS WHERE id=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					user.setId(id);
					user.setName(result.getString("name"));
					user.setSurname(result.getString("surname"));
					user.setAddress(result.getString("address"));
					user.setEmail(result.getString("email"));
					user.setBranchId(result.getInt("branchId"));
					user.setIdentificationId(result.getString("identificationId"));
					user.setLogin(result.getString("login"));
					user.setStatus(result.getInt("idStatus"));
					user.setProfile(result.getInt("profileId"));
					user.setTelephone(result.getString("phoneNumber"));
				}

				return UtilsAccount.notEmpty(user) ? user : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public Users getUserByLogin(String login) throws SQLException {
		if (UtilsAccount.notEmpty(login)) {
			try {
				query = "SELECT * FROM USERS WHERE login=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, login);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					user.setId(result.getInt("id"));
					user.setName(result.getString("name"));
					user.setSurname(result.getString("surname"));
					user.setAddress(result.getString("address"));
					user.setEmail(result.getString("email"));
					user.setBranchId(result.getInt("branchId"));
					user.setIdentificationId(result.getString("identificationId"));
					user.setLogin(login);
					user.setStatus(result.getInt("idStatus"));
					user.setProfile(result.getInt("profileId"));
					user.setTelephone(result.getString("phoneNumber"));
				}

				return UtilsAccount.notEmpty(user) ? user : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public Users getUserByEmail(String email) throws SQLException {
		if (UtilsAccount.notEmpty(email)) {
			try {
				query = "SELECT * FROM USERS WHERE email=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, email);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					user.setId(result.getInt("id"));
					user.setName(result.getString("name"));
					user.setSurname(result.getString("surname"));
					user.setAddress(result.getString("address"));
					user.setEmail(email);
					user.setBranchId(result.getInt("branchId"));
					user.setIdentificationId(result.getString("identificationId"));
					user.setLogin(result.getString("login"));
					user.setStatus(result.getInt("idStatus"));
					user.setProfile(result.getInt("profileId"));
					user.setTelephone(result.getString("phoneNumber"));
				}

				return UtilsAccount.notEmpty(user) ? user : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Users> getAllUsers() throws SQLException {
		try {
			query = "SELECT * FROM USERS";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				user.setId(result.getInt("id"));
				user.setName(result.getString("name"));
				user.setSurname(result.getString("surname"));
				user.setAddress(result.getString("address"));
				user.setEmail(result.getString("email"));
				user.setBranchId(result.getInt("branchId"));
				user.setIdentificationId(result.getString("identificationId"));
				user.setLogin(result.getString("login"));
				user.setStatus(result.getInt("idStatus"));
				user.setProfile(result.getInt("profileId"));
				user.setTelephone(result.getString("phoneNumber"));
				
				if(UtilsAccount.notEmpty(user)) {
					listUsers.add(user);
				}
			}

			return UtilsAccount.notEmpty(listUsers) ? listUsers : null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Users> getUsersByProfile(int idProfile) throws SQLException {
		if (idProfile > 0) {
			try {
				query = "SELECT * FROM USERS WHERE profileId=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, idProfile);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					user.setId(result.getInt("id"));
					user.setName(result.getString("name"));
					user.setSurname(result.getString("surname"));
					user.setAddress(result.getString("address"));
					user.setEmail(result.getString("email"));
					user.setBranchId(result.getInt("branchId"));
					user.setIdentificationId(result.getString("identificationId"));
					user.setLogin(result.getString("login"));
					user.setStatus(result.getInt("idStatus"));
					user.setProfile(idProfile);
					user.setTelephone(result.getString("phoneNumber"));
					
					if(UtilsAccount.notEmpty(user)) {
						listUsers.add(user);
					}
				}

				return UtilsAccount.notEmpty(listUsers) ? listUsers : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Users> getUsersByStatus(int idStatus) throws SQLException {
		if (idStatus > 0) {
			try {
				query = "SELECT * FROM USERS WHERE idStatus=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, idStatus);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					user.setId(result.getInt("id"));
					user.setName(result.getString("name"));
					user.setSurname(result.getString("surname"));
					user.setAddress(result.getString("address"));
					user.setEmail(result.getString("email"));
					user.setBranchId(result.getInt("branchId"));
					user.setIdentificationId(result.getString("identificationId"));
					user.setLogin(result.getString("login"));
					user.setStatus(idStatus);
					user.setProfile(result.getInt("profileId"));
					user.setTelephone(result.getString("phoneNumber"));
					
					if(UtilsAccount.notEmpty(user)) {
						listUsers.add(user);
					}
				}

				return UtilsAccount.notEmpty(listUsers) ? listUsers : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Users> getUsersByBranchesId(int idBranch) throws SQLException {
		if (idBranch > 0) {
			try {
				query = "SELECT * FROM USERS WHERE branchId=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, idBranch);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					user.setId(result.getInt("id"));
					user.setName(result.getString("name"));
					user.setSurname(result.getString("surname"));
					user.setAddress(result.getString("address"));
					user.setEmail(result.getString("email"));
					user.setBranchId(idBranch);
					user.setIdentificationId(result.getString("identificationId"));
					user.setLogin(result.getString("login"));
					user.setStatus(result.getInt("idStatus"));
					user.setProfile(result.getInt("profileId"));
					user.setTelephone(result.getString("phoneNumber"));
					
					if(UtilsAccount.notEmpty(user)) {
						listUsers.add(user);
					}
				}

				return UtilsAccount.notEmpty(listUsers) ? listUsers : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}
	
}
