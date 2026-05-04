//package hyd;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.testng.annotations.Test;
//
//import io.restassured.response.Response;
//import rest.pojo.AppUtil;
//import rest.pojo.TestData;
//
//public class FcTestOne extends rest.pojo.baseTest {
//
//	int id;
//
//	@Test(dataProvider = "testdata", priority = 0)
//	public void getUsers(TestData data) {
//
//		AppUtil util = new AppUtil();
//
//		Response rs = util.createRequest(data);
//
//		util.validateResponse(rs, data.getStatuscode());
//
//		// util.validateResposneData(rs, data);
//
//	}
//
//	@Test(dataProvider = "testdata", priority = 1)
//	public void getUser(TestData data) {
//
//		AppUtil util = new AppUtil();
//
//		Response rs = util.createRequest(data);
//
//		util.validateResponse(rs, data.getStatuscode());
//
//		util.validateResposneData(rs, data);
//
//	}
//
//	@Test(dataProvider = "testdata", priority = 2)
//	public void CreateUser(TestData data) {
//
//		AppUtil util = new AppUtil();
//
//		String value = "user1" + System.currentTimeMillis() + "@a.com";
//
//		String body = data.getBody().replace("${email}", value);
//
//		data.setBody(body);
//
//		data.getResposneData().put("email", value);
//
//		Response rs = util.createRequest(data);
//
//		util.validateResponse(rs, data.getStatuscode());
//
//		util.validateResposneData(rs, data);
//
//		// wid = Integer.parseInt(rs.jsonPath().get("id"));
//
//		id = rs.jsonPath().getInt("id");
//
//		System.out.println(id);
//
//	}
//
//	@Test(dataProvider = "testdata", priority = 3)
//	public void UpdateUser(TestData data) {
//
//		AppUtil util = new AppUtil();
//
//		// String value = "user1" + System.currentTimeMillis() + "@a.com";
//
//		String body = data.getBody().replace("${email}", "th@gmail.com");
//
//		data.setBody(body);
//
//		Map<String, String> resData = new HashMap<>();
//		resData.put("email", "th@gmail.com");
//
//		data.setResposneData(resData);
//
//		Map<String, String> newId = new HashMap<>();
//		newId.put("userId", String.valueOf(id));
//
//		data.setPathparam(newId);
//
//		Response rs = util.createRequest(data);
//
//		util.validateResponse(rs, data.getStatuscode());
//
//		util.validateResposneData(rs, data);
//
//	}
//
//	@Test(dataProvider = "testdata", priority = 4)
//	public void DeleteUser(TestData data) {
//
//		AppUtil util = new AppUtil();
//
//		Map<String, String> pathp = new HashMap<>();
//		pathp.put("userId", String.valueOf(id));
//
//		data.setPathparam(pathp);
//
//		Response rs = util.createRequest(data);
//
//		util.validateResponse(rs, data.getStatuscode());
//
//	}
//
//}
