package com.sanjeevaniehr.user.registration.services;

public class Medications {

	private int uer_id;
	private String date_of_medication;
	private String type_of_medication;
	private String name_of_mediaction;

	private String instructions;
	private String dose_qantity;
	private String rate_quantity;
	private String prescriber_name;

	private int medication_id;

	// private String scan_upload_prescription ;

	public void set_id(int uer_id) {
		this.uer_id = uer_id;
	}

	public double get_id() {
		return uer_id;
	}

	public void set_date_of_medication(String date_of_medication2) {
		this.date_of_medication = date_of_medication2;
	}

	public String get_date_of_medication() {
		return date_of_medication;
	}

	public void set_type_of_medication(String type_of_medication) {
		this.type_of_medication = type_of_medication;
	}

	public String get_type_of_medication() {
		return type_of_medication;
	}

	/*
	 * public void set_scan_upload_prescription(String scan_upload_prescription) {
	 * this.scan_upload_prescription = scan_upload_prescription; } public String
	 * get_scan_upload_prescription() { return scan_upload_prescription; }
	 */

	public void set_name_of_mediaction(String name_of_mediaction) {
		this.name_of_mediaction = name_of_mediaction;
	}

	public String get_name_of_mediaction() {
		return name_of_mediaction;
	}

	public void set_instructions(String instructions) {
		this.instructions = instructions;
	}

	public String get_instructions() {
		return instructions;
	}

	public void set_prescriber_name(String prescriber_name) {
		this.prescriber_name = prescriber_name;
	}

	public String get_prescriber_name() {
		return prescriber_name;
	}

	public void set_rate_quantity(String rate_quantity) {
		this.rate_quantity = rate_quantity;
	}

	public String get_rate_quantity() {
		return rate_quantity;
	}

	public void set_dose_qantity(String dose_qantity) {
		this.dose_qantity = dose_qantity;
	}

	public String get_dose_qantity() {
		return dose_qantity;
	}

	public int getMedication_id() {
		return medication_id;
	}

	public void setMedication_id(int medication_id) {
		this.medication_id = medication_id;
	}

}
