package com.michaelrice.biascheck;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.michaelrice.biascheck.model.OriginationSummary;

public class BiasCheckRunner {

	public static void main(String[] args) throws Exception {
		new BiasCheckRunner().setupAndRunCamel();
		//new BiasCheckRunner().proveJpa();
	}

	private void setupAndRunCamel() throws Exception {

		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new BiasCheckRoute());
		camelContext.start();
		
		System.out.println("Bias checker started. Ctrl+C to quit...");
		while (true) {
			Thread.sleep(1000);
		}
		
	}
	
	private void proveJpa() throws Exception {
		EntityManager em = Persistence.createEntityManagerFactory("camel").createEntityManager();
		
		List<OriginationSummary> summaries = em.createQuery("from OriginationSummary", OriginationSummary.class).getResultList();
		
		for (OriginationSummary summary : summaries) {
			System.out.println(summary.getProductCode() + ": " +summary.getOriginationCount());
		}
		
	}
	
}
