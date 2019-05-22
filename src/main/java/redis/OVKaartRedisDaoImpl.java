package redis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import java.util.*;

public class OVKaartRedisDaoImpl extends RedisBaseDao implements OVKaartDao {

   private Gson gson;
   private static final String OVKAART_CODE = "ovchipkaart-";

   public OVKaartRedisDaoImpl() {
      super();
      gson = new Gson();
   }

   @Override
   public List<OVKaart> findAll() {
      Jedis conn = getConnection();
      
      List<OVKaart> tempOVKaarts = new ArrayList<OVKaart>();
      for(String key : conn.keys(OVKAART_CODE + "*")) {
         OVKaart OVKaartFromDb = gson.fromJson(conn.get(key), OVKaart.class);
         tempOVKaarts.add(OVKaartFromDb);
      }
      
      return tempOVKaarts;
   }

   @Override
   public List<OVKaart> findByKey(int reizigerID) {
      Jedis conn = getConnection();
      
      List<OVKaart> tempReizigers = new ArrayList<OVKaart>();
      for(String key : conn.keys(OVKAART_CODE + "*")) {
         OVKaart OVKaartFromDB = gson.fromJson(conn.get(key), OVKaart.class);
         
         if( OVKaartFromDB.getKaartnummer() == (reizigerID)) {
            tempReizigers.add(OVKaartFromDB);
         }
      }
      
      return tempReizigers;
   }

   @Override
   public List<OVKaart> findByReiziger(int kaartnummer) {
      Jedis conn = getConnection();
      
      List<OVKaart> tempReizigers = new ArrayList<OVKaart>();
      for(String key : conn.keys(OVKAART_CODE + "*")) {
         OVKaart OVKaartFromDB = gson.fromJson(conn.get(key), OVKaart.class);
         
         if(OVKaartFromDB.getReizigerID() == (kaartnummer)) {
            tempReizigers.add(OVKaartFromDB);
         }
      }
      
      return tempReizigers;
   }
   
   @Override
   public OVKaart save(OVKaart OVkaart) {
      Jedis conn = getConnection();

      String ovChipJsonObject = gson.toJson(OVkaart);
      conn.set(OVKAART_CODE + OVkaart.getId(), ovChipJsonObject);

      return OVkaart;
   }

   @Override
   public OVKaart update(OVKaart OVKaart) {
      return save(OVKaart);
   }
   
   @Override
   public boolean delete(OVKaart OVKaart) {
      Jedis conn = getConnection();
      conn.del(OVKAART_CODE +OVKaart.getId());
      return true;
   }
} 