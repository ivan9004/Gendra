package com.jimo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "zip_code")
public class ZipCode {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_zip;
	@Column(name = "zip_code")
	private String zip_code;
	@Column(name = "locality ")
	private String locality;
	@Column(name = "federal_entity ")
	private String federal_entity;
	@JoinColumn(name = "settlement_id", referencedColumnName = "settlement_id")
	@ManyToOne(targetEntity = Settlements.class, cascade = CascadeType.ALL)
	private Settlements settlement;
	@Column(name = "municipality")
	private String municipality;

	public ZipCode() {
		super();
	}

	public ZipCode(int id_zip, String zip_code, String locality, String federal_entity, Settlements settlement,
			String municipality) {
		super();
		this.id_zip = id_zip;
		this.zip_code = zip_code;
		this.locality = locality;
		this.federal_entity = federal_entity;
		this.settlement = settlement;
		this.municipality = municipality;
	}

	public int getId_zip() {
		return id_zip;
	}

	public void setId_zip(int id_zip) {
		this.id_zip = id_zip;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getFederal_entity() {
		return federal_entity;
	}

	public void setFederal_entity(String federal_entity) {
		this.federal_entity = federal_entity;
	}

	public Settlements getSettlement() {
		return settlement;
	}

	public void setSettlement(Settlements settlement) {
		this.settlement = settlement;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

}
