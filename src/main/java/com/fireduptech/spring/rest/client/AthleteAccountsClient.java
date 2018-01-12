package com.fireduptech.spring.rest.client;


import java.util.List;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fireduptech.spring.rest.domain.AthleteAccount;

import org.springframework.util.*;


public class AthleteAccountsClient {


	private static ApplicationContext context;

	private static final String LOGIN_URL = "http://localhost:8080/springRestApi/login";

	private static String set_cookie;


	public static void main( String[] args ) {

		context = new ClassPathXmlApplicationContext( "classpath:META-INF/spring/applicationContext-restClient.xml" );

		System.out.println( "Welcome to the Athlete Accounts Client: " );

		loginToAthleteAccount( context.getBean( RestTemplate.class ) );

		getAthleteAccountsList( context.getBean( RestTemplate.class ) );

		getAthleteAccount( context.getBean( RestTemplate.class ) );

	}



	private static void loginToAthleteAccount( RestTemplate restTemplate ) {

		HttpHeaders headers = new HttpHeaders();
		headers.add( "Accept", "application/json" );

		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add( "username", "atheteAdmin@testing.com" );
		body.add( "password", "test" );		

		HttpEntity<?> httpEntity = new HttpEntity<Object>( body, headers );


		HttpEntity<String> response = restTemplate.exchange( AthleteAccountsClient.LOGIN_URL, HttpMethod.POST, httpEntity, String.class );

		HttpHeaders responseHeaders = response.getHeaders();
		AthleteAccountsClient.set_cookie = responseHeaders.getFirst( headers.SET_COOKIE );

		System.out.println( " ---> Response: " + response.toString() + "\n\n" );
		System.out.println( " ---> Set-Cookie: " + set_cookie + "\n\n" );

	}



	private static void getAthleteAccountsList( RestTemplate restTemplate ) {

		HttpHeaders headers = new HttpHeaders();
		headers.add( "Accept", "application/json" );

		headers.add( "Cookie", AthleteAccountsClient.set_cookie );

		HttpEntity<String> requestEntity = new HttpEntity<String>( headers );

		ParameterizedTypeReference<List<AthleteAccount>> typeRef = new ParameterizedTypeReference<List<AthleteAccount>>() {
		};


		ResponseEntity<List<AthleteAccount>> responseEntity = restTemplate.exchange(
			"http://localhost:8080/springRestApi/api/athleteAccount/list",
			HttpMethod.GET, requestEntity, typeRef );


		List<AthleteAccount> athleteAccountsList = responseEntity.getBody();

		System.out.println( athleteAccountsList );


		for ( AthleteAccount athleteAccount : athleteAccountsList ) {
			System.out.println( athleteAccount.getEmail() );
		}

		System.out.println( "\n\n\n ---- \n\n\n" );
	}	



	private static void getAthleteAccount( RestTemplate restTemplate ) {

		HttpHeaders headers = new HttpHeaders();
		headers.add( "Accept", "application/json" );
		headers.add( "Cookie", AthleteAccountsClient.set_cookie );

		HttpEntity<String> requestEntity = new HttpEntity<String>( headers );

		ResponseEntity<AthleteAccount> responseEntity = restTemplate.exchange(
			"http://localhost:8080/springRestApi/api/athleteAccount?acAction=view&athleteAccountId=34",
				HttpMethod.GET, requestEntity, AthleteAccount.class );


		AthleteAccount athleteAccount = responseEntity.getBody();

		System.out.println( athleteAccount );
		System.out.println( "\n\n\n ---- \n\n\n" );
	}

}



