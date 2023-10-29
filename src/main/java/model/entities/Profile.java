package model.entities;

import java.util.Date;

public class Profile {
	private int id;
	private String name;
	private Date creationDate;
	
	public Profile() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", creationDate=" + creationDate + "]";
	}
}
