package model.services.interfaceDAO;

import java.util.List;

import model.entities.Branches;

public interface BranchesDAO {
	
	public Branches getBrancheById(int idBranch);
	public List<Branches> getAllBranches();
	public List<Branches> getBranchesByStatus(int idStatus);
	public List<Branches> getBranchesByName(String name);
}
