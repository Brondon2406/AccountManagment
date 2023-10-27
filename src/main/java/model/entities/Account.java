package model.entities;

public class Account {
	private int id;
	private String accountNumber;
	private float balance;
	private int accountProfile;
	private int status;
	private int userId;
	
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
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + ", typeAccount="
				+ accountProfile + ", status=" + status + ", userId=" + userId + "]";
	}
}
