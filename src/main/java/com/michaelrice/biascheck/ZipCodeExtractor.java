package com.michaelrice.biascheck;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.michaelrice.biascheck.model.OriginationSummary;

public class ZipCodeExtractor implements Processor {

	public void process(Exchange exchange) throws Exception {
		
		OriginationSummary summary = exchange.getIn().getBody(OriginationSummary.class);
		exchange.setProperty("zip", summary.getZipCode());

	}

}
