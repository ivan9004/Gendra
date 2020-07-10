package com.jimo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "settlements")
@ApiModel(description = "Este es el modelo referente a los asentamientos de cada código postal")
public class Settlements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Campo que corresponde al identificador del asentamiento en la base de datos")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "settlement_id", updatable = false, nullable = false)
	private int settlement_id;
	@ApiModelProperty(notes = "Campo que corresponde al nombre del asentamiento")
	@Column(name = "name")
	private String name;
	@ApiModelProperty(notes = "Campo que corresponde al tipo de zona del asentamiento")
	@Column(name = "zona_type")
	private String zona_type;
	@ApiModelProperty(notes = "Campo que corresponde al tipo de asentamiento")
	@Column(name = "settlement_type")
	private String settlement_type;
	@ApiModelProperty(notes = "Campo que corresponde a la relacion entre la tabla zip_code y settlements")
	@Column(name = "zip_code_settlement", updatable = false, nullable = false)
	public int zip_code_settlement;

	public Settlements() {
		super();
	}

	public Settlements(int settlement_id, String name, String zona_type, String settlement_type,
			int zip_code_settlement) {
		super();
		this.settlement_id = settlement_id;
		this.name = name;
		this.zona_type = zona_type;
		this.settlement_type = settlement_type;
		this.zip_code_settlement = zip_code_settlement;
	}

	public int getSettlement_id() {
		return settlement_id;
	}

	public void setSettlement_id(int settlement_id) {
		this.settlement_id = settlement_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZona_type() {
		return zona_type;
	}

	public void setZona_type(String zona_type) {
		this.zona_type = zona_type;
	}

	public String getSettlement_type() {
		return settlement_type;
	}

	public void setSettlement_type(String settlement_type) {
		this.settlement_type = settlement_type;
	}

	public int getZip_code_settlement() {
		return zip_code_settlement;
	}

	public void setZip_code_settlement(int zip_code_settlement) {
		this.zip_code_settlement = zip_code_settlement;
	}

}
