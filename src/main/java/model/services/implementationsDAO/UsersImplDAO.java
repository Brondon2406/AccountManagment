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

public class UsersImplDAO implements UsersDAO {

	static Connection con = DatabaseConnection.getConnection();
	private String query = "";
	private Users user = new Users();
	private List<Users> listUsers = new ArrayList<>();

	@Override
	public Users getUserById(int id) throws SQLException {
		if (id > 0) {
			try {
				query = "SELECT * FROM USERSMANAGER WHERE id=?;";
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
					user.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					user.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));
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
				query = "SELECT * FROM USERSMANAGER WHERE login=?;";
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
					user.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					user.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));
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
				query = "SELECT * FROM USERSMANAGER WHERE email=?;";
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
					user.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					user.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));
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
			query = "SELECT * FROM USERSMANAGER;";
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
				user.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
				user.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));

				if (UtilsAccount.notEmpty(user)) {
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
				query = "SELECT * FROM USERSMANAGER WHERE profileId=?;";
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
					user.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					user.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));

					if (UtilsAccount.notEmpty(user)) {
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
				query = "SELECT * FROM USERSMANAGER WHERE idStatus=?;";
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
					user.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					user.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));

					if (UtilsAccount.notEmpty(user)) {
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
				query = "SELECT * FROM USERSMANAGER WHERE branchId=?;";
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
					user.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					user.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));

					if (UtilsAccount.notEmpty(user)) {
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
	public Users createUsers(Users user) throws SQLException {
		if(UtilsAccount.notEmpty(user)) {
			try {
				query = "INSERT INTO USERSMANAGER (name"
						+ ",surname"
						+ ",address"
						+ ",email"
						+ ",branchId"
						+ ",identificationId"
						+ ",login"
						+ ",idStatus"
						+ ",profileId"
						+ ",phoneNumber"
						+ ",creationDate"
						+ ",modificationDate)"
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1,user.getName());
				statement.setString(2,user.getSurname());
				statement.setString(3,user.getAddress());
				statement.setString(4,user.getEmail());
				statement.setInt(5,user.getBranchId());
				statement.setString(6,user.getIdentificationId());
				statement.setString(7,user.getLogin());
				statement.setInt(8,user.getStatus());
				statement.setInt(9,user.getProfile());
				statement.setString(10,user.getTelephone());
				statement.setString(11,UtilsAccount.convertDateToString(user.getCreationDate()));
				statement.setString(12,UtilsAccount.convertDateToString(user.getModificationDate()));
				
				int result = statement.executeUpdate();
				if(result > 0) user.setId(result);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return user;
			}
		}
		return user;
	}

	@Override
	public boolean updateUsers(Users user) throws SQLException {
		if(UtilsAccount.notEmpty(user)) {
			try {
				query = "UPDATE USERSMANAGER SET name = ?"
						+ ",surname = ?"
						+ ",address = ?"
						+ ",email = ?"
						+ ",branchId = ?"
						+ ",identificationId = ?"
						+ ",login = ?"
						+ ",idStatus = ?"
						+ ",profileId = ?"
						+ ",phoneNumber = ?"
						+ ",creationDate = ?"
						+ ",modificationDate = ?"
						+ "WHERE id = ?;";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1,user.getName());
				statement.setString(2,user.getSurname());
				statement.setString(3,user.getAddress());
				statement.setString(4,user.getEmail());
				statement.setInt(5,user.getBranchId());
				statement.setString(6,user.getIdentificationId());
				statement.setString(7,user.getLogin());
				statement.setInt(8,user.getStatus());
				statement.setInt(9,user.getProfile());
				statement.setString(10,user.getTelephone());
				statement.setString(11,UtilsAccount.convertDateToString(user.getCreationDate()));
				statement.setString(12,UtilsAccount.convertDateToString(user.getModificationDate()));
				statement.setInt(13,user.getId());
				
				int result = statement.executeUpdate();
				return result > 0 ? true : false;
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		return false;
	}

}
