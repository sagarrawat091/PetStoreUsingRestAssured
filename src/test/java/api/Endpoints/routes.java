package api.Endpoints;

/**
Swagger URI-----

create user (post): https://petstore.swagger.io/v2/user
get user (post): https://petstore.swagger.io/v2/user/{username}
update user (post): https://petstore.swagger.io/v2/user/{username}
delete user (post): https://petstore.swagger.io/v2/user/{username}

**/

public class routes {
	public static String base_url="https://petstore.swagger.io/v2/";
	
	//User Module
	
	public static String post_url=base_url+"user/";
	public static String get_url=base_url+"user/{username}";
	public static String update_url=base_url+"user/{username}";
	public static String delete_url=base_url+"user/{username}";

}
