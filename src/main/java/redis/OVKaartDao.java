package redis;

import java.util.*;

public interface OVKaartDao {
	
	public List<OVKaart> findAll();

	public List<OVKaart> findByKey(String kaartnummer);
	
	public List<OVKaart> findByReiziger(String reizigerID);
	
	public OVKaart save(OVKaart OVKaart);
	
	public OVKaart update(OVKaart OVKaart);

	public boolean delete(OVKaart OVKaart);
}
