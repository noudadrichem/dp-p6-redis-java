package redis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import java.util.*;

public class ReizigerRedisDaoImpl extends RedisBaseDao implements ReizigerDao {

   private Gson gson;
   private static final String REIZIGER_CODE = "reiziger-";

   public ReizigerRedisDaoImpl() {
      super();
      gson = new Gson();
   }

   @Override
   public Reiziger save(Reiziger reiziger) {
      Jedis conn = getConnection();

      String reizigerJsonObj = gson.toJson(reiziger);
      conn.set(REIZIGER_CODE + reiziger.getId(), reizigerJsonObj);

      return reiziger;
   }

   @Override
   public List<Reiziger> findAll() {
      Jedis conn = getConnection();
      
      List<Reiziger> tempReizigers = new ArrayList<Reiziger>();
      for(String key : conn.keys(REIZIGER_CODE + "*")) {
         Reiziger reizigerFromDb = gson.fromJson(conn.get(key), Reiziger.class);
         tempReizigers.add(reizigerFromDb);
      }
      
      return tempReizigers;
   }

   @Override
   public List<Reiziger> findByGBdatum(String geboortedatum) {
      Jedis conn = getConnection();
      
      List<Reiziger> tempReizigers = new ArrayList<Reiziger>();
      for(String key : conn.keys(REIZIGER_CODE + "*")) {
         Reiziger reizigerFromDb = gson.fromJson(conn.get(key), Reiziger.class);

         if(reizigerFromDb.getGeboortedatum() != null &&  reizigerFromDb.getGeboortedatum().equals(geboortedatum)) {
            tempReizigers.add(reizigerFromDb);
         }
      }
      
      return tempReizigers;
   }

   @Override
   public Reiziger update(Reiziger reiziger) {
      save(reiziger);
      return reiziger;
   }

   @Override
   public boolean delete(Reiziger reiziger) {
      Jedis conn = getConnection();
      conn.del(REIZIGER_CODE + reiziger.getId());
      return true;
   }
} 