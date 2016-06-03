/**   
* @Title: TransationCommand.java 
* @Package com.antteam.jedis 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2015年11月11日 下午5:19:15 
* @version V1.0   
*/
package com.antteam.jedis;

import java.util.List;

import com.antteam.jedis.utils.RedisConnection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**   
* @Package com.antteam.jedis 
* @Description: 事务管理
* @author niceling
* @date 2015年11月11日 下午5:19:15   
*/

public class TransationCommand {

	

	/**
	 * 
	* @Title: excuteWithWatch 
	* @Description: 针对增删改的事务
	* @param @param dataCallBack
	* @param @return
	* @param @throws Exception
	* @return List<Object>
	* @throws
	 */
	public static List<Object> excuteWithWatch(String[] watchKeys,TransactionDataCallBack dataCallBack) throws Exception{
		RedisConnection.getInstance();
		Jedis jedis=RedisConnection.getJedis();
		if(watchKeys!=null && watchKeys.length>0){
			jedis.watch(watchKeys);
		}
		/**开启事务*/
		Transaction transaction=jedis.multi();
		try {
			dataCallBack.command(transaction);
			/**事务提交返回各命令的执行结果*/
			return transaction.exec();
		}catch(Exception ex){
			/**有针对代码异常，事务回滚*/
			transaction.discard();
		}
		finally 
		{
			RedisConnection.closeJedis(jedis);
		}
		return null;
	}
	
	
	public interface ClusterTransactionDataCallBack{
		public void command(Transaction transaction);
	}
	
	public interface TransactionDataCallBack{
		public void command(Transaction transaction);
	}
	
}
