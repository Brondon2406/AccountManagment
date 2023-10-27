package model.utils;

import java.util.Collection;
import java.util.List;

public class UtilsAccount {
	
	public static boolean notEmpty(String value) {
		if(value != null) {
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
	
	public static boolean notEmpty(Collection<?> collections) {
		try {
			if(collections.isEmpty()) {
				return false;
			}
			if(collections.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			
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
			
		}
		return 0;
	}
}
