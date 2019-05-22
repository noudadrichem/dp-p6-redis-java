package redis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.*;

public class OVKaartRedisDaoImpl extends RedisBaseDao implements OVKaartDao {

   private Gson gson;

   public OVKaartRedisDaoImpl() {
      super();

      gson = new Gson();
   }

   @Override
   public OVKaart save(OVKaart OVkaart) {
      Jedis conn = getConnection();

      String reizigerJsonObj = gson.toJson(OVkaart);
      conn.set("reiziger-" + OVkaart.getId(), reizigerJsonObj);

      return OVkaart;
   }

   @Override
   public List<OVKaart> findAll() {
      Jedis conn = getConnection();
      
      List<OVKaart> tempOVKaarts = new ArrayList<OVKaart>();
      for(String key : conn.keys("OVKaart-*")) {
         OVKaart OVKaartFromDb = gson.fromJson(conn.get(key), OVKaart.class);
         tempOVKaarts.add(OVKaartFromDb);
      }
      
      return tempOVKaarts;
   }

   @Override
   public List<Reiziger> findByGBdatum(String geboortedatum) {
      Jedis conn = getConnection();
      
      List<Reiziger> tempReizigers = new ArrayList<Reiziger>();
      for(String key : conn.keys("reiziger-*")) {
         Reiziger reizigerFromDb = gson.fromJson(conn.get(key), Reiziger.class);

         if(
            reizigerFromDb.getGeboortedatum() != null && 
            reizigerFromDb.getGeboortedatum().equals(geboortedatum)) {
            tempReizigers.add(reizigerFromDb);
         }
      }
      
      return tempReizigers;
   }

   @Override
   public OVKaart update(OVKaart OVKaart) {
      save(OVKaart);
      return OVKaart;
   }

   @Override
   public boolean delete(OVKaart OVKaart) {
      Jedis conn = getConnection();
      conn.del("OVKaart-" +OVKaart.getId());
      return true;
   }
} 