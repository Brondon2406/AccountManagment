package model.entities;

import java.util.List;

public class Branches {
	private int id;
	private String name;
	private String address;
	private int idHeader;
	private int numberAgent;
	private int status;
	private List<Users> listUsers;
	
	public Branches() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIdHeader() {
		return idHeader;
	}

	public void setIdHeader(int idHeader) {
		this.idHeader = idHeader;
	}

	public int getNumberAgent() {
		return numberAgent;
	}

	public void setNumberAgent(int numberAgent) {
		this.numberAgent = numberAgent;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Users> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<Users> listUsers) {
		this.listUsers = listUsers;
	}

	@Override
	public String toString() {
		return "Branches [id=" + id + ", name=" + name + ", address=" + address + ", idHeader=" + idHeader
				+ ", numberAgent=" + numberAgent + ", status=" + status + ", listUsers=" + listUsers + "]";
	}
}
