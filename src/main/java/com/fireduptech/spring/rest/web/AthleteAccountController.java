package com.fireduptech.spring.rest.web;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import java.security.Principal;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.apache.commons.lang.math.NumberUtils;

import com.fireduptech.spring.rest.domain.AthleteAccount;
import com.fireduptech.spring.rest.service.AthleteAccountService;


@Controller
@RequestMapping( value = "/athleteAccount" )
public class AthleteAccountController {

	@Autowired
	private AthleteAccountService athleteAccountService;



	@RequestMapping( value= "/list", method = RequestMethod.GET )
	public ResponseEntity<List<AthleteAccount>> listAthleteAccounts( Principal principal ) {

		/* This will list all the Athlete Accounts only for ROLE_ADMIN

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		Iterator<GrantedAuthority> iterator = authorities.iterator();
		if ( iterator.hasNext() ) {
			
			String role = (iterator.next()).getAuthority();
			if ( role.equalsIgnoreCase( "ROLE_ADMIN" ) ) {			
				List<AthleteAccount> athleteAccountsList = athleteAccountService.getAllAthleteAccounts();					
			}
		}
		*/

		return new ResponseEntity<List<AthleteAccount>>( athleteAccountService.getAllAthleteAccounts(), HttpStatus.OK );
	}



	@RequestMapping( params = "acAction=view", method = RequestMethod.GET )
	public ResponseEntity<AthleteAccount> viewAthleteAccount( @RequestParam( value = "athleteAccountId" ) int aaId ) {

		return new ResponseEntity<AthleteAccount>( athleteAccountService.getAthleteAccount( aaId ), HttpStatus.OK );
	}



	@ExceptionHandler
	@ResponseBody
	@ResponseStatus( code = HttpStatus.BAD_REQUEST )
	public String handleException( Exception ex ) {
		return ex.getMessage();
	}

}
