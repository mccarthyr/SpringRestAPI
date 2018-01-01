package com.fireduptech.spring.rest.dao;

import java.util.List;

import com.fireduptech.spring.rest.domain.AthleteAccount;


public interface AthleteAccountDao {

	AthleteAccount getAthleteAccount( int athleteAccountId );

	List<AthleteAccount> getAllAthleteAccounts();

}

