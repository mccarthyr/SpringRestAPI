package com.fireduptech.spring.rest.client;


import java.io.IOException;

import org.apache.commons.io.IOUtils;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;


public class MyRestClientErrorHandler extends DefaultResponseErrorHandler {

	@Override
	public void handleError( ClientHttpResponse response ) throws IOException {

		String body = IOUtils.toString( response.getBody() );

		System.out.println( "---> THIS IS FROM MyRestClientErrorHandler CLASS! <--- " );
		System.out.println( body );

		super.handleError( response );
	}

}



