package model.services.implementationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.databaseConnector.DatabaseConnection;
import model.entities.Login;
import model.services.interfaceDAO.LoginDAO;
import model.utils.UtilsAccount;

public class LoginImplDAO implements LoginDAO {

	static Connection con = DatabaseConnection.getConnection();
	private String query = "";
	private Login login;

	@Override
	public Login getLoginById(int id) throws SQLException {
		if (id > 0) {
			try {
				query = "SELECT * FROM LOGIN WHERE id=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					login.setId(id);
					login.setLogin(result.getString("login"));
					login.setPassword(result.getString("password"));
					login.setIdUser(result.getInt("idUser"));
					login.setTokenlogin(result.getString("tokenLogin"));
					login.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					login.setModificationDateToken(
							UtilsAccount.convertStringToDate(result.getString("modificationDateToken")));
				}

				return UtilsAccount.notEmpty(login) ? login : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Login> getAllLogin() throws SQLException {
		List<Login> listLogin = new ArrayList<>();
		try {
			query = "SELECT * FROM LOGIN";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				login.setId(result.getInt("id"));
				login.setLogin(result.getString("login"));
				login.setPassword(result.getString("password"));
				login.setIdUser(result.getInt("idUser"));
				login.setTokenlogin(result.getString("tokenLogin"));
				login.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
				login.setModificationDateToken(
						UtilsAccount.convertStringToDate(result.getString("modificationDateToken")));
				if (UtilsAccount.notEmpty(login)) {
					listLogin.add(login);
				}
			}
			return UtilsAccount.notEmpty(listLogin) ? listLogin : null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Login createLogin(Login login) throws SQLException {
		try {
			if (UtilsAccount.notEmpty(login)) {
				query = "INSERT INTO LOGIN (login,password,idUser,tokenLogin,creationDate,modificationDateToken) VALUES (?,?,?,?,?,?)";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, login.getLogin());
				statement.setString(2, login.getPassword());
				statement.setInt(3, login.getIdUser());
				statement.setString(4, login.getTokenlogin());
				statement.setString(5, UtilsAccount.convertDateToString(login.getCreationDate()));
				statement.setString(6, UtilsAccount.convertDateToString(login.getModificationDateToken()));

				int result = statement.executeUpdate();
				if (result > 0)
					login.setId(result);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return login;
	}

	@Override
	public boolean updateLogin(Login login) throws SQLException {
		try {
			if (UtilsAccount.notEmpty(login)) {
				query = "UPDATE LOGIN" + "SET login = ?," + "password = ?," + "idUser = ?" + "tokenLogin = ?"
						+ "creationDate = ?" + "modificationDateToken = ?" + "WHERE id = ?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, login.getLogin());
				statement.setString(2, login.getPassword());
				statement.setInt(3, login.getIdUser());
				statement.setString(4, login.getTokenlogin());
				statement.setString(5, UtilsAccount.convertDateToString(login.getCreationDate()));
				statement.setString(6, UtilsAccount.convertDateToString(login.getModificationDateToken()));
				statement.setInt(7, login.getId());

				int result = statement.executeUpdate();
				return result > 0 ? true : false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

}
