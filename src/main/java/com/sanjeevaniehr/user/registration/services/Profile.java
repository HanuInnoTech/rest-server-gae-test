package com.sanjeevaniehr.user.registration.services;

import java.util.HashSet;

public class Profile {

	private int uer_id;
	private double hight;
	private double weight;
	private String address;
	private String phone;
	private String emergency_contact;
	private String relationship;
	private String blood_type;
	private String gender;
	private String DateOfBirth;
	private String ethinicity;
	private String language;
	private String imagedocumentID;

	public String getImagedocumentID() {
		return imagedocumentID;
	}

	public void setImagedocumentID(String imagedocumentID) {
		this.imagedocumentID = imagedocumentID;
	}

	private HashSet<String> user_profile;

	public void set_hight(double hight) {
		this.hight = hight;
	}

	public double get_hight() {
		return hight;
	}

	public void set_id(int uer_id) {
		this.uer_id = uer_id;
	}

	public int get_id() {
		return uer_id;
	}

	public void set_weight(double weight) {
		this.weight = weight;
	}

	public double get_weight() {
		return weight;
	}

	public void set_phone(String phone) {
		this.phone = phone;
	}

	public String get_phone() {
		return phone;
	}

	public void set_emergency_contacte(String emergency_contact) {
		this.emergency_contact = emergency_contact;
	}

	public String get_emergency_contact() {
		return emergency_contact;
	}

	public void set_address(String address) {
		this.address = address;
	}

	public String get_address() {
		return address;
	}

	public void set_relationship(String relationship) {
		this.relationship = relationship;
	}

	public String get_relationship() {
		return relationship;
	}

	public void setblood_type(String blood_type) {
		this.blood_type = blood_type;
	}

	public String getblood_type() {
		return blood_type;
	}

	public void setethinicity(String ethinicity) {
		this.ethinicity = ethinicity;
	}

	public String getethinicity() {
		return ethinicity;
	}

	public void setlanguage(String language) {
		this.language = language;
	}

	public String getlanguage() {
		return language;
	}

	public void setgender(String gender) {
		this.gender = gender;
	}

	public String getgender() {
		return gender;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dob) {
		this.DateOfBirth = dob;
	}

	public void setuer_profile(HashSet<String> user_profile) {
		this.user_profile = user_profile;
	}

	public HashSet<String> getuer_members() {
		return user_profile;
	}

}
