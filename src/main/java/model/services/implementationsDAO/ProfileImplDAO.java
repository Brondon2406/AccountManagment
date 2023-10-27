package model.services.implementationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.databaseConnector.DatabaseConnection;
import model.entities.Profile;
import model.services.interfaceDAO.ProfileDAO;
import model.utils.UtilsAccount;

public class ProfileImplDAO implements ProfileDAO{
	
	static Connection con = DatabaseConnection.getConnection();
	private String query = "";
	private Profile profile;

	@Override
	public Profile getProfileById(int id) throws SQLException {
		if (id > 0) {
			try {
				query = "SELECT * FROM PROFILE WHERE id=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					profile.setId(id);
					profile.setName(result.getString("name"));
				}

				return UtilsAccount.notEmpty(profile) ? profile : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Profile> getAllProfile() throws SQLException {
		List<Profile> listProfile = new ArrayList<>();
		try {
			query = "SELECT * FROM PROFILE";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				profile.setId(result.getInt("id"));
				profile.setName(result.getString("name"));
				if (UtilsAccount.notEmpty(profile)) {
					listProfile.add(profile);
				}
			}
			return UtilsAccount.notEmpty(listProfile) ? listProfile : null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}