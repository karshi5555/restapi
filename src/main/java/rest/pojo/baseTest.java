package rest.pojo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class baseTest {

	static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
	ExtentReports report = reportUtil.loadReport();

	@BeforeMethod
	public void startTest(Method name) {

		ExtentTest extentTest = report.createTest(name.getName(), name.getAnnotation(Test.class).description());
		extTest.set(extentTest);

	}

	public static ExtentTest getExtentTest() {

		return extTest.get();

	}

	@AfterMethod
	public void afterMethod() {

		extTest.remove();

	}

	@AfterSuite
	public void afterSuite() {

		report.flush();

	}

	@BeforeTest
	public void loadTestdata() throws EncryptedDocumentException, IOException {

		ExcelUtil.readExcel();

	}

	@DataProvider(name = "testdata")
	public static Object[][] getTestData(Method method) throws EncryptedDocumentException, IOException {

		TestData data = createTestData(ExcelUtil.getTestData(method.getName()));

		return new Object[][] { { data } };

	}

	@DataProvider(name = "jsondata")
	public static Object[][] Hello(Method methodname) throws EncryptedDocumentException, IOException {

		JsonData data = JsonUtil.getJsonData(methodname.getName());

		Object[][] obj = new Object[1][1];

		obj[0][0] = data;

		return obj;

	}

	public static TestData createTestData(Map<String, String> data) throws IOException {

		TestData testData = new TestData();

		testData.setBaseURI(data.get("baseUri"));

		testData.setHeaders(convertStringtoMap(data.get("headers")));

		testData.setQueryparam(convertStringtoMap(data.get("querparam")));

		testData.setContenttype(data.get("contenttype"));

		testData.setPathparam(convertStringtoMap(data.get("pathparam")));

		testData.setMethod(data.get("methodname"));

		testData.setResourcepath(data.get("resourcepath"));

		if (data.get("reqbody") != null && !data.get("reqbody").isEmpty()) {

			String file = System.getProperty("user.dir") + "/src/test/resources/testdata/" + data.get("reqbody");

			File f = new File(file);

			FileUtils.readFileToString(f, "UTF-8");

			String reqbody = FileUtils.readFileToString(f, "UTF-8");

			testData.setBody(reqbody);

		}

		testData.setStatuscode(Integer.parseInt(data.get("stauscode")));

		testData.setResposneData(convertStringtoMap(data.get("responsBody")));

		return testData;

	}

	public static Map<String, String> convertStringtoMap(String str) {

		HashMap<String, String> map = new HashMap<>();

		String[] pairs = str.split("&");

		for (String pair : pairs) {

			String[] keyValue = pair.split("=");
			if (keyValue.length == 2) {
				String key = keyValue[0].trim();
				String value = keyValue[1].trim();
				map.put(key, value);
			}
		}

		return map;

	}

}
