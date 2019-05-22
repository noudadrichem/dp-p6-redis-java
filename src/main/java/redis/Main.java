package redis;

class Main {
  public static void main(String[] args) {

    Reiziger reiziger1 = new Reiziger(1, "N", "", "Adrichem", "1998/05/13");
    Reiziger reiziger2 = new Reiziger(2, "R", "", "Dahmani");
    Reiziger reiziger3 = new Reiziger(3, "D", "", "Neuteboom");
    Reiziger reiziger4 = new Reiziger(4, "T", "", "dummy", "1998/05/13");

    RedisDaoImpl reizigerRedisDao = new RedisDaoImpl();

    // Reiziger toevoegen/opslaan:

    System.out.println("- Opgeslagen reiziger:" + reizigerRedisDao.save(reiziger1).toString());
    System.out.println("- Opgeslagen reiziger:" + reizigerRedisDao.save(reiziger2).toString());
    System.out.println("- Opgeslagen reiziger:" + reizigerRedisDao.save(reiziger3).toString());
    System.out.println("- Opgeslagen reiziger:" + reizigerRedisDao.save(reiziger4).toString());

    // Alle reizigers vinden
    System.out.println(reizigerRedisDao.findAll());

    // Reizigers zoeken op geboortedatum
    System.out.println(reizigerRedisDao.findByGBdatum("1998/05/13"));

    // Gegevens reiziger aanpassen en opslaan
    reiziger3.setVoorletters("PK");
    reiziger3.setAchternaam("Mage");
    System.out.println("- Reiziger is geupdate: " + reizigerRedisDao.update(reiziger3).toString());

    // Verwijder reiziger
    System.out.println("- Reiziger is verwijderd: " + reizigerRedisDao.delete(reiziger4));


		OVKaartRedisDaoImpl OVKaartRedisDaoImpl = new OVKaartRedisDaoImpl();
		OVKaart ov1 = new OVKaart(1, 22222, "2020-12-12", "student", 11, 1);
		OVKaart ov2 = new OVKaart(2, 33333, "2019-06-13", "student", 52, 2);
		OVKaart ov3 = new OVKaart(3, 44444, "2021-08-24", "student", 13, 3);

		System.out.println("- Opgeslagen OVKaart:" + OVKaartRedisDaoImpl.save(ov1).toString());
		System.out.println("- Opgeslagen OVKaart:" + OVKaartRedisDaoImpl.save(ov2).toString());
		System.out.println("- Opgeslagen OVKaart:" + OVKaartRedisDaoImpl.save(ov3).toString());
	
		System.out.println("- Zoek op OVkaart nummer: 46392\n " + OVKaartRedisDaoImpl.findByKey(22222));
		System.out.println("- Zoek op ReizigerID: 5 ->\n " + OVKaartRedisDaoImpl.findByReiziger(1));

		ov3.setSaldo(30);
		ov3.setKlasse("business-card");
		System.out.println("- OV Kaart is geupdate: " + OVKaartRedisDaoImpl.update(ov3).toString());
		

		// Alle OVKaarten zoeken
		System.out.println(OVKaartRedisDaoImpl.findAll());

		// verwijder reiziger
		// System.out.println("- OV Kaart is verwijderd: " + OVKaartRedisDaoImpl.delete(ov1));
	}
}