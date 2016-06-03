/**   
* @Title: TestTransationCommand.java 
* @Package redis_common 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author niceling
* @date 2015��11��11�� ����5:39:18 
* @version V1.0   
*/
package com.antteam.test;

import java.util.List;

import org.junit.Test;

import com.antteam.jedis.TransationCommand;
import com.antteam.jedis.TransationCommand.TransactionDataCallBack;

import redis.clients.jedis.Transaction;

/**   
* @Package redis_common 
* @author niceling
*/

public class TestTransationCommand {
	
	@Test
	public void Test03(){
		try {
			List<Object> list=TransationCommand.excuteWithWatch(new String[]{"foo"},new TransactionDataCallBack() {
				
				public void command(Transaction transaction) {
					transaction.set("foo", "bb");
					transaction.set("bar","111");
				}
			});
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
