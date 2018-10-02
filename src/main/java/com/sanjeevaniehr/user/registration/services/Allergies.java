package com.sanjeevaniehr.user.registration.services;

public class Allergies {

	private String allergy_name;
	private String reaction;
	private String severity;
	private String allergy_date;
	private int uer_id;
	private int allergy_id;

	public void set_id(int uer_id) {
		this.uer_id = uer_id;
	}

	public double get_id() {
		return uer_id;
	}

	public void set_allergy_date(String allergy_date) {
		this.allergy_date = allergy_date;
	}

	public String get_allergy_date() {
		return allergy_date;
	}

	public int getAllergy_id() {
		return allergy_id;
	}

	public void setAllergy_id(int allergy_id) {
		this.allergy_id = allergy_id;
	}

	public void set_allergy_name(String allergy_name) {
		this.allergy_name = allergy_name;
	}

	public String get_allergy_name() {
		return allergy_name;
	}

	public void set_reaction(String reaction) {
		this.reaction = reaction;
	}

	public String get_reaction() {
		return reaction;
	}

	public void set_severity(String severity) {
		this.severity = severity;
	}

	public String get_severity() {
		return severity;
	}

}
