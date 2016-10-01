package com.canon.normal.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleUtil {

	private ResourceBundle resourceBundle;
		
	private static ResourceBundleUtil instance;
	
	private ResourceBundleUtil() {
		resourceBundle = ResourceBundle.getBundle("org.com.normal.resource", Locale.ENGLISH);
	}
	
	public static ResourceBundleUtil getInstance() {
		synchronized (ResourceBundleUtil.class) {
			if(instance == null) {
				instance = new ResourceBundleUtil();
			}
			
			return instance;
		}
	}
	
	public String get(String key) {
		return resourceBundle.getString(key);
	}
	
	
	
}
