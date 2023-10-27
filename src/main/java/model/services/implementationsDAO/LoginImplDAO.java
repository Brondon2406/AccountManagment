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

public class LoginImplDAO implements LoginDAO{
	
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
}
