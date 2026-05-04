//package hyd;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.commons.io.FileUtils;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import io.restassured.response.Response;
//import rest.pojo.AppUtil;
//import rest.pojo.TestData;
//
//public class FcTest {
//
//	AppUtil util;
//
//	@BeforeTest
//	public void beforeTest() {
//
//		util = new AppUtil();
//
//	}
//
//	@Test
//	public void GetRq() {
//
//		TestData data = new TestData();
//		//String token ="asdhj";
//
//		Map<String, String> pathp = new HashMap<>();
//		pathp.put("userid", "8449794");
//		data.setBaseURI("https://gorest.co.in/public/v2/");
//		data.setMethod("GET");
//		data.setResourcepath("users/{userid}");	
//		data.setPathparam(pathp);
//		
//
//		Response res = util.createRequest(data);
//		util.validateResponse(res, 200);
//
//		String name = res.jsonPath().get("name");
//
//		Assert.assertEquals(name, "Laxmi Pilla");
//
//	}
//
//	@Test
//	public void postReq() throws IOException {
//
//		TestData data = new TestData();
//		
//		Map<String, String> headers = new HashMap<>();
//		headers.put("Authorization", "Bearer c9e9392c7c918944ba21289fb78a1cebc999e9b21971603eb312cbd5e71424ee");
//		headers.put("un", "Bearer a");
//
//		data.setBaseURI("https://gorest.co.in/public/v2/");
//		data.setMethod("POST");
//		data.setResourcepath("users");
//		data.setContenttype("application/json");
//		data.setHeaders(headers);
//		
//
//		String path = System.getProperty("user.dir");
//
//		File file = new File(path + "\\src\\test\\resources\\testdata\\user.json");
//
//		String testNew = FileUtils.readFileToString(file, "UTF-8");
//		
//		String email = "user1" + System.currentTimeMillis() + "@a.com";
//
//		testNew =	testNew.replace("${email}", email);
//		
//		data.setBody(testNew);
//		
//		Response res = util.createRequest(data);
//		
//		util.validateResponse(res, 201);
//		
//		Map<String, String> resData = new HashMap<>();
//		
//		resData.put("name", "Laxmi Pilla");
//		resData.put("status", "active");
//		resData.put("email", email);
//		resData.put("gender", "male");
//		
//		//util.validateResposneData(res, resData);
//		
//		
//		
//		
//	//	Assert.assertEquals(res.jsonPath().get("name"), "India");
//		
////		Assert.assertEquals(res.jsonPath().get("status"), "active");
//		
//		
//		
//		
//
//	}
//
//}
