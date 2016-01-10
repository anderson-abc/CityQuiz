package com.irmasoft.city;

public class Question {
	private String text;
	private String response;
	
	
	
	public Question(String text, String response) {
		this.text = text;
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public String getText() {
		return text;
	}
}
