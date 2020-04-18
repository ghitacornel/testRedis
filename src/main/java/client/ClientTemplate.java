package client;

import redis.clients.jedis.Jedis;

public abstract class ClientTemplate {

    protected static final String key = "key";
    protected Jedis client;

    public void startClient() {
        client = MyJedisPool.POOL.getResource();
    }

    public void stopClient() {
        client.disconnect();
    }

}
