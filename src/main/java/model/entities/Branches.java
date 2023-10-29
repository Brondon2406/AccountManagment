package model.entities;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.managment.AccountManagment;
import model.utils.UtilsAccount;

public class Branches {
	private int id;
	private String name;
	private String address;
	private int idHeader;
	private int numberAgent;
	private int status;
	private Date creationDate;
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

	public List<Users> getListUsers() throws SQLException {
		if(id > 0) {
			List<Users> listUsersAcc = AccountManagment.getInstance().getUserByBranchId(id);
			if(UtilsAccount.notEmpty(listUsersAcc)) {
				listUsers = listUsersAcc;
			}
		}
		return listUsers;
	}

	public void setListUsers(List<Users> listUsers) {
		this.listUsers = listUsers;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Branches [id=" + id + ", name=" + name + ", address=" + address + ", idHeader=" + idHeader
				+ ", numberAgent=" + numberAgent + ", status=" + status + ", creationDate=" + creationDate
				+ ", listUsers=" + listUsers + "]";
	}
}
