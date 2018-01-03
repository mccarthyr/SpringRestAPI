package com.fireduptech.spring.rest.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * The Entry Point will not redirect to any sort of Login
 * Instead it will return a Http Status 401
 */

public final class MyRestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence( final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException ) throws IOException {


		//response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized - THIS IS FROM ME ALSO!!!<--- " );		

		response.setStatus( HttpServletResponse.SC_UNAUTHORIZED );

		PrintWriter writer = response.getWriter();
		//writer.write( exception.getMessage() );
		writer.write( " ---> THIS IS FROM MY MY_REST_AUTHENTICATION_ENTRY_POINT !" );
		writer.flush();




	}

}




