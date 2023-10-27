package model.services.implementationsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

import model.databaseConnector.DatabaseConnection;
import model.entities.Status;
import model.services.interfaceDAO.StatusDAO;

public class StatusImplMetho implements StatusDAO{
	static Connection con = DatabaseConnection.getConnection();
	private String query = "";
	private Status status;
	
	@Override
	public Status getStatusById(int id) throws SQLException {
		if(id > 0) {
			try {
				query = "SELECT * FROM STATUS WHERE id=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery(); 
				
				while(result.next()) {
					status.setId(id);
					status.setName(result.getString("name"));
				}
				
				return status;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Status> getAllStatus() throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

}
