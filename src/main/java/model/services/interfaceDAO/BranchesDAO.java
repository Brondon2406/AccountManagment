package model.services.interfaceDAO;

import java.sql.SQLException;
import java.util.List;

import model.entities.Branches;

public interface BranchesDAO {
	
	public Branches getBrancheById(int idBranch) throws SQLException;
	public List<Branches> getAllBranches() throws SQLException;
	public List<Branches> getBranchesByStatus(int idStatus) throws SQLException;
	public List<Branches> getBranchesByName(String name) throws SQLException;
}
