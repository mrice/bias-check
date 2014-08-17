package com.michaelrice.biascheck.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MarketThresholds
 *
 */
@Entity
@Table(name="market_thresholds")
public class MarketThresholds implements Serializable {

	private static final long serialVersionUID = 1L;

	public MarketThresholds() {
		super();
	}
   
	@Id
	private Integer id;
	
	@Column(name="zip_code")
	private String zipCode;

	@Column(name="city_state_descr")
	private String cityState;

	@Column(name="threshold_warn")
	private Float thresholdWarn;

	@Column(name="threshold_noncomply")
	private Float thresholdNoncomply;

	@Column(name="minority_population")
	private Integer minorityPopulation;

	@Column(name="product_code")
	private String productCode;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCityState() {
		return cityState;
	}
	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

	public Float getThresholdWarn() {
		return thresholdWarn;
	}
	public void setThresholdWarn(Float thresholdWarn) {
		this.thresholdWarn = thresholdWarn;
	}

	public Float getThresholdNoncomply() {
		return thresholdNoncomply;
	}
	public void setThresholdNoncomply(Float thresholdNoncomply) {
		this.thresholdNoncomply = thresholdNoncomply;
	}

	public Integer getMinorityPopulation() {
		return minorityPopulation;
	}
	public void setMinorityPopulation(Integer minorityPopulation) {
		this.minorityPopulation = minorityPopulation;
	}

	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

}
