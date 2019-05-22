package redis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.*;

public class RedisDaoImpl extends RedisBaseDao implements ReizigerDao {

   private Gson gson;

   public RedisDaoImpl() {
      super();

      gson = new Gson();
   }

   @Override
   public Reiziger save(Reiziger reiziger) {
      Jedis conn = getConnection();

      String reizigerJsonObj = gson.toJson(reiziger);
      conn.set("reiziger-" + reiziger.getId(), reizigerJsonObj);

      return reiziger;
   }

   @Override
   public List<Reiziger> findAll() {
      Jedis conn = getConnection();
      
      List<Reiziger> tempReizigers = new ArrayList<Reiziger>();
      for(String key : conn.keys("reiziger-*")) {
         Reiziger reizigerFromDb = gson.fromJson(conn.get(key), Reiziger.class);
         tempReizigers.add(reizigerFromDb);
      }
      
      return tempReizigers;
   }

   @Override
   public List<Reiziger> findByGBdatum(String geboortedatum) {
      return null;
   }

   @Override
   public Reiziger update(Reiziger reiziger) {
      save(reiziger);
      return reiziger;
   }

   @Override
   public boolean delete(Reiziger reiziger) {
      Jedis conn = getConnection();
      conn.del("reiziger-" +reiziger.getId());
   }
   
      
   //    String jsonReiziger = jedis.get("reizigers");
   //    System.out.println(jsonReiziger);
   //    Gson gson = new Gson(); // Or use new GsonBuilder().create();
   //    Type listType = new TypeToken<List<String>>() {}.getType();
   //    Reiziger reiziger = gson.fromJson(jsonReiziger, Reiziger.class);
   //    System.out.print(reiziger);
   // } 
} 