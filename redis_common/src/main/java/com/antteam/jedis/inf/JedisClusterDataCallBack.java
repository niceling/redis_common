/**   
* @Title: JedisClusterDataCallBack.java 
* @Package com.antteam.jedis.inf 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author niceling
* @date 2015��11��11�� ����4:16:23 
* @version V1.0   
*/
package com.antteam.jedis.inf;

import redis.clients.jedis.JedisCluster;

/**   
* @Package com.antteam.jedis.inf 
* @Description:��Ⱥredisʹ�øýӿ�
* @author niceling
* @date 2015��11��11�� ����4:16:23   
*/

public interface JedisClusterDataCallBack<T> {
	public T command(JedisCluster jedisCluster);
}
