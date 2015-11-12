package com.antteam.jedis.properties;

import java.io.InputStreamReader;
import java.util.Properties;

public class RedisConfig {
	private static Properties prop = new Properties();

	/**
	 * 读取配置文件
	 */
	static {
		try {
			prop.load(new InputStreamReader(RedisConfig.class.getClassLoader().getResourceAsStream("redis.properties"), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description: 根据key获取值
	 * @param key
	 * @return String
	 * @throws
	 */
	public static String getValue(String key) {
		String res = prop.getProperty(key, "");
		return res;
	}
	
	
	public static Integer getIntValue(String key){
		return Integer.valueOf(getValue(key));
	}
	
	public static Integer getMaxActive(){
		return getIntValue("redisConfig.MaxActive");
	}
	
	public static Integer getMaxidle(){
		return getIntValue("redisConfig.Maxidle");
	}
	
	public static Integer getMaxwait(){
		return getIntValue("redisConfig.Maxwait");
	}
	
	public static Integer getTimeOut(){
		return getIntValue("redisConfig.TimeOut");
	}
	
	public static String getIp(){
		return getValue("redisConfig.ip");
	}
	
	public static Integer getPort(){
		return getIntValue("redisConfig.port");
	}
}
