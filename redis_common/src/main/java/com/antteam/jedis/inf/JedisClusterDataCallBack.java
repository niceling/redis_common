/**   
* @Title: JedisClusterDataCallBack.java 
* @Package com.antteam.jedis.inf 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2015年11月11日 下午4:16:23 
* @version V1.0   
*/
package com.antteam.jedis.inf;

import redis.clients.jedis.JedisCluster;

/**   
* @Package com.antteam.jedis.inf 
* @Description:集群redis使用该接口
* @author niceling
* @date 2015年11月11日 下午4:16:23   
*/

public interface JedisClusterDataCallBack<T> {
	public T command(JedisCluster jedisCluster);
}
