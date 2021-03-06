package com.jimo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "zip_code")
@ApiModel(description = "Este es el modelo referente a los codigos postales")
public class ZipCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Identificador que corresponde al objeto en la base de datos")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_zip;
	@ApiModelProperty(notes = "Este campo es el código postal")
	@Column(name = "zip_code")
	private int zip_code;
	@ApiModelProperty(notes = "Campo referente a la localidad del código postal")
	@Column(name = "locality ")
	private String locality;
	@ApiModelProperty(notes = "Campo referente a la entidad federativa del código postal")
	@Column(name = "federal_entity ")
	private String federal_entity;
	@ApiModelProperty(notes = "Campo de relación entre tablas zip_code y settlements en la base de datos permite enlistar los asentamientos correspondientes al código postal")
	@JoinColumn(name = "zip_code_settlement", referencedColumnName = "zip_code", insertable = false, updatable = false)
	@OneToMany
	private List<Settlements> settlement;
	@ApiModelProperty(notes = "Campo correspondiente al municipio del código postal")
	@Column(name = "municipality")
	private String municipality;

	public ZipCode() {
		super();
	}

	public ZipCode(int id_zip, int zip_code, String locality, String federal_entity, List<Settlements> settlement,
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

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
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

	public List<Settlements> getSettlement() {
		return settlement;
	}

	public void setSettlement(List<Settlements> settlement) {
		this.settlement = settlement;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

}
