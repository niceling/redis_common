/**   
* @Title: TransationCommand.java 
* @Package com.antteam.jedis 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author niceling
* @date 2015��11��11�� ����5:19:15 
* @version V1.0   
*/
package com.antteam.jedis;

import java.util.List;

import com.antteam.jedis.utils.RedisConnection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**   
* @Package com.antteam.jedis 
* @Description: �������
* @author niceling
* @date 2015��11��11�� ����5:19:15   
*/

public class TransationCommand {

	

	/**
	 * 
	* @Title: excuteWithWatch 
	* @Description: �����ɾ�ĵ�����
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
		/**��������*/
		Transaction transaction=jedis.multi();
		try {
			dataCallBack.command(transaction);
			/**�����ύ���ظ������ִ�н��*/
			return transaction.exec();
		}catch(Exception ex){
			/**����Դ����쳣������ع�*/
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
