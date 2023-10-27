package model.services.implementationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.databaseConnector.DatabaseConnection;
import model.entities.Branches;
import model.services.interfaceDAO.BranchesDAO;
import model.utils.UtilsAccount;

public class BranchesImplDAO implements BranchesDAO{
	static Connection con = DatabaseConnection.getConnection();
	private String query = "";
	private Branches branch;

	@Override
	public Branches getBrancheById(int idBranch) throws SQLException {
		if (idBranch > 0) {
			try {
				query = "SELECT * FROM BRANCHES WHERE id=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, idBranch);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					branch.setId(idBranch);
					branch.setName(result.getString("name"));
					branch.setAddress(result.getString("address"));
					branch.setIdHeader(result.getInt("idHeader"));
					branch.setNumberAgent(result.getInt("numberAgent"));
					branch.setStatus(result.getInt("idStatus"));
				}

				return UtilsAccount.notEmpty(branch) ? branch : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Branches> getAllBranches() throws SQLException {
		List<Branches> branches = new ArrayList<>();
		try {
			query = "SELECT * FROM BRANCHES WHERE id=?";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				branch.setId(result.getInt("id"));
				branch.setName(result.getString("name"));
				branch.setAddress(result.getString("address"));
				branch.setIdHeader(result.getInt("idHeader"));
				branch.setNumberAgent(result.getInt("numberAgent"));
				branch.setStatus(result.getInt("idStatus"));
				
				branches.add(branch);
			}

			return UtilsAccount.notEmpty(branches) ? branches : null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Branches> getBranchesByStatus(int idStatus) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Branches> getBranchesByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
