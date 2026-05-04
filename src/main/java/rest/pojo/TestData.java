package rest.pojo;

import java.util.HashMap;
import java.util.Map;

public class TestData {
	
	public String BaseURI;
	public Map<String, String> headers = new HashMap<>();
	public String body;
	public Map<String, String>  pathparam = new HashMap<>();
	public Map<String, String>  queryparam = new HashMap<>();
	public String method;
	public String contenttype;
	
	public Map<String, String> resposneData = new HashMap<>();
	
	
	public Map<String, String> getResposneData() {
		return resposneData;
	}

	public void setResposneData(Map<String, String> resposneData) {
		this.resposneData = resposneData;
	}

	public String getContenttype() {
		return contenttype;
	}

	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}

	public String resourcepath;

	public int statuscode;

	public String getBaseURI() {
		return BaseURI;
	}

	public void setBaseURI(String baseURI) {
		BaseURI = baseURI;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Map<String, String> getPathparam() {
		return pathparam;
	}

	public void setPathparam(Map<String, String> pathparam) {
		this.pathparam = pathparam;
	}

	public Map<String, String> getQueryparam() {
		return queryparam;
	}

	public void setQueryparam(Map<String, String> queryparam) {
		this.queryparam = queryparam;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getResourcepath() {
		return resourcepath;
	}

	public void setResourcepath(String resourcepath) {
		this.resourcepath = resourcepath;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}


	
	

}
