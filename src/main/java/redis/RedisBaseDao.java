package redis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.*;

public class RedisBaseDao {

  public static Jedis conn = null;

  public static Jedis getConnection() {
    conn = new Jedis("localhost");

    System.out.println("Connection to server sucessfully");

    return conn;
  }

}