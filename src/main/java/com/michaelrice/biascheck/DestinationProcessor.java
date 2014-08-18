package com.michaelrice.biascheck;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class DestinationProcessor implements Processor {
	
	private static String rootPath = "http://www.complykit.org/demo/api/obligation/16/observation/";
	private static Map<String, String> observationIds = new HashMap<String, String>();
	
	static {
		observationIds.put("91105", "40");
		observationIds.put("91106", "41");
	}

	public void process(Exchange exchange) throws Exception {
		
		String zip = (String)exchange.getProperty("zip");
		if (zip != null) {
			String observationId = observationIds.get(zip);
			if (observationId != null)
				exchange.setProperty("ck-destination", rootPath + observationId);
		}
		
	}

}
