package smartbytes.restassured.testng;

public class AuthenticationAPI {

	public boolean login(String username,String password) {
		if(username.equals("smartbytes")) {
			if(password.equals("secret")) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
