package com.fireduptech.spring.rest.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


public final class MyLogoutSuccessHandler implements LogoutSuccessHandler {


	@Override
	public void onLogoutSuccess( HttpServletRequest request, HttpServletResponse response, Authentication authentication ) throws IOException {

		response.setStatus( HttpServletResponse.SC_OK );
		response.getWriter().flush();
	}

}
