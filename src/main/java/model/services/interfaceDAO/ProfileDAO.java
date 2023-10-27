package model.services.interfaceDAO;

import java.util.List;
import java.sql.SQLException;

import model.entities.Profile;

public interface ProfileDAO {
	public Profile getProfileById(int id) throws SQLException;
	public List<Profile> getAllProfile() throws SQLException;
}
