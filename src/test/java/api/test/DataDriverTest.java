package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.Endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.dataProviders;
import io.restassured.response.Response;

// we are sending multiple user using post request and then retrive username from excel and delete all users
public class DataDriverTest {
	
	@Test(priority=1,dataProvider="data",dataProviderClass=dataProviders.class)
	public void testPostUser(String userID,String userName,String fName,String lName,String userEmail,String pwd,String phone)
	{
		User payload=new User();
		payload.setId(Integer.parseInt(userID));
		payload.setUsername(userName);
		payload.setFirstName(fName);
		payload.setLastName(lName);
		payload.setEmail(userEmail);
		payload.setPassword(pwd);
		payload.setPhone(phone);
		
		
		Response res=UserEndPoints.createUser(payload);
		Assert.assertEquals(res.getStatusCode(), 200);

	}

	@Test(priority=2,dataProvider="UserNames",dataProviderClass=dataProviders.class)
	public void deleteUser(String username)
	{
		User payload=new User();
		payload.setUsername(username);
		Response res=UserEndPoints.deleteUser(username);
		Assert.assertEquals(res.getStatusCode(),200 );
	}
}
