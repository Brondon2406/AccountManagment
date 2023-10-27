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

import java.util.ArrayList;

import model.entities.Account;
import model.entities.Branches;
import model.entities.Login;
import model.entities.Profile;
import model.entities.Status;
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
	
	public Users createUsers(Users user) throws SQLException{
		if(UtilsAccount.notEmpty(user)) {
			user = userDAO.createUsers(user);
		}
		return user;
	}
	
	public boolean updateUsers (Users user) throws SQLException{
		if(UtilsAccount.notEmpty(user)) {
			return userDAO.updateUsers(user);
		}
		return false;
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
	
	public Account createAccount(Account account) throws SQLException {
		if(UtilsAccount.notEmpty(account)) {
			account = accountDao.createAccount(account);
		}
		return account;
	}
	
	public boolean UpdateAccount(Account account) throws SQLException{
		if(UtilsAccount.notEmpty(account)) {
			return accountDao.updateAccount(account);
		}
		return false;
	}
	
	public Branches getBranchById(int id) throws SQLException {
		if(id > 0) {
			Branches branch = branchDao.getBrancheById(id);
			return UtilsAccount.notEmpty(branch) ? branch : null;
		}
		return null;
	}
	
	public List<Branches> getAllBranches() throws SQLException{
		List<Branches> branches = branchDao.getAllBranches();
		return UtilsAccount.notEmpty(branches) ? branches : null;
	}
	
	public List<Branches> getBranchesByStatus(int idStatus) throws SQLException{
		List<Branches> branches = new ArrayList<>();
		if(idStatus > 0) {
			List<Branches> listAllBranches = getAllBranches();
			if(UtilsAccount.notEmpty(listAllBranches)) {
				for(Branches branch  : listAllBranches) {
					if(branch.getStatus() == idStatus) {
						branches.add(branch);
					}
				}
			}
		}
		return branches;
	}
	
	public Branches createBranches(Branches branch) throws SQLException{
		if(UtilsAccount.notEmpty(branch)) {
			branch = branchDao.createBranch(branch);
		}
		return branch;
	}
	
	public boolean updateBranches(Branches branch) throws SQLException {
		if(UtilsAccount.notEmpty(branch)) {
			return branchDao.updateBranches(branch);
		}
		return false;
	}
	
	public Login getLoginById(int idLogin) throws SQLException{
		if(idLogin > 0) {
			Login login = loginDao.getLoginById(idLogin);
			return UtilsAccount.notEmpty(login) ? login : null;
		}
		return null;
	}
	
	public List<Login> getAllLogin() throws SQLException{
		List<Login> allLogins = loginDao.getAllLogin();
		return UtilsAccount.notEmpty(allLogins) ? allLogins : null;
	}
	
	public Login getLoginByUserLogin(String userLogin) throws SQLException{
		if(UtilsAccount.notEmpty(userLogin)) {
			Login login = new Login();
			List<Login> allLogins = loginDao.getAllLogin();
			for(Login log : allLogins) {
				if(log.getLogin().equalsIgnoreCase(userLogin)) {
					login = log;
					break;
				}
			}
			return UtilsAccount.notEmpty(login) ? login : null;
		}
		return null;
	}
	
	public Login createLogin(Login login) throws SQLException{
		if(UtilsAccount.notEmpty(login)) {
			login = loginDao.createLogin(login);
		}
		return login;
	}
	
	public boolean updateLogin(Login login) throws SQLException{
		if(UtilsAccount.notEmpty(login)) {
			return loginDao.updateLogin(login);
		}
		return false;
	}
	
	public Profile getProfileById(int idProfile) throws SQLException{
		if(idProfile > 0) {
			Profile profile = profileDao.getProfileById(idProfile);
			return UtilsAccount.notEmpty(profile) ? profile : null;
		}
		return null;
	}
	
	public List<Profile> getAllProfile() throws SQLException{
		List<Profile> allProfile = profileDao.getAllProfile();
		return UtilsAccount.notEmpty(allProfile) ? allProfile : null;
	}
	
	public Profile createProfile(Profile profile) throws SQLException{
		if(UtilsAccount.notEmpty(profile)) {
			profile = profileDao.createProfile(profile);
		}
		return profile;
	}
	
	public boolean updateProfile(Profile profile) throws SQLException{
		if(UtilsAccount.notEmpty(profile)) {
			return profileDao.updateProfile(profile);
		}
		return false;
	}
	
	public Status getStatusByid(int idStatus) throws SQLException{
		if(idStatus > 0) {
			Status status = statusDao.getStatusById(idStatus);
			return UtilsAccount.notEmpty(status) ? status : null;
		}
		return null;
	}
	
	public List<Status> listAllStatus() throws SQLException{
		List<Status> listAllStatus = statusDao.getAllStatus();
		return UtilsAccount.notEmpty(listAllStatus) ? listAllStatus : null;
	}
	
	public Status createStatus(Status status) throws SQLException{
		if(UtilsAccount.notEmpty(status)) {
			status = statusDao.createStatus(status);
		}
		return status;
	}
	
	public boolean updateStatus(Status status) throws SQLException {
		if(UtilsAccount.notEmpty(status)) {
			return statusDao.updateStatus(status);
		}
		return false;
	}

}
