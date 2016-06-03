/**   
* @Title: TestMultiLineCommand.java 
* @Package com.antteam.test 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author niceling
* @date 2015��11��12�� ����11:56:51 
* @version V1.0   
*/
package com.antteam.test;

import org.junit.Test;

import com.antteam.jedis.MultiLineCommand;
import com.antteam.jedis.MultiLineCommand.MultiDataCallBack;

import redis.clients.jedis.Jedis;

/**   
* @Package com.antteam.test 
* @author niceling
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
