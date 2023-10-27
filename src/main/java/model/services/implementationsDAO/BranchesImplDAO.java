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

public class BranchesImplDAO implements BranchesDAO {
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
	public Branches createBranch(Branches branch) throws SQLException {
		try {
			if (UtilsAccount.notEmpty(branch)) {
				query = "INSERT INTO BRANCHES (name,address,idHeader,numberAgent,idStatus) " + "VALUES (?,?,?,?,?)";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, branch.getName());
				statement.setString(2, branch.getAddress());
				statement.setInt(3, branch.getIdHeader());
				statement.setInt(4, branch.getNumberAgent());
				statement.setInt(5, branch.getStatus());

				int result = statement.executeUpdate();
				if (result > 0)
					branch.setId(result);
				return branch;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return branch;
		}
		return branch;
	}

	@Override
	public boolean updateBranches(Branches branch) throws SQLException {
		try {
			if (UtilsAccount.notEmpty(branch)) {
				query = "UPDATE BRANCHES" + "SET name = ?," + "address = ?," + "idHeader = ?," + "numberAgent = ?,"
						+ "idStatus = ?" + "WHERE id = ?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, branch.getName());
				statement.setString(2, branch.getAddress());
				statement.setInt(3, branch.getIdHeader());
				statement.setInt(4, branch.getNumberAgent());
				statement.setInt(5, branch.getStatus());
				statement.setInt(6, branch.getId());
				
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
