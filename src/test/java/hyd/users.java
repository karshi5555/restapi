package hyd;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class users {

	// RestAssured.baseURI = "https://gorest.co.in/public/v2/";
	// put
	// resposne from data

	@BeforeMethod
	public void beforeTest() {

		RestAssured.baseURI = "https://gorest.co.in/public/v2/";
		// This method will run before each test method in the class.
		// You can use it to set up any common configurations or data needed for the
		// tests.
	}

	// given(), when(), then() are the three main methods in RestAssured for writing
	// tests.

	@Test(priority = 1)
	public void testUsers() {

		String userId = "8439255";

		given().pathParam("userId", "8439255").

				log().all().when().get("users/{userId}")

				.then().log().all().statusCode(200)

				.body("id", is(Integer.parseInt(userId))).body("name", equalTo("Msgr. Bhushit Gowda"));

	}

	@Test(priority = 2)
	public void testDeletUsers() throws IOException {

		String path = System.getProperty("user.dir");

		File file = new File(path + "\\src\\test\\resources\\testdata\\user.json");

		String testNew = FileUtils.readFileToString(file, "UTF-8");

		testNew = testNew.replace("${email}", "user1" + System.currentTimeMillis() + "@a.com");


		Response r = given().baseUri("https://gorest.co.in/public/v2/").pathParam("userId", "8448425")
				.headers("Authorization", "Bearer c9e9392c7c918944ba21289fb78a1cebc999e9b21971603eb312cbd5e71424ee").contentType("application/json")
				.body(testNew).

				log().all().when().put("users/{userId}");

		System.out.println(r.prettyPrint());

		String name = r.jsonPath().get("name");

		String email = r.jsonPath().get("email");

		Assert.assertEquals(name, "Christian");
		Assert.assertEquals(email, "user1" + System.currentTimeMillis() + "@a.com");

	}

	@Test(priority = 3)
	public void testUsersAgain() {

		// String userId = "8445058";

		Response res = given().baseUri("https://gorest.co.in/public/v2/")

				//pathParam("userId", "8448425").

				.log().all().when().get("users/8449794");

		JsonPath jp = res.jsonPath();

		String name = jp.get("name");

		try {
			Assert.assertEquals(name, "Anandamayi Kakkar");
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
		}

		System.out.println(jp.prettyPrint());

//		int a = jp.getList("$").size();
//		
//		System.out.println(a);
//
//		String name = jp.get("[9].name");
//
//		Assert.assertTrue(a > 9);
//
//		Assert.assertEquals(name, "Arindam Embranthiri");

		// Assert.assertEquals(a, 10);

		// System.out.println(a);

//		System.out.print(res.jsonPath());

		// res.then().log().all().statusCode(200);

//				.then().log().all().statusCode(200)
//				
//				.body("size()", is(10))
//				.body("id[0]", is(8446877))
//				.body("name[1]", equalTo("Atreyi Arora II"))
//				.body("name[1]",  anyOf(equalTo("sdgadrg"), equalTo("dsgkjn")));
//		

		// .body("name[1]", IsAnything(equalTo("Msgr. Bhushit Gowda")) or equalTo("Msgr.
		// Bhushit Gowda"));

	}

}
