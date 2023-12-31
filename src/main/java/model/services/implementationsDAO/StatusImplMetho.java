package model.services.implementationsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

import model.databaseConnector.DatabaseConnection;
import model.entities.Status;
import model.services.interfaceDAO.StatusDAO;
import model.utils.UtilsAccount;

public class StatusImplMetho implements StatusDAO {
	static Connection con = DatabaseConnection.getConnection();
	private String query = "";
	private Status status = new Status();

	@Override
	public Status getStatusById(int id) throws SQLException {
		if (id > 0) {
			try {
				query = "SELECT * FROM STATUSMANAGER WHERE id=?;";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					status.setId(id);
					status.setName(result.getString("name"));
					status.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
				}

				return UtilsAccount.notEmpty(status) ? status : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Status> getAllStatus() throws SQLException {
		List<Status> listStatus = new ArrayList<>();
		try {
			query = "SELECT * FROM STATUSMANAGER;";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				status.setId(result.getInt("id"));
				status.setName(result.getString("name"));
				status.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
				if (UtilsAccount.notEmpty(status)) {
					listStatus.add(status);
				}
			}
			return UtilsAccount.notEmpty(listStatus) ? listStatus : null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Status createStatus(Status status) throws SQLException {
		try {
			query = "INSERT INTO STATUSMANAGER (name,creationDate) VALUES (?,?);";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, status.getName());
			statement.setString(2, UtilsAccount.convertDateToString(status.getCreationDate()));

			int result = statement.executeUpdate();
			if (result > 0)
				status.setId(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return status;
		}
		return status;
	}

	@Override
	public boolean updateStatus(Status status) throws SQLException {
		if(UtilsAccount.notEmpty(status)) {
			try {
				query = "UPDATE STATUSMANAGER SET name = ?, creationDate = ? WHERE id = ?;";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, status.getName());
				statement.setString(2, UtilsAccount.convertDateToString(status.getCreationDate()));
				statement.setInt(3, status.getId());

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
