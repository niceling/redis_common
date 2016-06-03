/**   
* @Title: SetGet.java 
* @Package com.antteam.jedis 
* @version V1.0   
*/
package com.antteam.jedis;

import com.antteam.jedis.utils.RedisConnection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**   
* @Package com.antteam.jedis 
* @author niceling
*/
public class SingleLineCommand{

	/**
	* @Title: excute 
	* @param @param dataCallBack
	* @param @return
	* @return String
	* @throws
	 */
	public static <T> T excute(JedisDataCallBack<T> dataCallBack)throws Exception{
		RedisConnection.getInstance();
		Jedis jedis=RedisConnection.getJedis();
		try {
			return dataCallBack.command(jedis);
		}finally {
			RedisConnection.closeJedis(jedis);
		}
	}
	
	
	public static <T> T excute(JedisClusterDataCallBack<T> dataCallBack)throws Exception{
		return null;
	}
	
	public interface JedisDataCallBack<T>{
		public T command(Jedis jedis);
		
	}
	
	public interface JedisClusterDataCallBack<T> {
		public T command(JedisCluster jedisCluster);
	}
}
