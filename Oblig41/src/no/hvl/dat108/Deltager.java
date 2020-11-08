package no.hvl.dat108;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "oblig41")
public class Deltager {

	public Deltager() {
		super();
	}

	private String fornavn;
	private String etternavn;
	private String kjonn;
	
	@Embedded
	private Passord passord;
	
	@Id
	private int mobil;
	
	public Deltager(String fornavn, String etternavn, int mobil, String kjonn, Passord passord) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.kjonn = kjonn;
		this.passord = passord;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjønn(String kjønn) {
		this.kjonn = kjønn;
	}

	public Passord getPassord() {
		return passord;
	}

	public void setPassord(Passord passord) {
		this.passord = passord;
	}

	public int getMobil() {
		return mobil;
	}

	public void setMobil(int mobil) {
		this.mobil = mobil;
	}

	
}
