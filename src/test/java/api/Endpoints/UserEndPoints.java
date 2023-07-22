package api.Endpoints;
//created for CRUD Operations
import api.payloads.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import org.json.JSONObject;
//import org.testng.ITestContext;
//import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class UserEndPoints {
	
	public static Response createUser(User payload)
	{
		Response res=given().
						contentType(ContentType.JSON).
						accept(ContentType.JSON).
						body(payload).
					when().
						post(routes.post_url);
		return res;
	}
	
	///get user 
	public static Response getUser(String UserName)
	{
		Response res=given().
						pathParams("username", UserName).
					when().
						get(routes.get_url);
		return res;
	}
	
	//update user
	public static Response updateUser(String UserName,User payload)
	{
		Response res=given().
						contentType(ContentType.JSON).
						accept(ContentType.JSON).
						pathParams("username", UserName).
						body(payload).
					when().
						put(routes.update_url);
		return res;
	}
	
	//Delete User
	
	///get user 
		public static Response deleteUser(String UserName)
		{
			Response res=given().
							pathParams("username", UserName).
						when().
							get(routes.delete_url);
			return res;
		}
	
	
}
