package model.services.interfaceDAO;

import java.sql.SQLException;
import java.util.List;

import model.entities.Branches;

public interface BranchesDAO {
	
	public Branches getBrancheById(int idBranch) throws SQLException;
	public List<Branches> getAllBranches() throws SQLException;
	public Branches createBranch(Branches branch) throws SQLException;
	public boolean updateBranches(Branches branch) throws SQLException;
}
