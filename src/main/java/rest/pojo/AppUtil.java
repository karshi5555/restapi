package rest.pojo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppUtil {

	public Response createRequest(JsonData data) throws IOException {

		Response response = null;

		ExtentTest extentTest = baseTest.getExtentTest();

		extentTest.info("Base URI: " + data.getBaseUri());
		extentTest.info("Resource Path: " + data.getResourcepath());
		extentTest.info("HTTP Method: " + data.getMethodname());
		extentTest.info("Headers: " + data.getHeaders());
		extentTest.info("Path Parameters: " + data.getPathparam());
		extentTest.info("Request Body: " + data.getBody());
		extentTest.info("Expected Status Code: " + data.getExpectedStatus());
		extentTest.info("Expected Response Data: " + data.getResponseData());

		RestAssured.baseURI = data.getBaseUri();

		RequestSpecification reqspec = RestAssured.given();

		if (data.getHeaders() != null && !data.getHeaders().isEmpty()) {

			reqspec.headers(data.getHeaders());

		}

//		if (data.getQueryparam() != null && !data.getQueryparam().isEmpty())
//
//		{
//
//			reqspec.queryParams(data.getQueryparam());
//
//		}
		if (data.getPathparam() != null && !data.getPathparam().isEmpty()) {
			reqspec.pathParams(data.getPathparam());

		}
		if (data.getQueryParamter() != null && !data.getQueryParamter().isEmpty()) {

			reqspec.queryParams(data.getQueryParamter());

		}

		if (data.getBody() != null && !data.getBody().isEmpty()) {

			if (data.getBody().endsWith(".json")) {

				String file = System.getProperty("user.dir") + "/src/test/resources/testdata/" + data.getBody();
				File f = new File(file);
				String reqbody = FileUtils.readFileToString(f, "UTF-8");
				String newbody = replaceDynamicData(reqbody, data.getDynamicdata());

				reqspec.body(newbody);

			} else {

				String file = System.getProperty("user.dir") + "/src/test/resources/testdata/jsondata/"
						+ data.getBody();
				File f = new File(file);
				String reqbody = FileUtils.readFileToString(f, "UTF-8");
				String newbody = replaceDynamicData(reqbody, data.getDynamicdata());

				reqspec.body(newbody);

			}

		}
//
//		if (data.getContenttype() != null && !data.getContenttype().isEmpty()) {
//
//			reqspec.contentType(data.getContenttype());
//
//		}

		reqspec.log().all();

		if ("GET".equalsIgnoreCase(data.getMethodname())) {
			response = reqspec.get(data.getResourcepath());

		} else if ("POST".equalsIgnoreCase(data.getMethodname()) && !data.getMethodname().isEmpty()) {

			response = reqspec.post(data.getResourcepath());

		} else if ("PUT".equalsIgnoreCase(data.getMethodname())) {

			response = reqspec.put(data.getResourcepath());

		} else if ("DELETE".equalsIgnoreCase(data.getMethodname())) {
			response = reqspec.delete(data.getResourcepath());
		}

		return response;

	}
//
//	public Response createRequest(String baseURI, String method, String resourcepath) {
//
//		Response response = null;
//
//		RestAssured.baseURI = baseURI;
//
//		RequestSpecification reqspec = RestAssured.given();
//
//		reqspec.log().all();
//
//		if ("GET".equalsIgnoreCase(method)) {
//			response = reqspec.get(resourcepath);
//
//		} else if ("POST".equalsIgnoreCase(method)) {
//			response = reqspec.post(resourcepath);
//
//		} else if ("PUT".equalsIgnoreCase(method)) {
//			response = reqspec.put(resourcepath);
//
//		} else if ("DELETE".equalsIgnoreCase(method)) {
//			response = reqspec.delete(resourcepath);
//		}
//
//		return response;
//
//	}

	public void validateResponse(Response response, int statuscode) {

//		ExtentTest extentTest = baseTest.getExtentTest();
//
//		String responseBody = response.getBody().asPrettyString();
//		extentTest.info("<pre>" + responseBody + "</pre>");

//
//		String responseBody = response.getBody().asPrettyString();
//		extentTest.info("<pre>" + responseBody + "</pre>");

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), statuscode, "Status code mismatch");

		// extentTest.pass("it is pass" + statuscode);

	}

	public void validateResposneData(Response response, JsonData data) {

		ExtentTest extentTest = baseTest.getExtentTest();

		Map<String, String> expectedData = data.getResponseData();
		
		String contentType = response.getContentType();

		if (contentType != null && contentType.contains("xml")) {

			String responseBody = response.getBody().asPrettyString();

			String escapedXml = responseBody.replace("<", "&lt;").replace(">", "&gt;");

			extentTest.info("<pre>" + escapedXml + "</pre>");

			expectedData.forEach((key, value) -> {
				String actualValue = response.xmlPath().getString(key);
				Assert.assertEquals(actualValue, value, "Mismatch for key: " + key);
				// extentTest.pass("key is" + key+" value is "+value);
			});

		} else {

			String responseBody = response.getBody().asPrettyString();

			extentTest.info("<pre>" + responseBody + "</pre>");

			expectedData.forEach((key, value) -> {
				String actualValue = response.jsonPath().getString(key);
				Assert.assertEquals(actualValue, value, "Mismatch for key: " + key);
				// extentTest.pass("key is" + key+" value is "+value);
			});

		}

	}

	public static String replaceDynamicData(String template, Map<String, String> dynamicValues) {

		String result = template;

		for (Map.Entry<String, String> entry : dynamicValues.entrySet()) {
			String placeholder = "${" + entry.getKey() + "}";
			result = result.replace(placeholder, entry.getValue());
		}
		return result;
	}

}
