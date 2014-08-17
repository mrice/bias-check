package com.michaelrice.biascheck;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;

public class BiasCheckRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		// pseudocode:
		// (1) query originations database
		// (2) cross reference with the demographics database
		// (3) if cross threshold-1, set to warn
		// (4) if cross threshold-2, set to force-compliance
		// (5) otherwise, leave at compliant
		// (6) push the message to complykit

		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
		jaxbDataFormat.setContextPath("com.michaelrice.biascheck.model");

		from("jpa:com.michaelrice.biascheck.model.OriginationSummary?consumeDelete=false")
			.process(new ZipCodeExtractor())
			.process(new MarketAnalyzer())
			.process(new DestinationProcessor())
			.marshal(jaxbDataFormat)
				.setHeader(Exchange.HTTP_METHOD, constant("PUT"))
				.setHeader(Exchange.CONTENT_TYPE, constant("text/xml"))
			//.to("http://localhost:8080/complykit-ee/api/obligation/1/observation");
			.recipientList(header("ck-destination"));
		//TODO add a switch here for the observation we should be recording

		//OKAY: so here's what to do: 
		// setup up a bunch of different observations for different zip codes
		// have the route PUT to those ids instead of posting
		
	}

}
