package com.fireduptech.spring.rest.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure( HttpServletRequest request, HttpServletResponse response, AuthenticationException exception ) 
					throws IOException, ServletException {

		response.setStatus( HttpServletResponse.SC_UNAUTHORIZED );

		PrintWriter writer = response.getWriter();
		//writer.write( exception.getMessage() );
		writer.write( " ---> THIS IS FROM MY MY_AUTHENTICATION_FAILURE_HANDLER !" );
		writer.flush();

	}

}
