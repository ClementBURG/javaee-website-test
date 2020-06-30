package com.octest.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
	private String result;

	public void checkLoginCredentials(HttpServletRequest request) {
		String login = request.getParameter("login"); // "login" come form name attribute in the input html tag
		String pass = request.getParameter("pass");
		
		if (pass.equals(login + "123")) {
			this.result = "Vous êtes bien connecté !";
		} else {
			this.result = "Identifiants incorrects !";
		}
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}	
}
