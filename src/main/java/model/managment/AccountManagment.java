package model.managment;

import model.services.implementationsDAO.AccountImplDAO;
import model.services.implementationsDAO.BranchesImplDAO;
import model.services.implementationsDAO.LoginImplDAO;
import model.services.implementationsDAO.ProfileImplDAO;
import model.services.implementationsDAO.StatusImplMetho;
import model.services.implementationsDAO.UsersImplDAO;
import model.services.interfaceDAO.AccountDAO;
import model.services.interfaceDAO.BranchesDAO;
import model.services.interfaceDAO.LoginDAO;
import model.services.interfaceDAO.ProfileDAO;
import model.services.interfaceDAO.StatusDAO;
import model.services.interfaceDAO.UsersDAO;
import model.utils.UtilsAccount;

import java.sql.SQLException;
import java.util.List;

import model.entities.Account;
import model.entities.Branches;
import model.entities.Users;

public class AccountManagment {
	
	private static AccountManagment SINGLETON = null;
	private static UsersDAO userDAO = new UsersImplDAO();
	private static AccountDAO accountDao = new AccountImplDAO();
	private static BranchesDAO  branchDao = new BranchesImplDAO();
	private static LoginDAO loginDao = new LoginImplDAO();
	private static ProfileDAO profileDao = new ProfileImplDAO();
	private static StatusDAO statusDao = new StatusImplMetho();
	
	
	public static AccountManagment getInstance() {
		if(SINGLETON == null) {
			SINGLETON = new AccountManagment();
		}
		return SINGLETON;
	}
	
	// On this way we will create all method for users class
	
	public List<Users> getAllUsers() throws SQLException{
		List<Users> listUsers = userDAO.getAllUsers();
		if(UtilsAccount.notEmpty(listUsers)) {
			return listUsers;
		}
		return null;
	}
	
	public Users getUserByLogin(String login) throws SQLException{
		if(UtilsAccount.notEmpty(login)) {
			Users user = userDAO.getUserByLogin(login);
			return UtilsAccount.notEmpty(user) ? user: null;
		}
		return null;
	}
	
	public Users getUserByEmail(String email) throws SQLException{
		if(UtilsAccount.notEmpty(email)) {
			Users user = userDAO.getUserByEmail(email);
			return UtilsAccount.notEmpty(user) ? user: null;
		}
		return null;
	}
	
	public Users getUserById(int id) throws SQLException{
		if(id > 0) {
			Users user = userDAO.getUserById(id);
			return UtilsAccount.notEmpty(user) ? user: null;
		}
		return null;
	}
	
	public List<Users> getUserByBranchId(int id) throws SQLException{
		if(id > 0) {
			List<Users> listUsers = userDAO.getUsersByBranchesId(id);
			return UtilsAccount.notEmpty(listUsers) ? listUsers: null;
		}
		return null;
	}
	
	public List<Users> getUsersByProfile(int id) throws SQLException{
		if(id > 0) {
			List<Users> listUsers = userDAO.getUsersByProfile(id);
			return UtilsAccount.notEmpty(listUsers) ? listUsers: null;
		}
		return null;
	}
	
	public List<Users> getUsersByStatus(int id) throws SQLException{
		if(id > 0) {
			List<Users> listUsers = userDAO.getUsersByStatus(id);
			return UtilsAccount.notEmpty(listUsers) ? listUsers: null;
		}
		return null;
	}
	
	// On this way we will create all method for account class
	public Account getAccountById(int id) throws SQLException{
		if(id > 0) {
			Account account = accountDao.getAccountById(id);
			return UtilsAccount.notEmpty(account) ? account : null;
		}
		return null;
	}
	
	public Account getAccountByAccountNumberId(String accountNumber) throws SQLException{
		if(UtilsAccount.notEmpty(accountNumber)) {
			Account account = accountDao.getAccountByAccountId(accountNumber);
			return UtilsAccount.notEmpty(account) ? account : null;
		}
		return null;
	}
	
	public Account getAccountByUserId(int userId) throws SQLException{
		if(userId > 0) {
			Account account = accountDao.getAccountByUserId(userId);
			return UtilsAccount.notEmpty(account) ? account : null;
		}
		return null;
	}
	
	public List<Account> getAllAccount() throws SQLException{
		List<Account> listAllAccount = accountDao.getAllAccount();
		return UtilsAccount.notEmpty(listAllAccount) ? listAllAccount : null;
	}
	
	public List<Account> getListAccountByUserId(int userId) throws SQLException{
		if(userId > 0) {
			List<Account> listAllAccount = accountDao.getListAccountByUserId(userId);
			return UtilsAccount.notEmpty(listAllAccount) ? listAllAccount : null;
		}
		return null;
	}
	
	public List<Account> getListAccountByAccountProfile(int profileId) throws SQLException{
		if(profileId > 0) {
			List<Account> listAllAccount = accountDao.getListAccountByAccountProfile(profileId);
			return UtilsAccount.notEmpty(listAllAccount) ? listAllAccount : null;
		}
		return null;
	}
	
	public Branches getBranchById(int id) throws SQLException {
		if(id > 0) {
			Branches branch = branchDao.getBrancheById(id);
			return UtilsAccount.notEmpty(branch) ? branch : null;
		}
		return null;
	}

}
