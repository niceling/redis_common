/**   
* @Title: BaseTest.java 
* @Package redis_common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2015年11月11日 下午3:16:59 
* @version V1.0   
*/
package com.antteam.test;

import java.util.Set;

import org.junit.Test;

import com.antteam.jedis.SingleLineCommand;
import com.antteam.jedis.SingleLineCommand.JedisDataCallBack;

import redis.clients.jedis.Jedis;

/**   
* @Package redis_common 
* @author niceling
* @date 2015年11月11日 下午3:16:59   
*/
public class BaseTest {
	
	@Test
	public void TestSingleCommand(){
		try {
			String val=SingleLineCommand.excute(new JedisDataCallBack<String>() {
				public String command(Jedis jedis) {
					return jedis.get("bar");
				}
			});
			System.out.println(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestSingleCommand2(){
		try {
			Set<String> val=SingleLineCommand.excute(new JedisDataCallBack<Set<String>>() {
				public Set<String> command(Jedis jedis) {
					return jedis.smembers("mylist");
				}
			});
			System.out.println(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
