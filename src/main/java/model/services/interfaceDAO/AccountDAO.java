package model.services.interfaceDAO;

import java.util.List;

import model.entities.Account;

public interface AccountDAO {
	public Account getAccountById(int id);
	public Account getAccountByAccountId(String accountId);
	public Account getAccountByUserId(int userId);
	public List<Account> getListAccountByUserId(int userId);
	public List<Account> getListAccountByAccountProfile(int accountProfile);
	public List<Account> getAllAccount();
}
