/**   
* @Title: DataCallBack.java 
* @Package com.antteam.jedis.inf 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2015年11月11日 下午4:10:40 
* @version V1.0   
*/
package com.antteam.jedis.inf;

import redis.clients.jedis.Jedis;

/**   
* @Package com.antteam.jedis.inf 
* @Description: 命令的回调函数
* @author niceling
* @date 2015年11月11日 下午4:10:40   
*/

public interface JedisDataCallBack<T>{
	
	public T command(Jedis jedis);
	
}
