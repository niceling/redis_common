/**   
* @Title: DataCallBack.java 
* @Package com.antteam.jedis.inf 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author niceling
* @date 2015��11��11�� ����4:10:40 
* @version V1.0   
*/
package com.antteam.jedis.inf;

import redis.clients.jedis.Jedis;

/**   
* @Package com.antteam.jedis.inf 
* @Description: ����Ļص�����
* @author niceling
* @date 2015��11��11�� ����4:10:40   
*/

public interface JedisDataCallBack<T>{
	
	public T command(Jedis jedis);
	
}
