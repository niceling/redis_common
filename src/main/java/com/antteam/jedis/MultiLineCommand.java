/**   
* @Title: CacheCommand.java 
* @Package com.antteam.jedis 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2015年11月11日 下午5:20:06 
* @version V1.0   
*/
package com.antteam.jedis;

import com.antteam.jedis.utils.RedisConnection;

import redis.clients.jedis.Jedis;

/**   
* @Package com.antteam.jedis 
* @author niceling
* @date 2015年11月11日 下午5:20:06   
*/

public class MultiLineCommand{
	
	/**
	* @Title: excute 
	* @Description:缓存的执行命令
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
