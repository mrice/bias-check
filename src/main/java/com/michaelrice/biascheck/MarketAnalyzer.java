package com.michaelrice.biascheck;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.michaelrice.biascheck.model.ComplykitReport;
import com.michaelrice.biascheck.model.MarketThresholds;
import com.michaelrice.biascheck.model.OriginationSummary;

public class MarketAnalyzer implements Processor {

	public void process(Exchange exchange) throws Exception {

		OriginationSummary summary = exchange.getIn().getBody(OriginationSummary.class);
		String zipCode = summary.getZipCode();
		
		EntityManager em = Persistence.createEntityManagerFactory("camel").createEntityManager();
		Query q = em.createQuery("from MarketThresholds where zipCode=?", MarketThresholds.class);
		q.setParameter(1, zipCode);
		
		MarketThresholds thresholds = (MarketThresholds)q.getSingleResult();
		if (thresholds == null) {
			exchange.setProperty("analysis-complete", Boolean.FALSE);
		} else {
			
			double pctSold = summary.getOriginationCount().doubleValue() / thresholds.getMinorityPopulation().doubleValue();
			
			ComplykitReport report = new ComplykitReport();
			
			if (pctSold > thresholds.getThresholdNoncomply()) {
				report.setObservationType("noncompliant");
				exchange.setProperty("compliance-status", "noncompliant");
			} else if (pctSold > thresholds.getThresholdWarn()) {
				report.setObservationType("warn");
				exchange.setProperty("compliance-status", "warn");
			} else {
				report.setObservationType("comply");
				exchange.setProperty("compliance-status", "comply");
			}
			
			String note = String.format("%s Population: %s; originations: %s; pct: %s; warn-threshold: %s; noncomply-threshold: %s", thresholds.getZipCode(),
					thresholds.getMinorityPopulation(), summary.getOriginationCount(), pctSold, thresholds.getThresholdWarn(), thresholds.getThresholdNoncomply());
			
			report.setNotes(note);
			
			//TODO: do I set the out message or override the in message? or what
			exchange.getIn().setBody(report);
			exchange.setProperty("analysis-complete", Boolean.TRUE);
		}

	}

}
