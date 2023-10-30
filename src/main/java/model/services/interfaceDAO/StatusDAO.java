package model.services.interfaceDAO;

import java.util.List;
import java.sql.SQLException;

import model.entities.Status;

public interface StatusDAO {
	public Status getStatusById(int id) throws SQLException;
	public List<Status> getAllStatus() throws SQLException;
	public Status createStatus(Status status) throws SQLException;
	public boolean updateStatus(Status status) throws SQLException;
}
