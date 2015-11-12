/**   
* @Title: CacheCommand.java 
* @Package com.antteam.jedis 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author niceling
* @date 2015��11��11�� ����5:20:06 
* @version V1.0   
*/
package com.antteam.jedis;

import com.antteam.jedis.utils.RedisConnection;

import redis.clients.jedis.Jedis;

/**   
* @Package com.antteam.jedis 
* @author niceling
* @date 2015��11��11�� ����5:20:06   
*/

public class MultiLineCommand{
	
	/**
	* @Title: excute 
	* @Description:�����ִ������
	* @param @param dataCallBack
	* @param @return
	* @return String
	* @throws
	 */
	public static void excute(MultiDataCallBack dataCallBack)throws Exception{
		RedisConnection.getInstance();
		Jedis jedis=RedisConnection.getJedis();
		try {
			dataCallBack.command(jedis);
		}finally {
			RedisConnection.closeJedis(jedis);
		}
	}
	
	public interface  MultiDataCallBack{
		public void command(Jedis jedis);
	}
	
	public interface  ClusterMultiDataCallBack{
		public void command(Jedis jedis);
	}
}
