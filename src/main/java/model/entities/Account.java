package model.entities;

import java.util.Date;

public class Account {
	private int id;
	private String accountNumber;
	private float balance;
	private int accountProfile;
	private int status;
	private int userId;
	private Date creationDate;
	private Date modificationDate;
	
	public Account() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getAccountProfile() {
		return accountProfile;
	}

	public void setAccountProfile(int accountProfile) {
		this.accountProfile = accountProfile;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + ", accountProfile="
				+ accountProfile + ", status=" + status + ", userId=" + userId + ", creationDate=" + creationDate
				+ ", modificationDate=" + modificationDate + "]";
	}
}
