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
	private Account account;

	@Override
	public Account getAccountById(int id) throws SQLException{
		if (id > 0) {
			try {
				query = "SELECT * FROM ACCOUNT WHERE id=?;";
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
				query = "SELECT * FROM ACCOUNT WHERE accountNumber=?;";
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
				query = "SELECT * FROM ACCOUNT WHERE accountUserId=?;";
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
				query = "SELECT * FROM ACCOUNT WHERE accountUserId=?;";
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
				query = "SELECT * FROM ACCOUNT WHERE accountProfileId=?;";
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
			query = "SELECT * FROM ACCOUNT;";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				account.setId(result.getInt("id"));
				account.setAccountNumber(result.getString("accountNumber"));
				account.setAccountProfile(result.getInt("accountProfileId"));
				account.setBalance(result.getFloat("balance"));
				account.setUserId(result.getInt("accountUserId"));
				account.setStatus(result.getInt("statusId"));
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
	
}
