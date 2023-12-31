package model.services.implementationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.databaseConnector.DatabaseConnection;
import model.entities.Account;
import model.services.interfaceDAO.AccountDAO;
import model.utils.UtilsAccount;

public class AccountImplDAO implements AccountDAO{
	
	static Connection con = DatabaseConnection.getConnection();
	private String query = "";
	private Account account =new Account();

	@Override
	public Account getAccountById(int id) throws SQLException{
		if (id > 0) {
			try {
				query = "SELECT * FROM ACCOUNTMANAGER WHERE id=?;";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					account.setId(id);
					account.setAccountNumber(result.getString("accountNumber"));
					account.setAccountProfile(result.getInt("accountProfileId"));
					account.setBalance(result.getFloat("balance"));
					account.setUserId(result.getInt("accountUserId"));
					account.setStatus(result.getInt("statusId"));
					account.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					account.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));
				}

				return UtilsAccount.notEmpty(account) ? account : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public Account getAccountByAccountId(String accountNumber) throws SQLException{
		if (UtilsAccount.notEmpty(accountNumber)) {
			try {
				query = "SELECT * FROM ACCOUNTMANAGER WHERE accountNumber=?;";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, accountNumber);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					account.setId(result.getInt("id"));
					account.setAccountNumber(accountNumber);
					account.setAccountProfile(result.getInt("accountProfileId"));
					account.setBalance(result.getFloat("balance"));
					account.setUserId(result.getInt("accountUserId"));
					account.setStatus(result.getInt("statusId"));
					account.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					account.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));
				}

				return UtilsAccount.notEmpty(account) ? account : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public Account getAccountByUserId(int userId) throws SQLException{
		if (userId > 0) {
			try {
				query = "SELECT * FROM ACCOUNTMANAGER WHERE accountUserId=?;";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, userId);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					account.setId(result.getInt("id"));
					account.setAccountNumber(result.getString("accountNumber"));
					account.setAccountProfile(result.getInt("accountProfileId"));
					account.setBalance(result.getFloat("balance"));
					account.setUserId(userId);
					account.setStatus(result.getInt("statusId"));
					account.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					account.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));
				}

				return UtilsAccount.notEmpty(account) ? account : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Account> getListAccountByUserId(int userId) throws SQLException{
		if(userId > 0) {
			List<Account> listAccount = new ArrayList<>();
			try {
				query = "SELECT * FROM ACCOUNTMANAGER WHERE accountUserId=?;";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, userId);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					account.setId(result.getInt("id"));
					account.setAccountNumber(result.getString("accountNumber"));
					account.setAccountProfile(result.getInt("accountProfileId"));
					account.setBalance(result.getFloat("balance"));
					account.setUserId(userId);
					account.setStatus(result.getInt("statusId"));
					account.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					account.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));
					if(UtilsAccount.notEmpty(account)) {
						listAccount.add(account);
					}
				}
				return UtilsAccount.notEmpty(listAccount) ? listAccount : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Account> getListAccountByAccountProfile(int accountProfile) throws SQLException{
		if(accountProfile > 0) {
			List<Account> listAccount = new ArrayList<>();
			try {
				query = "SELECT * FROM ACCOUNTMANAGER WHERE accountProfileId=?;";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setInt(1, accountProfile);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					account.setId(result.getInt("id"));
					account.setAccountNumber(result.getString("accountNumber"));
					account.setAccountProfile(accountProfile);
					account.setBalance(result.getFloat("balance"));
					account.setUserId(result.getInt("accountUserId"));
					account.setStatus(result.getInt("statusId"));
					account.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
					account.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));
					if(UtilsAccount.notEmpty(account)) {
						listAccount.add(account);
					}
				}
				return UtilsAccount.notEmpty(listAccount) ? listAccount : null;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Account> getAllAccount() throws SQLException{
		List<Account> listAccount = new ArrayList<>();
		try {
			query = "SELECT * FROM ACCOUNTMANAGER;";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				account.setId(result.getInt("id"));
				account.setAccountNumber(result.getString("accountNumber"));
				account.setAccountProfile(result.getInt("accountProfileId"));
				account.setBalance(result.getFloat("balance"));
				account.setUserId(result.getInt("accountUserId"));
				account.setStatus(result.getInt("statusId"));
				account.setCreationDate(UtilsAccount.convertStringToDate(result.getString("creationDate")));
				account.setModificationDate(UtilsAccount.convertStringToDate(result.getString("modificationDate")));
				if (UtilsAccount.notEmpty(account)) {
					listAccount.add(account);
				}
			}
			return UtilsAccount.notEmpty(listAccount) ? listAccount : null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Account createAccount(Account account) throws SQLException {
		if(UtilsAccount.notEmpty(account)) {
			try {
				query = "INSERT INTO ACCOUNTMANAGER (accountNumber,accountProfileId,balance,accountUserId,statusId,creationdate,modificationDate) "
						+ "VALUES (?,?,?,?,?,?,?);";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, account.getAccountNumber());
				statement.setInt(2, account.getAccountProfile());
				statement.setFloat(3, account.getBalance());
				statement.setInt(4, account.getUserId());
				statement.setInt(5, account.getStatus());
				statement.setString(6, UtilsAccount.convertDateToString(account.getCreationDate()));
				statement.setString(7, UtilsAccount.convertDateToString(account.getModificationDate()));
				
				int result = statement.executeUpdate();
				if(result > 0) account.setId(result);
				return account;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return account;
			}
		}
		return account;
	}

	@Override
	public boolean updateAccount(Account account) throws SQLException {
		if(UtilsAccount.notEmpty(account)) {
			try {
				query = "UPDATE ACCOUNTMANAGER"
						+ "SET accountNumber = ?,"
						+ "accountProfileId = ?,"
						+ "balance = ?,"
						+ "accountUserId = ?,"
						+ "statusId = ?,"
						+ "creationdate = ?,"
						+ "modificationdate = ?"
						+ "WHERE id = ?;";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, account.getAccountNumber());
				statement.setInt(2, account.getAccountProfile());
				statement.setFloat(3, account.getBalance());
				statement.setInt(4, account.getUserId());
				statement.setInt(5, account.getStatus());
				statement.setString(6, UtilsAccount.convertDateToString(account.getCreationDate()));
				statement.setString(7, UtilsAccount.convertDateToString(account.getModificationDate()));
				statement.setInt(8, account.getId());
				
				int result = statement.executeUpdate();
				return result > 0 ? true: false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		return false;
	}
}
