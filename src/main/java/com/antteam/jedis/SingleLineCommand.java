/**   
* @Title: SetGet.java 
* @Package com.antteam.jedis 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author ������
* @date 2015��11��11�� ����2:55:12 
* @version V1.0   
*/
package com.antteam.jedis;

import com.antteam.jedis.utils.RedisConnection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**   
* @Package com.antteam.jedis 
* @author niceling
* @date 2015��11��11�� ����2:55:12   
*/
public class SingleLineCommand{

	/**
	* @Title: excute 
	* @Description:������������ʹ�øú���
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
