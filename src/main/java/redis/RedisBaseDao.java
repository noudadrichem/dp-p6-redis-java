package redis;

import redis.clients.jedis.Jedis;

public class RedisBaseDao {

  public static Jedis conn = null;
  public static final String HOST = "localhost";

  public static Jedis getConnection() {
    conn = new Jedis(HOST);
    System.out.println("Connection to server sucessfully");

    return conn;
  }
}