package com.example.demo.response;

public class Responsebean {

	private String responseCode;
	private String responseMsg;
	
	
	public Responsebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Responsebean(String responseCode, String responseMsg) {
		super();
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	
	
}
