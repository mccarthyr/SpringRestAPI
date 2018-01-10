# SpringRestAPI - Learning Project

Uses some hardcoded endpoints for basic REST GET calls. 
Configued with FasterXML Jackson for JSON Serialisation/Deserialisation.

Both the client and server components are packaged in the same project here. 

Run:
mvn tomcat7:redeploy -Dtomcat.username=<YOUR_USERNAME> -Dtomcat.password=<YOUR_PASSWORD>

to deploy the code to Tomcat.

Then run:
mvn exec:java 
to excute the client.

It will do a login call to the application and save the returned session Id. Then it calls to get a list of athlete accounts which it will print and then also do another call to list one specific athlete account.

There are the REST endpoints - 
springRestApi/api/athleteAccount/login
springRestApi/api/athleteAccount/athleteaccount/list
springRestApi/api/athleteAccount?acAction=view&athleteAccountId=34

The database and backend set up here is the as the one used in my Spring Security learning project (https://github.com/mccarthyr/springsecurity) except the Controller has been modified to return a ResponseEntity and most of the CRUD features have been removed for this small REST version, so it is a skimmed down codebase version but operates the same database structure.






