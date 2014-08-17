package com.michaelrice.biascheck;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class OriginationEnrichStrategy implements AggregationStrategy {

	public Exchange aggregate(Exchange original, Exchange resource) {
		// TODO Auto-generated method stub
		Object originalBody = original.getIn().getBody();
		Object resourceBody = resource.getIn().getBody();
		
		return original;
	}

}
