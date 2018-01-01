package com.fireduptech.spring.rest.service;

import java.util.List;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import com.fireduptech.spring.rest.domain.AthleteAccount;


public interface AthleteAccountService {

	@PreAuthorize( " hasPermission( #athleteAccountId, 'com.fireduptech.spring.rest.domain.AthleteAccount', read ) or " 
								+ " hasPermission( #athleteAccountId, 'com.fireduptech.spring.rest.domain.AthleteAccount', admin ) " )
	AthleteAccount getAthleteAccount( int athleteAccountId  );


	@PreAuthorize( " hasAnyRole( 'ROLE_ADMIN', 'ROLE_ATHLETE' ) " )
	@PostFilter( " hasPermission( filterObject, read ) or hasPermission( filterObject, admin ) " )
	List<AthleteAccount> getAllAthleteAccounts();

}
