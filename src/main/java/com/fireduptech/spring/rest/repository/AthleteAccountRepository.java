package com.fireduptech.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fireduptech.spring.rest.domain.AthleteAccount;


public interface AthleteAccountRepository extends JpaRepository<AthleteAccount, Integer> {

	AthleteAccount save( AthleteAccount entity );

}

