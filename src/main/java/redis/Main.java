package redis;

class Main {
  public static void main(String[] args) {

    Reiziger reiziger1 = new Reiziger(1, "N", "", "Adrichem", "1998/05/13");
    Reiziger reiziger2 = new Reiziger(2, "R", "", "Dahmani");
    Reiziger reiziger3 = new Reiziger(3, "D", "", "Neuteboom");

    RedisDaoImpl reizigerOracleDao = new RedisDaoImpl();

    // Reiziger toevoegen/opslaan:

    System.out.println("- Opgeslagen reiziger:" + reizigerOracleDao.save(reiziger1).toString());
    System.out.println("- Opgeslagen reiziger:" + reizigerOracleDao.save(reiziger2).toString());
    System.out.println("- Opgeslagen reiziger:" + reizigerOracleDao.save(reiziger3).toString());

    // Alle reizigers vinden
    System.out.println(reizigerOracleDao.findAll());

    // Reizigers zoeken op geboortedatum
    System.out.println(reizigerOracleDao.findByGBdatum("1998/05/13"));

    // Gegevens reiziger aanpassen en opslaan
    reiziger3.setVoorletters("PK");
    reiziger3.setAchternaam("Mage");
    System.out.println("- Reiziger is geupdate: " + reizigerOracleDao.update(reiziger3).toString());

    // // Verwijder reiziger
    // System.out.println("- Reiziger is verwijderd: " + reizigerOracleDao.delete(reiziger1));
    // System.out.println("- Reiziger is verwijderd: " + reizigerOracleDao.delete(reiziger2));
    // System.out.println("- Reiziger is verwijderd: " + reizigerOracleDao.delete(reiziger3));

    // // Alle reizigers zoeken
    // System.out.println(reizigerOracleDao.findAll());

  }
}