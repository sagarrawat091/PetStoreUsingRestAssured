package api.Endpoints;
//created for CRUD Operations
import api.payloads.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import org.json.JSONObject;
//import org.testng.ITestContext;
//import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

public class UserEndPointsusingprop {
	
		public static ResourceBundle get_Url()
		{
			ResourceBundle bundle=ResourceBundle.getBundle("Route");
			return bundle;
		}
	
	
	public static Response createUser(User payload)
	{
		String post_url=get_Url().getString("post_url");
		Response res=given().
						contentType(ContentType.JSON).
						accept(ContentType.JSON).
						body(payload).
					when().
						post(post_url);
		return res;
	}
	
	///get user 
	public static Response getUser(String UserName)
	{
		String get_url=get_Url().getString("get_url");

		Response res=given().
						pathParams("username", UserName).
					when().
						get(get_url);
		return res;
	}
	
	//update user
	public static Response updateUser(String UserName,User payload)
	{
		String update_url=get_Url().getString("update_url");

		Response res=given().
						contentType(ContentType.JSON).
						accept(ContentType.JSON).
						pathParams("username", UserName).
						body(payload).
					when().
						put(update_url);
		return res;
	}
	
	//Delete User
	
	///get user 
		public static Response deleteUser(String UserName)
		{
			String delete_url=get_Url().getString("delete_url");

			Response res=given().
							pathParams("username", UserName).
						when().
							get(delete_url);
			return res;
		}
	
	
}
