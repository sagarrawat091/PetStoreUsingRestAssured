package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

 
import api.Endpoints.UserEndPointsusingprop;
import api.payloads.User;
import io.restassured.response.Response;

public class userTest2 {
	Faker faker;
	User payload;
	public Logger logger;
	@BeforeClass
	public void setupMethod()
	{
		faker=new Faker();
		payload=new User();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().emailAddress());
		payload.setPhone(faker.phoneNumber().cellPhone());
		payload.setPassword(faker.internet().password(3, 8));
		
		
		//logs
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	//create user
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("**************************Creating User***************************************");

		Response res=UserEndPointsusingprop.createUser(payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("************************** User Created ***************************************");
		
	}
	
	//get user detials
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info("**************************Retiving  User***************************************");
		Response res=UserEndPointsusingprop.getUser(this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("**************************User Retrived***************************************");
	}
	
	//update the user deatils
	@Test(priority=3)
	public void testUpdateUser()
	{
		logger.info("**************************Updating User***************************************");
		// generate new data
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());

		Response res=UserEndPointsusingprop.updateUser(this.payload.getUsername(), payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//checking the data
		Response res1=UserEndPointsusingprop.getUser(this.payload.getUsername());
		res1.then().log().all();
		Assert.assertEquals(res1.getStatusCode(), 200);
		logger.info("**************************User Updated***************************************");
	}
	
	@Test(priority=4)
	public void testDeleteUser()
	{
		logger.info("**************************Deleting User***************************************");

		Response res=UserEndPointsusingprop.deleteUser(this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("************************** User Deleted***************************************");
		
	}
	

}
