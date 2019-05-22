package redis;

import java.util.*;

public interface ReizigerDao {
	public Reiziger save(Reiziger reiziger);

	public List<Reiziger> findAll();

	public List<Reiziger> findByGBdatum(String geboortedatum);

	public Reiziger update(Reiziger reiziger);

	public boolean delete(Reiziger reiziger);
}
