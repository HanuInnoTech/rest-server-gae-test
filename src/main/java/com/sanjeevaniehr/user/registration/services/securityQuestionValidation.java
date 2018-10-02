package com.sanjeevaniehr.user.registration.services;

public class securityQuestionValidation {

	private String emailID = null;
	private String SecurityQuestion = null;
	private String SecurityQuestionAns = null;

	public String getEmailID() {
		return emailID;
	}

	public String getSecurityQuestion() {
		return SecurityQuestion;
	}

	public String getSecurityQuestionAns() {
		return SecurityQuestionAns;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public void setSecurityQuestion(String securityQuestion) {
		SecurityQuestion = securityQuestion;
	}

	public void setSecurityQuestionAns(String securityQuestionAns) {
		SecurityQuestionAns = securityQuestionAns;
	}

}
