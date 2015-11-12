/**   
* @Title: BaseTest.java 
* @Package redis_common 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author niceling
* @date 2015��11��11�� ����3:16:59 
* @version V1.0   
*/
package com.antteam.test;


import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.antteam.jedis.SingleLineCommand;
import com.antteam.jedis.SingleLineCommand.JedisDataCallBack;
import com.antteam.jedis.utils.JSONVO;

import redis.clients.jedis.Jedis;

/**
 * 
* @Package com.antteam.test 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2016年2月29日 下午2:09:48
 */
public class BaseTest {
	
	@Test
	public void TestSingleCommand(){
		try {
			String val=SingleLineCommand.excute(new JedisDataCallBack<String>() {
				public String command(Jedis jedis) {
					/**
					key 
					value 
					nxxx NX|XX, NX -- Only set the key if it does not already exist. XX 
					-- Only set the key if it already exist.
					expx EX|PX, expire time units: EX = seconds; PX = milliseconds
					time expire time in the units of {@param #expx}
					*/
					jedis.setex("foo", 1000, "bar");
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
			Long val=SingleLineCommand.excute(new JedisDataCallBack<Long>() {
				public Long command(Jedis jedis) {
					Long index=jedis.lpush("mylist", "");
					return index;
				}
			});
			System.out.println(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	* @Title: TestSingleCommand3 
	* @auth:niceling
	* @Description:测试列表功能
	* @param 
	* @return void
	* @throws
	 */
	@Test
	public void TestSingleCommand3(){
		try {
			List<String> val=SingleLineCommand.excute(new JedisDataCallBack<List<String>>() {
				public List<String> command(Jedis jedis) {
					List<String> list=jedis.lrange("mylist", 0,-1);
					return list;
				}
			});
			System.out.println(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @Title: TestSingleCommand4 
	* @auth:niceling
	* @Description: 测试新增列表元素
	* @param 
	* @return void
	* @throws
	 */
	@Test
	public void TestSingleCommand4(){
		try {
			Long val=SingleLineCommand.excute(new JedisDataCallBack<Long>() {
				public Long command(Jedis jedis) {
					JSONVO vo=new JSONVO();
					vo.setChannel_id(1);
					vo.setChannel_name("商城");
					vo.setDisplay(1);
					vo.setIndex(1);
					vo.setUrl("http://www.baidu.com");
					String jsonStr=JSONObject.toJSONString(vo);
					Long index=jedis.lpush("mylist", jsonStr);
					return index;
				}
			});
			System.out.println(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	* @Title: TestSingleCommand5 
	* @auth:niceling
	* @Description: 测试获取单条记录
	* @param 
	* @return void
	* @throws
	 */
	@Test
	public void TestSingleCommand5(){
		try {
			String val=SingleLineCommand.excute(new JedisDataCallBack<String>() {
				public String command(Jedis jedis) {
					String jsonStr=jedis.lindex("mylist", 2);
					return jsonStr;
				}
			});
			JSONVO VO=JSONObject.parseObject(val, JSONVO.class);
			System.out.println(val);
			System.out.println(VO.getChannel_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @Title: TestSingleCommand6 
	* @auth:niceling
	* @Description: 测试更新单条记录
	* @param 
	* @return void
	* @throws
	 */
	@Test
	public void TestSingleCommand6(){
		try {
			String val=SingleLineCommand.excute(new JedisDataCallBack<String>() {
				public String command(Jedis jedis) {
					JSONVO vo=new JSONVO();
					vo.setChannel_id(1);
					vo.setChannel_name("商城2");
					vo.setDisplay(1);
					vo.setIndex(1);
					vo.setUrl("http://www.baidu.com");
					String val=jedis.lset("mylist", 3, JSONObject.toJSONString(vo));
					return val;
				}
			});
			System.out.println(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* @Title: TestSingleCommand7 
	* @auth:niceling
	* @Description:  测试删除功能
	* @param 
	* @return void
	* @throws
	 */
	@Test
	public void TestSingleCommand7(){
		try {
			Long val=SingleLineCommand.excute(new JedisDataCallBack<Long>() {
				public Long command(Jedis jedis) {
					JSONVO vo=new JSONVO();
					vo.setChannel_id(1);
					vo.setChannel_name("商城");
					vo.setDisplay(1);
					vo.setIndex(1);
					vo.setUrl("http://www.baidu.com");
					Long count=jedis.lrem("mylist",0, JSONObject.toJSONString(vo));
					return count;
				}
			});
			System.out.println(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
