package redis;

import java.sql.Date;
import java.text.ParseException;

public class OV_Main {

	public static void main(String[] args) throws ParseException {

		// OVChipkaart

		OVChipkaartOracleDaoImpl ovchipkaartOracleDao = new OVChipkaartOracleDaoImpl();

		System.out.println("- Zoek op OVkaart nummer: 46392\n " + ovchipkaartOracleDao.findByKey(46392));
		System.out.println("- Zoek op ReizigerID: 5 ->\n " + ovchipkaartOracleDao.findByReiziger(5));

		@SuppressWarnings("deprecation")
		OVChipkaart ov1 = new OVChipkaart(22222, new Date(1120, 2, 20), 3, 11.5, 6);
		System.out.println("- Opgeslagen OVKaart:" + ovchipkaartOracleDao.save(ov1).toString());

		// Gegevens OVkaart wijzigen en opslaan
		ov1.setSaldo(30);
		ov1.setKlasse(1);
		System.out.println("- OV Kaart is geupdate: " + ovchipkaartOracleDao.update(ov1).toString());

		// Alle OVKaarten zoeken
		System.out.println(ovchipkaartOracleDao.findAll());

		// verwijder reiziger
		System.out.println("- OV Kaart is verwijderd: " + ovchipkaartOracleDao.delete(ov1));

		// Alle OVKaarten zoeken
		System.out.println(ovchipkaartOracleDao.findAll());

	}

}