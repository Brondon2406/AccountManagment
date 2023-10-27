package model.services.interfaceDAO;

import java.util.List;

import model.entities.Profile;

public interface ProfileDAO {
	public Profile getProfileById();
	public List<Profile> getAllProfile();
}
