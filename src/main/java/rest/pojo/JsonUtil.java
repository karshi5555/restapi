package rest.pojo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static Map<String, JsonData> jsonDataMap = new java.util.HashMap<>();

	static {

		try {
			loadJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void loadJson() throws StreamReadException, DatabindException, IOException {

		String fileName = System.getProperty("user.dir") + "/src/test/resources/testdata/jsondata/rakshitha.json";

		File file = new File(fileName);

		ObjectMapper mapper = new ObjectMapper();

		jsonDataMap = mapper.readValue(file,
				mapper.getTypeFactory().constructMapType(Map.class, String.class, JsonData.class));

	}

	public static JsonData getJsonData(String key) throws StreamReadException, DatabindException, IOException {

		return jsonDataMap.get(key);
	}

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		JsonData data = jsonDataMap.get("CreateUser");
		
		data.getHeaders().forEach((k,v)->System.out.println(k+" "+v));
		

	}

}
