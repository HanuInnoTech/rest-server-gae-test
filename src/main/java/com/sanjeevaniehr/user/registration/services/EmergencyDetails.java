package com.sanjeevaniehr.user.registration.services;

public class EmergencyDetails {

	private String EmergencyContactName;

	private String EmergencyContactNumber;
	private String Allergies;
	private String Medication;
	private int uer_id;
	private String Relationship;
	private String Blood_group;

	public String getEmergencyContactName() {
		return EmergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		EmergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactNumber() {
		return EmergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		EmergencyContactNumber = emergencyContactNumber;
	}

	public String getAllergies() {
		return Allergies;
	}

	public void setAllergies(String allergies) {
		Allergies = allergies;
	}

	public String getMedication() {
		return Medication;
	}

	public void setMedication(String medication) {
		Medication = medication;
	}

	public int getUer_id() {
		return uer_id;
	}

	public void setUer_id(int uer_id) {
		this.uer_id = uer_id;
	}

	public String getRelationship() {
		return Relationship;
	}

	public void setRelationship(String relationship) {
		Relationship = relationship;
	}

	public String getBlood_group() {
		return Blood_group;
	}

	public void setBlood_group(String blood_group) {
		Blood_group = blood_group;
	}

}
