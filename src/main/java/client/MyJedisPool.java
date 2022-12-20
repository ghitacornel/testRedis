package client;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class MyJedisPool {

    final public static JedisPool POOL = new JedisPool(buildPoolConfiguration(), "localhost", 6379);

    private static JedisPoolConfig buildPoolConfiguration() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(128);
        config.setMaxIdle(128);
        config.setMinIdle(16);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        config.setTestWhileIdle(true);
        config.setMinEvictableIdleTime(Duration.ofSeconds(60));
        config.setTimeBetweenEvictionRuns(Duration.ofSeconds(30));
        config.setNumTestsPerEvictionRun(3);
        config.setBlockWhenExhausted(true);
        return config;
    }
}
