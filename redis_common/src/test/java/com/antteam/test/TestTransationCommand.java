/**   
* @Title: TestTransationCommand.java 
* @Package redis_common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2015年11月11日 下午5:39:18 
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
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2015年11月11日 下午5:39:18   
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
