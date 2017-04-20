## wish-cache设计文档

#### 设计初衷
给java开发者一个简易使用redis的缓存工具包
#### 设计描述
JRedis 是一个高性能的 Java 客户端，用来连接到 Redis 分布式哈希键-值数据库。提供同步和异步的连接。wish-cache就是基于JRedis 的一个封装
#### 结构

#### 使用
1. 配置文件config.properties
 redis.url=redis链接信息
      * 思路：把redis连接信息，当成一种URL资源
	 * URL 三种实例:
	 * single/sentinel:[sentinel or redis address and port]?poolName=x&masterNames=x,x&poolSize=x&database=x&password=x&timeout=x
	 *
	 * redis单节点方式#单台(single redis):
     *          single://localhost:6379?poolSize=5
	 *
	 * redis哨兵方式#主从复制(sentinel redis):
     *          sentinel://sentinel-1:26379,sentinel-2:26379?masterNames=default&pollSize=100
	 *
	 * redis集群方式#Master-Slave方式(sharding sentinel):
     *          sentinel://sentinel-1:26379,sentinel-2:26379?masterNames=shard1,shard2&pollSize=100

2. RedisUtils.getTemplate() 获取redis操作模版。
3. 通过JedisTemplate可以对redis进行string set list 等数据操作


 
