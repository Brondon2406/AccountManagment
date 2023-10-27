package model.services.interfaceDAO;

import java.util.List;
import java.sql.SQLException;

import model.entities.Status;

public interface StatusDAO {
	public Status getStatusById(int id) throws SQLException;
	public List<Status> getAllStatus() throws SQLException;
}
