package com.sanjeevaniehr.user.registration.services;

public class MedicalContacts {
	// data.MedicalcontactName = $scope.Medical_contactName;
	// data.Medical_email = $scope.Medical_email;
	// data.Medical_Address = $scope.Medical_Address;
	// data.Medical_Hospital_Details = $scope.Medical_Hospital_Details;
	// data.MedicalcontactNumber = $scope.Medical_contactNumber;
	// Database storage = new Database();
	private int uer_ID;

	public int getUer_ID() {
		return uer_ID;
	}

	public void setUer_ID(int uer_ID) {
		this.uer_ID = uer_ID;
	}

	private String Medical_contactName;
	private String Medical_email;
	private String Medical_Hospital_Details;
	private String Medical_Address;
	private String Medical_contactNumber;

	public String getMedical_contactName() {
		return Medical_contactName;
	}

	public void setMedical_contactName(String medical_contactName) {
		Medical_contactName = medical_contactName;
	}

	public String getMedical_email() {
		return Medical_email;
	}

	public void setMedical_email(String medical_email) {
		Medical_email = medical_email;
	}

	public String getMedical_Hospital_Details() {
		return Medical_Hospital_Details;
	}

	public void setMedical_Hospital_Details(String medical_Hospital_Details) {
		Medical_Hospital_Details = medical_Hospital_Details;
	}

	public String getMedical_Address() {
		return Medical_Address;
	}

	public void setMedical_Address(String medical_Address) {
		Medical_Address = medical_Address;
	}

	public String getMedical_contactNumber() {
		return Medical_contactNumber;
	}

	public void setMedical_contactNumber(String medical_contactNumber) {
		Medical_contactNumber = medical_contactNumber;
	}

}
