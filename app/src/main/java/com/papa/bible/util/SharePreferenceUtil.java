package com.papa.bible.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.Set;

/**
 * 
 * @author <a href="http://www.xunhou.me" target="_blank">Kelvin</a>
 *
 */
public class SharePreferenceUtil {

	private static SharedPreferences sp;
	private final static String SHARE_PREFERENCES_NAME = "SP_SETTING";

	/**
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return 是否保存成功
	 */
	public static boolean setValue(Context context, String key, Object value) {
		if (sp == null) {
			sp = context.getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
		}
		Editor edit = sp.edit();
		if (value instanceof String) {
			return edit.putString(key, (String) value).commit();
		} else if (value instanceof Boolean) {
			return edit.putBoolean(key, (Boolean) value).commit();
		} else if (value instanceof Float) {
			return edit.putFloat(key, (Float) value).commit();
		} else if (value instanceof Integer) {
			return edit.putInt(key, (Integer) value).commit();
		} else if (value instanceof Long) {
			return edit.putLong(key, (Long) value).commit();
		} else if (value instanceof Set) {
			new IllegalArgumentException("Value can not be Set object!");
			return false;
		}
		return false;
	}

	public static boolean getBoolean(Context context, String key) {
		if (sp == null) {
			sp = context.getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
		}
		return sp.getBoolean(key, false);
	}
	
	public static String getString(Context context ,String key){
		if (sp == null) {
			sp = context.getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
		}
		return sp.getString(key, "");
	}
	
	public static Float getFloat(Context context,String key){
		if (sp == null) {
			sp = context.getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
		}
		return sp.getFloat(key, 0f);
	}
	
	public static int getInt(Context context,String key){
		if (sp == null) {
			sp = context.getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
		}
		return sp.getInt(key, 0);
	}
	
	public static long getLong(Context context,String key){
		if (sp == null) {
			sp = context.getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
		}
		return sp.getLong(key, 0);
	}

}
