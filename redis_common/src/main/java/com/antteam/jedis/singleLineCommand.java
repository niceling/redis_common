/**   
* @Title: SetGet.java 
* @Package com.antteam.jedis 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 张美玲
* @date 2015年11月11日 下午2:55:12 
* @version V1.0   
*/
package com.antteam.jedis;

import com.antteam.jedis.utils.RedisConnection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**   
* @Package com.antteam.jedis 
* @author niceling
* @date 2015年11月11日 下午2:55:12   
*/
public class SingleLineCommand{

	/**
	* @Title: excute 
	* @Description:单服务的情况下使用该函数
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
		//TODO 集群的实现代码
		return null;
	}
	
	public interface JedisDataCallBack<T>{
		public T command(Jedis jedis);
		
	}
	
	public interface JedisClusterDataCallBack<T> {
		public T command(JedisCluster jedisCluster);
	}
}
