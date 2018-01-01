package com.fireduptech.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fireduptech.spring.rest.dao.AthleteAccountDao;
import com.fireduptech.spring.rest.domain.AthleteAccount;


@Service
public class AthleteAccountServiceImpl implements AthleteAccountService {

	@Autowired
	private AthleteAccountDao athleteAccountDao;


	@Override
	public AthleteAccount getAthleteAccount( int athleteAccountId  ) {
		return athleteAccountDao.getAthleteAccount( athleteAccountId );
	}

	@Override
	public List<AthleteAccount> getAllAthleteAccounts() {
		return athleteAccountDao.getAllAthleteAccounts();
	}

}

