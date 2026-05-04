package rest.pojo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;


@Data
public class JsonData {

	// give me setter and getter for all the variables in rakshitha.json file

	public String Description;
	public String BaseUri;
	public String Methodname;
	public String resourcepath;
	public int ExpectedStatus;
	public Map<String, String> pathparam = new HashMap<>();
	public Map<String, String> ResponseData = new HashMap<>();
	public String body;
	public Map<String, String> QueryParamter = new HashMap<>();
	public Map<String, String> Dynamicdata = new HashMap<>();
	public Map<String, String> Headers = new HashMap<>();
	public String ContentType;

	public String getContentType() {
		return ContentType;
	}

	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	public Map<String, String> getQueryParamter() {
		return QueryParamter;
	}

	public void setQueryParamter(Map<String, String> queryParamter) {
		QueryParamter = queryParamter;
	}

	public Map<String, String> getDynamicdata() {
		return Dynamicdata;
	}

	public void setDynamicdata(Map<String, String> dynamicdata) {
		Dynamicdata = dynamicdata;
	}

	public Map<String, String> getHeaders() {
		return Headers;
	}

	public void setHeaders(Map<String, String> headers) {
		Headers = headers;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getBaseUri() {
		return BaseUri;
	}

	public void setBaseUri(String baseUri) {
		BaseUri = baseUri;
	}

	public String getMethodname() {
		return Methodname;
	}

	public void setMethodname(String methodname) {
		Methodname = methodname;
	}

	public String getResourcepath() {
		return resourcepath;
	}

	public void setResourcepath(String resourcepath) {
		this.resourcepath = resourcepath;
	}

	public int getExpectedStatus() {
		return ExpectedStatus;
	}

	public void setExpectedStatus(int expectedStatus) {
		ExpectedStatus = expectedStatus;
	}

	public Map<String, String> getPathparam() {
		return pathparam;
	}

	public void setPathparam(Map<String, String> pathparam) {
		this.pathparam = pathparam;
	}

	public Map<String, String> getResponseData() {
		return ResponseData;
	}

	public void setResponseData(Map<String, String> responseData) {
		ResponseData = responseData;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
