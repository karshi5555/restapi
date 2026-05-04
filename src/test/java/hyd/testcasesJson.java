package hyd;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import rest.pojo.AppUtil;
import rest.pojo.JsonData;

public class testcasesJson extends rest.pojo.baseTest {

	int id;

	@Test(dataProvider = "jsondata", priority = 0)
	public void getUsers(JsonData data) {

		AppUtil util = new AppUtil();

		Response rs = null;
		try {
			rs = util.createRequest(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		util.validateResponse(rs, data.getExpectedStatus());

		// util.validateResposneData(rs, data);

	}

	@Test(dataProvider = "jsondata", priority = 1)
	public void getUser(JsonData data) {

		AppUtil util = new AppUtil();

		Response rs = null;
		try {
			rs = util.createRequest(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		util.validateResponse(rs, data.getExpectedStatus());

		util.validateResposneData(rs, data);

	}

	@Test(dataProvider = "jsondata", priority = 2)
	public void CreateUser(JsonData data) throws IOException {

//		String file = System.getProperty("user.dir") + "/src/test/resources/testdata/" + data.getBody();
//
//		File f = new File(file);
//		String reqbody = FileUtils.readFileToString(f, "UTF-8");
//
		AppUtil util = new AppUtil();
//
//		String value = "user1" + System.currentTimeMillis() + "@a.com";
//
//		String body = reqbody.replace("${email}", value);

		String value = "user1" + System.currentTimeMillis() + "@a.com";

		data.getDynamicdata().put("email", value);

		data.getResponseData().put("email", value);

		// data.getResponseData().put("email", value);

		Response rs = util.createRequest(data);

		// getExtentTest().info(" "+rs.jsonPath().getInt("id"));

		util.validateResponse(rs, data.getExpectedStatus());

		util.validateResposneData(rs, data);

		// wid = Integer.parseInt(rs.jsonPath().get("id"));

		id = rs.jsonPath().getInt("id");

		System.out.println(id);

	}

	@Test(dataProvider = "jsondata", priority = 3)
	public void UpdateUser(JsonData data) throws IOException {
//
//		String file = System.getProperty("user.dir") + "/src/test/resources/testdata/" + data.getBody();
//
//		File f = new File(file);
//		String reqbody = FileUtils.readFileToString(f, "UTF-8");

		AppUtil util = new AppUtil();

//		String value = "56W@gmail.com";
//
//		String body = reqbody.replace("${email}", value);
//
//		data.setBody(body);
//
//		// String value = "user1" + System.currentTimeMillis() + "@a.com";
//
//		data.setBody(body);
		
		data.getDynamicdata().put("email", "test@a.com");

		data.getResponseData().put("email", "test@a.com");

		data.getPathparam().put("userId", String.valueOf(id));

//		Map<String, String> newId = new HashMap<>();
//		newId.put("userId", String.valueOf(id));
//
//		data.setPathparam(newId);

		Response rs = util.createRequest(data);

		util.validateResponse(rs, data.getExpectedStatus());

		util.validateResposneData(rs, data);

	}

	@Test(dataProvider = "jsondata", priority = 4)
	public void DeleteUser(JsonData data) throws IOException {

		AppUtil util = new AppUtil();
		data.getPathparam().put("userId", String.valueOf(id));

		Response rs = util.createRequest(data);

		util.validateResponse(rs, data.getExpectedStatus());

	}

}
