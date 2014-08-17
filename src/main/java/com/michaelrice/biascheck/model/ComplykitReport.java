package com.michaelrice.biascheck.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="observation")
public class ComplykitReport {

	private String obligationId;
	private String observationType;
	private String notes;

	public String getObligationId() {
		return obligationId;
	}
	public void setObligationId(String obligationId) {
		this.obligationId = obligationId;
	}

	public String getObservationType() {
		return observationType;
	}
	public void setObservationType(String observationType) {
		this.observationType = observationType;
	}

	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
