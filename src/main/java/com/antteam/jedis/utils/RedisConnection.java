package com.antteam.jedis.utils;

import com.antteam.jedis.properties.RedisConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
* @ClassName: RedisConnection 
* @author niceling
* @date 2015-11-11 ����02:34:36 
*
 */
public class RedisConnection {
	private static RedisConnection redisconn=null;
	
	private static JedisPool pool=null;
	
	private RedisConnection(){
		if(pool==null){
			getPool();
		}
	}
	
	public static RedisConnection getInstance(){
		if(redisconn==null){
			redisconn=new RedisConnection();
		}
		return redisconn;
	}
	
    private JedisPool getPool() {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(RedisConfig.getMaxActive());
            config.setMaxIdle(RedisConfig.getMaxidle());
            config.setMaxWaitMillis(RedisConfig.getMaxwait());
            config.setTestOnBorrow(true);
            pool = new JedisPool(config,RedisConfig.getIp(),RedisConfig.getPort(),RedisConfig.getTimeOut(),null);
        }
        return pool;
    }
	
    public static Jedis getJedis(){
    	return pool.getResource();
    }
    
	public static void closeJedis(Jedis jedis){
		if(!pool.isClosed()){
			pool.close();
		}
    }
}
