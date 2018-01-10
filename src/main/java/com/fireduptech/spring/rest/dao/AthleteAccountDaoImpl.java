package com.fireduptech.spring.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import java.time.*;
import java.time.format.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import org.springframework.stereotype.Repository;

import com.fireduptech.spring.rest.domain.AthleteAccount;


@Repository
public class AthleteAccountDaoImpl implements AthleteAccountDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	@Override
	public AthleteAccount getAthleteAccount( int athleteAccountId ) {

		final String sql = "select * from athlete_account where id = :athleteAccountId";

		SqlParameterSource namedParameters = new MapSqlParameterSource( "athleteAccountId", athleteAccountId );

		return namedParameterJdbcTemplate.query( sql, namedParameters,
				new ResultSetExtractor<AthleteAccount>() {
					
					AthleteAccount acd = new AthleteAccount();

					@Override
					public AthleteAccount extractData( ResultSet rs ) throws SQLException, DataAccessException {
						while ( rs.next() ) {
							acd.setId( Integer.parseInt( rs.getString( "id" ) ) );
							acd.setAccountType( rs.getString( "account_type" ) );
							acd.setFirstName( rs.getString( "first_name" ) );
							acd.setLastName( rs.getString( "last_name" ) );
							acd.setEmail( rs.getString( "email" ) );
							acd.setPrimaryActivity( rs.getString( "primary_activity" ) );
						}
						return acd;
					}
				} );
	}


	@Override
	public List<AthleteAccount> getAllAthleteAccounts() {

		final String sql = "select * from athlete_account";

		return namedParameterJdbcTemplate.query( sql, 
				new ResultSetExtractor<List<AthleteAccount>>() {

					List<AthleteAccount> acds = new ArrayList<AthleteAccount>();

					@Override
					public List<AthleteAccount> extractData( ResultSet rs ) throws SQLException, DataAccessException {
							while ( rs.next() ) {
								AthleteAccount acd = new AthleteAccount();
								acd.setId( Integer.parseInt( rs.getString( "id" ) ) );
								acd.setAccountType( rs.getString( "account_type" ) );
								acd.setFirstName( rs.getString( "first_name" ) );
								acd.setLastName( rs.getString( "last_name" ) );
								acd.setEmail( rs.getString( "email" ) );
								acd.setPrimaryActivity( rs.getString( "primary_activity" ) );
								acds.add( acd );
							}

						return acds;
					} 
				});
				
	}


}
