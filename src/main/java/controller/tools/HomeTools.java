package controller.tools;

import java.sql.SQLException;

import controller.tools.constants.ConstantValues;
import model.entities.Login;
import model.entities.Users;
import model.managment.AccountManagment;
import model.utils.UtilsAccount;

public class HomeTools {
	private static AccountManagment accountManager = new AccountManagment();
	
	public static String getAppTilte() {
		return ConstantValues.APP_TITLE;
	}
	
	public static Users logUser(String login, String pass) throws SQLException{
		if(UtilsAccount.isEmpty(login) && UtilsAccount.isEmpty(pass)) {
			return null;
		}
		
		Users user = new Users();
		Login log = null;
		try {
			log = accountManager.getLoginByUserLogin(login);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(UtilsAccount.notEmpty(log)) {
			if(log.getLogin().equalsIgnoreCase(login) && log.getPassword().equalsIgnoreCase(pass)) {
				user = accountManager.getUserById(log.getIdUser());
			}
		}
		
		return user;
	}
}
