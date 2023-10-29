package model.entities;

import java.util.Date;
import java.util.List;

public class Users {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String login;
	private String identificationId;
	private int profile;
	private int status;
	private int branchId;
	private String address;
	private String telephone;
	private Date creationDate;
	private Date modificationDate;
	private List<Account> listAccount;
	
	public Users() {
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getIdentificationId() {
		return identificationId;
	}

	public void setIdentificationId(String identificationId) {
		this.identificationId = identificationId;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", login=" + login
				+ ", identificationId=" + identificationId + ", profile=" + profile + ", status=" + status
				+ ", branchId=" + branchId + ", address=" + address + ", telephone=" + telephone + ", creationDate="
				+ creationDate + ", modificationDate=" + modificationDate + ", listAccount=" + listAccount + "]";
	}
	
}
