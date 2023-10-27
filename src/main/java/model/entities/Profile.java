package model.entities;

public class Profile {
	private int id;
	private String name;
	
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

	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + "]";
	}
}
