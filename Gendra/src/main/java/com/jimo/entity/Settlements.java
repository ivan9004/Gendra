package com.jimo.entity;

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
public class Settlements {

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

	public Settlements() {
		super();
	}

	public Settlements(int settlement_id, String name, String zona_type, String settlement_type) {
		super();
		this.settlement_id = settlement_id;
		this.name = name;
		this.zona_type = zona_type;
		this.settlement_type = settlement_type;
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

}
