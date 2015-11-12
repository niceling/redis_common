/**   
* @Title: TestMultiLineCommand.java 
* @Package com.antteam.test 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2015年11月12日 上午11:56:51 
* @version V1.0   
*/
package com.antteam.test;

import org.junit.Test;

import com.antteam.jedis.MultiLineCommand;
import com.antteam.jedis.MultiLineCommand.MultiDataCallBack;

import redis.clients.jedis.Jedis;

/**   
* @Package com.antteam.test 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2015年11月12日 上午11:56:51   
*/

public class TestMultiLineCommand {
	@Test
	public void test01(){
		try {
			MultiLineCommand.excute(new MultiDataCallBack() {
				public void command(Jedis jedis) {
					String foo=jedis.get("foo");
					System.out.println(foo);
					//jedis.expire("foo", 10);
					Long rest=jedis.ttl("foo");
					System.out.println(rest);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
