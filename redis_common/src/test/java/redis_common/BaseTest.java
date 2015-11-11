/**   
* @Title: BaseTest.java 
* @Package redis_common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2015年11月11日 下午3:16:59 
* @version V1.0   
*/
package redis_common;

import java.util.Set;

import org.junit.Test;

import com.antteam.jedis.singleLineCommand;
import com.antteam.jedis.inf.JedisDataCallBack;

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
			Long val=singleLineCommand.excute(new JedisDataCallBack<Long>() {
				public Long command(Jedis jedis) {
					return jedis.sadd("mylist", "c");
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
			
			Set<String> val=singleLineCommand.excute(new JedisDataCallBack<Set<String>>() {
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
