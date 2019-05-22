package redis;

import java.util.*;

public interface ReizigerDao {
	
	public List<Reiziger> findAll();
	
	public List<Reiziger> findByGBdatum(String geboortedatum);
	
	public Reiziger save(Reiziger reiziger);
	
	public Reiziger update(Reiziger reiziger);

	public boolean delete(Reiziger reiziger);
}
