package model.utils;

import java.util.Collection;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

import model.entities.Account;
import model.entities.Users;

public class UtilsAccount {
	
	public static boolean notEmpty(String value) {
		if(value != null || value != "") {
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(String value) {
		if(value == null || value == "") {
			return true;
		}
		return false;
	}
	
	public static boolean notEmpty(Object obj) {
		if(obj != null) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(Object obj) {
		if(obj == null) {
			return true;
		}
		return false;
	}
	
	public static boolean notEmpty(Collection<?> collections) {
		try {
			if(collections.isEmpty()) {
				return false;
			}
			if(collections.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public static boolean notEmpty(List<?> collections) {
		try {
			if(collections.isEmpty()) {
				return false;
			}
			if(collections.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public static int getsize(Collection<?> collections) {
		try {
			if(collections.isEmpty()) {
				return 0;
			}
			if(collections.size() > 0) {
				return collections.size();
			}
		} catch (Exception e) {
			return 0;
		}
		return 0;
	}
	
	public static int getsize(List<?> collections) {
		try {
			if(collections.isEmpty()) {
				return 0;
			}
			if(collections.size() > 0) {
				return collections.size();
			}
		} catch (Exception e) {
			return 0;
		}
		return 0;
	}
	
	public static int StringParseInt(String value) {
		try {
			if(notEmpty(value)) {
				int val = Integer.parseInt(value);
				return val;
			}
		} catch (Exception e) {
			return 0;
		}
		return 0;
	}
	
	public static List<Account> listAccountFilterByCriterialStatus(List<Account> listAccount ,int status){
		if(UtilsAccount.notEmpty(listAccount)) {
			List<Account> listResultAccount = new ArrayList<>();
			if(status > 0) {
				for(Account account : listAccount) {
					if(account.getStatus() == status) {
						listResultAccount.add(account);
					}
				}
			}
			return listResultAccount;
		}
		return listAccount;
	}
	
	public static List<Account> listAccountFilterByCriterialProfile(List<Account> listAccount ,int profile){
		if(UtilsAccount.notEmpty(listAccount)) {
			List<Account> listResultAccount = new ArrayList<>();
			if(profile > 0) {
				for(Account account : listAccount) {
					if(account.getAccountProfile() == profile) {
						listResultAccount.add(account);
					}
				}
			}
			return listResultAccount;
		}
		return listAccount;
	}
	
	public static List<Account> listAccountFilterByCriterialBalance(List<Account> listAccount ,float balance){
		if(UtilsAccount.notEmpty(listAccount)) {
			List<Account> listResultAccount = new ArrayList<>();
			if(balance > 0) {
				for(Account account : listAccount) {
					if(account.getBalance() == balance) {
						listResultAccount.add(account);
					}
				}
			}
			return listResultAccount;
		}
		return listAccount;
	}
	
	public static List<Account> listAccountFilterByCriterialModificationdate(List<Account> listAccount ,String dateModif){
		if(UtilsAccount.notEmpty(listAccount)) {
			List<Account> listResultAccount = new ArrayList<>();
			if(notEmpty(dateModif)) {
				Date dt = convertStringToDate(dateModif);
				for(Account account : listAccount) {
					if(account.getModificationDate() == dt) {
						listResultAccount.add(account);
					}
				}
			}
			return listResultAccount;
		}
		return listAccount;
	}
	
	public static List<Users> listUsersFilterByCriterialModificationdate(List<Users> listUsers ,String dateModif){
		if(UtilsAccount.notEmpty(listUsers)) {
			List<Users> listResultUsers = new ArrayList<>();
			if(notEmpty(dateModif)) {
				Date dt = convertStringToDate(dateModif);
				for(Users user : listUsers) {
					if(user.getModificationDate() == dt) {
						listResultUsers.add(user);
					}
				}
			}
			return listResultUsers;
		}
		return listUsers;
	}
	
	public static List<Account> listAccountFilterByCriterialCreationDate(List<Account> listAccount ,String dateCreated){
		if(UtilsAccount.notEmpty(listAccount)) {
			List<Account> listResultAccount = new ArrayList<>();
			if(notEmpty(dateCreated)) {
				Date dt = convertStringToDate(dateCreated);
				for(Account account : listAccount) {
					if(account.getCreationDate() == dt) {
						listResultAccount.add(account);
					}
				}
			}
			return listResultAccount;
		}
		return listAccount;
	}
	
	public static List<Users> listUsersFilterByCriterialCreationDate(List<Users> listUsers ,String dateCreated){
		if(UtilsAccount.notEmpty(listUsers)) {
			List<Users> listResultUsers = new ArrayList<>();
			if(notEmpty(dateCreated)) {
				Date dt = convertStringToDate(dateCreated);
				for(Users user : listUsers) {
					if(user.getCreationDate() == dt) {
						listResultUsers.add(user);
					}
				}
			}
			return listResultUsers;
		}
		return listUsers;
	}
	
	public static Date convertStringToDate (String dateString) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
			Date date = sdf.parse(dateString);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date convertStringToDate2 (String dateString) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
			Date date = sdf.parse(dateString);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String convertDateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
		String strDate = dateFormat.format(date);
		return strDate;
	}
}
