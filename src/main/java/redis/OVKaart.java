package redis;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;;

public class OVKaart {
	@SerializedName("id")
	@Expose
	private int id;
  @SerializedName("kaartnummer")
  @Expose
  private int kaartnummer;
  @SerializedName("geldigTot")
  @Expose
  private String geldigTot;
  @SerializedName("klasse")
  @Expose
  private String klasse;
  @SerializedName("saldo")
  @Expose
  private int saldo;
  @SerializedName("reizigerID")
  @Expose
	private int reizigerID;

	public OVKaart(int id ,int kaartnummer, String geldigTot, String klasse, int saldo, int reizigerID) {
		this.id = id;
		this.kaartnummer = kaartnummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerID = reizigerID;
	}

	public int getId() {
		return id;
	}

	public int getKaartnummer() {
		return kaartnummer;
	}

	public void setKaartnummer(int kaartnummer) {
		this.kaartnummer = kaartnummer;
	}

	public String getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(String geldigTot) {
		this.geldigTot = geldigTot;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}

	public String toString() {
		String result = "* OV Chipkaart met kaartnummer " + kaartnummer + " is geldig tot " + geldigTot +  
				" rijdt met klasse " + klasse + " heeft een saldo van " + saldo +
				" en is van" + " de reiziger met id: " + reizigerID + "\n" ;
		return result;
	}
}