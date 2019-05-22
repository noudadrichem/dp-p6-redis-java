package redis;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;;

public class OVKaart {
  @SerializedName("kaartnummer")
  @Expose
  private String kaartnummer;
  @SerializedName("geldigTot")
  @Expose
  private String geldigTot;
  @SerializedName("klasse")
  @Expose
  private String klasse;
  @SerializedName("saldo")
  @Expose
  private String saldo;
  @SerializedName("reizigerID")
  @Expose
	private String reizigerID;

	public OVKaart(String kaartnummer, String geldigTot, String klasse, String saldo, String reizigerID) {
		this.kaartnummer = kaartnummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerID = reizigerID;
	}


	public String getKaartnummer() {
		return kaartnummer;
	}

	public void setKaartnummer(String kaartnummer) {
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

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(String reizigerID) {
		this.reizigerID = reizigerID;
	}

	public String toString() {
		String result = "* OV Chipkaart met kaartnummer " + kaartnummer + " is geldig tot " + geldigTot +  
				" rijdt met klasse " + klasse + " heeft een saldo van " + saldo +
				" en is van" + " de reiziger met id: " + reizigerID + "\n" ;
		return result;
	}
}