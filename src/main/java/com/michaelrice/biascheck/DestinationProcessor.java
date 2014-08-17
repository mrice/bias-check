package com.michaelrice.biascheck;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class DestinationProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		String rootDestination = "http://localhost:8080/complykit-ee/api/obligation/2/observation/";
		if ("91105".equals(exchange.getProperty("zip"))) {
			exchange.setProperty("ck-destination", rootDestination + "23");
		} else if ("91106".equals(exchange.getProperty("zip"))) {
			exchange.setProperty("ck-destination", rootDestination + "24");
		} 

	}

}
