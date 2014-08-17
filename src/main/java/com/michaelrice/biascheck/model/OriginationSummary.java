package com.michaelrice.biascheck.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: OriginationSummary
 *
 */
@Entity
@Table(name="origination_summaries")
public class OriginationSummary implements Serializable {

	private static final long serialVersionUID = 1L;

	public OriginationSummary() {
		super();
	}

	@Id
	private Integer id;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@Column(name="origination_count")
	private Integer originationCount;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getOriginationCount() {
		return originationCount;
	}
	public void setOriginationCount(Integer originationCount) {
		this.originationCount = originationCount;
	}

}
