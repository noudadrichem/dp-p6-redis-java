package redis;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;;

public class Reiziger {
  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("voortletters")
  @Expose
  private String voorletters;
  @SerializedName("tussenvoegsel")
  @Expose
  private String tussenvoegsel;
  @SerializedName("achternaam")
  @Expose
  private String achternaam;
  @SerializedName("geboortedatum")
  @Expose
	private String geboortedatum;

	public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, String geboortedatum) {
		this.id = id;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
	}

	public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam) {
		this.id = id;
		this.voorletters = voorletters;
		this.achternaam = achternaam;
		this.tussenvoegsel = tussenvoegsel;
		this.geboortedatum = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public String toString() {
		return this.voorletters + " " + (tussenvoegsel == null ? "" : tussenvoegsel) + " " + this.achternaam
				+ " met de gbdatum:" + (geboortedatum == null ? "(Niet bekend)" : geboortedatum) + "\n" +"\n";
	}

}