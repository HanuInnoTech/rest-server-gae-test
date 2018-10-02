package com.sanjeevaniehr.user.registration.services;

import java.util.HashSet;

public class User {

	private String user_type;
	private String user_firstname;
	private String user_lastname;
	private String user_pass;
	private String user_email;
	private String securityQuestion;
	private String securityAnswer;
	private String secondstrSecurityQuestion = null;
	private String secondstrSecurityAnswer = null;
	private String thirdstrSecurityQuestion = null;
	private String thirdstrSecurityAnswer = null;

	public String getSecondstrSecurityQuestion() {
		return secondstrSecurityQuestion;
	}

	public void setSecondstrSecurityQuestion(String secondstrSecurityQuestion) {
		this.secondstrSecurityQuestion = secondstrSecurityQuestion;
	}

	public String getSecondstrSecurityAnswer() {
		return secondstrSecurityAnswer;
	}

	public void setSecondstrSecurityAnswer(String secondstrSecurityAnswer) {
		this.secondstrSecurityAnswer = secondstrSecurityAnswer;
	}

	public String getThirdstrSecurityQuestion() {
		return thirdstrSecurityQuestion;
	}

	public void setThirdstrSecurityQuestion(String thirdstrSecurityQuestion) {
		this.thirdstrSecurityQuestion = thirdstrSecurityQuestion;
	}

	public String getThirdstrSecurityAnswer() {
		return thirdstrSecurityAnswer;
	}

	public void setThirdstrSecurityAnswer(String thirdstrSecurityAnswer) {
		this.thirdstrSecurityAnswer = thirdstrSecurityAnswer;
	}

	private HashSet<String> user_members;

	/*
	 * public void setuser_id(int user_id) { this.user_id = user_id; } public int
	 * getuser_id() { return user_id; }
	 */

	public void set_firstname(String firstName) {
		this.user_firstname = firstName;
	}

	public String get_firstname() {
		return user_firstname;
	}

	public void set_lastname(String lastName) {
		this.user_lastname = lastName;
	}

	public String get_lastname() {
		return user_lastname;
	}

	public void set_email(String email) {
		this.user_email = email;
	}

	public String get_email() {
		return user_email;
	}

	// public void setuser_type(String user_type) {
	// this.user_type = user_type;
	// }
	// public String getuser_type() {
	// return user_type;
	// }

	public void setuser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getuser_pass() {
		return user_pass;
	}

	public void set_securityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String get_securityQuestion() {
		return securityQuestion;
	}

	public void set_securityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String get_securityAnswer() {
		return securityAnswer;
	}

	public void setuer_members(HashSet<String> uer_members) {
		this.user_members = uer_members;
	}

	public HashSet<String> getuer_members() {
		return user_members;
	}

}
