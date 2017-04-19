package com.foundation.cache.redis.pool;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis链接连接池，继承JedisPool
 * Created by fqh on 2015/11/10
 */
public class JedisDirectPool extends JedisPool {

	public JedisDirectPool(HostAndPort address, JedisPoolConfig config) {
		initInternalPool(address, new ConnectionInfo(), config);
	}

	public JedisDirectPool(HostAndPort address, ConnectionInfo connectionInfo, JedisPoolConfig config) {
		initInternalPool(address, connectionInfo, config);
	}
}
