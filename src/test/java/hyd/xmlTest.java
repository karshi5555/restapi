package hyd;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import rest.pojo.AppUtil;
import rest.pojo.JsonData;

public class xmlTest extends rest.pojo.baseTest {

	@Test(dataProvider = "jsondata", description = "This test validates the XML response from the API endpoint.")
	public void AddXml(JsonData data) throws IOException {

		System.out.println("Test Name: " + data.getBaseUri());
		System.out.println("Test Description: " + data.getBody());

		AppUtil util = new AppUtil();

		Response res = util.createRequest(data);
		util.validateResponse(res, data.getExpectedStatus());
		util.validateResposneData(res, data);

	}

	@Test(description = "This test validates the XML response from the API endpoint.")
	public void validateXmlResponse() {

		RestAssured.baseURI = "http://www.dneonline.com/"; // Replace with your actual endpoint

		given().queryParam("op", "add").header("Content-Type", "text/xml; charset=utf-8")
				.body("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" + "  <soap:Body>\n"
						+ "    <Add xmlns=\"http://tempuri.org/\">\n" + "      <intA>5</intA>\n"
						+ "      <intB>10</intB>\n" + "    </Add>\n" + "  </soap:Body>\n" + "</soap:Envelope>")
				.log().all().when().post("calculator.asmx") // Replace with your actual resource path
				.then().statusCode(200)

				.log().all();

		// Implement XML response validation logic here
		// You can use libraries like JAXB or XMLUnit for XML parsing and validation
	}
	
	//ecommerce
	//2
	//java
	//selenium
	//rest api
	//test ng
	//jenkins
	//git
	//grid
	
	//with 2 yeads of experience, you can explore the following areas to further enhance your skills and career prospects:
	
	
	//git - conflicts, merge
	//xpath
	
	
	//basic program
	//xpath
	//git
	//fraemwrok explanation
	//rest api
	//four classes
	//
	
	
	
}
