package model.services.interfaceDAO;

import java.sql.SQLException;
import java.util.List;

import model.entities.Account;

public interface AccountDAO {
	public Account getAccountById(int id) throws SQLException;
	public Account getAccountByAccountId(String accountNumber) throws SQLException;
	public Account getAccountByUserId(int userId) throws SQLException;
	public List<Account> getListAccountByUserId(int userId) throws SQLException;
	public List<Account> getListAccountByAccountProfile(int accountProfile) throws SQLException;
	public List<Account> getAllAccount() throws SQLException;
	
	public Account createAccount(Account account) throws SQLException;
	public boolean updateAccount(Account account) throws SQLException;
}
