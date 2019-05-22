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

  }
}