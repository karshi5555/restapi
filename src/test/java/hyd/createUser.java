package hyd;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class createUser {

	@BeforeTest
	public void beforeTest() {

		RestAssured.baseURI = "https://gorest.co.in/public/v2/";

	}

	@Test(priority = 3)
	public void testCreateUser() throws IOException {

		String path = System.getProperty("user.dir");

		File file = new File(path + "\\src\\test\\resources\\testdata\\user.json");

		String testNew = FileUtils.readFileToString(file, "UTF-8");

		testNew =	testNew.replace("${email}", "user1" + System.currentTimeMillis() + "@a.com");
		
		System.out.println(testNew);

		userdata user = new userdata();
		user.setName("goa");
		user.setEmail("goa1@gmail.com");
		user.setGender("male");
		user.setStatus("inactive");
		
		

		Map<String, String> userData = new HashMap<>();
		userData.put("name", "Hyd1");
		userData.put("email", "a5@a.com");
		userData.put("gender", "male");
		userData.put("status", "inactive");
//
//		String body = """
//						{
//
//				        "name": "Hyd1",
//				        "email": "Hyd5@gmail.com",
//				        "gender": "male",
//				        "status": "inactive"
//				    }
//				""";

		given().headers("Authorization", "Bearer c9e9392c7c918944ba21289fb78a1cebc999e9b21971603eb312cbd5e71424ee")
				.contentType("application/json").

				body(testNew).log().all().when().post("users").

				then().log().all().statusCode(201).

				body("name", equalTo("Hyd1")).body("gender", equalTo("male"));

	}

}
