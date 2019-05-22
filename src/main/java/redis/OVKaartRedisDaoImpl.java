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
   public List<OVKaart> findAll() {
      Jedis conn = getConnection();
      
      List<OVKaart> tempOVKaarts = new ArrayList<OVKaart>();
      for(String key : conn.keys("ovchipkaart-*")) {
         OVKaart OVKaartFromDb = gson.fromJson(conn.get(key), OVKaart.class);
         tempOVKaarts.add(OVKaartFromDb);
      }
      
      return tempOVKaarts;
   }
   
   
   @Override
   public List<OVKaart> findByKey(int reizigerID) {
      Jedis conn = getConnection();
      
      List<OVKaart> tempReizigers = new ArrayList<OVKaart>();
      for(String key : conn.keys("ovchipkaart-*")) {
         OVKaart OVKaartFromDB = gson.fromJson(conn.get(key), OVKaart.class);
         
         if( 
            OVKaartFromDB.getKaartnummer() == (reizigerID)) {
               tempReizigers.add(OVKaartFromDB);
         }
      }
      
      return tempReizigers;
   }
   

   @Override
   public List<OVKaart> findByReiziger(int kaartnummer) {
      Jedis conn = getConnection();
      
      List<OVKaart> tempReizigers = new ArrayList<OVKaart>();
      for(String key : conn.keys("ovchipkaart-*")) {
         OVKaart OVKaartFromDB = gson.fromJson(conn.get(key), OVKaart.class);
         
         if( 
            OVKaartFromDB.getReizigerID() == (kaartnummer)) {
               tempReizigers.add(OVKaartFromDB);
         }
      }
      
      return tempReizigers;
   }
   
   
   @Override
   public OVKaart save(OVKaart OVkaart) {
      Jedis conn = getConnection();

      String ovChipJsonObject = gson.toJson(OVkaart);
      conn.set("ovchipkaart-" + OVkaart.getId(), ovChipJsonObject);

      return OVkaart;
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