package com.sanjeevaniehr.user.registration.services;

public class MedicalHistoryRecord {

	private int uer_id;

	private String doc_visit_date;

	private String doc_name;

	private boolean primary_doc;

	private String mode_of_visit;

	private String body_weight;
	private String body_weight_unit;

	private String blood_presure_systolic;
	private String blood_presure_diastolic;

	private String temperature;
	private String temperature_unit;

	private String prescribed_medicaltest_drugs;

	private String comments_from_doc;

	private int medicalhistoryIds;
	private String documentID;

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public void set_id(int uer_id) {
		this.uer_id = uer_id;
	}

	public int get_id() {
		return uer_id;
	}

	public void set_doc_visit_date(String doc_visit_date) {
		this.doc_visit_date = doc_visit_date;
	}

	public String get_doc_visit_date() {
		return doc_visit_date;
	}

	public void set_doc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String get_doc_name() {
		return doc_name;
	}

	public void set_primary_doc(boolean primary_doc) {
		this.primary_doc = primary_doc;
	}

	public boolean get_primary_doc() {
		return primary_doc;
	}

	public void set_mode_of_visit(String mode_of_visit) {
		this.mode_of_visit = mode_of_visit;
	}

	public String get_mode_of_visit() {
		return mode_of_visit;
	}

	public void set_comments_from_doc(String comments_from_doc) {
		this.comments_from_doc = comments_from_doc;
	}

	public String get_comments_from_doc() {
		return comments_from_doc;
	}

	public void setprescribed_medicaltest_drugs(String prescribed_medicaltest_drugs) {
		this.prescribed_medicaltest_drugs = prescribed_medicaltest_drugs;
	}

	public String get_prescribed_medicaltest_drugs() {
		return prescribed_medicaltest_drugs;
	}

	public void set_blood_presure_systolic(String blood_presure_sys) {
		this.blood_presure_systolic = blood_presure_sys;
	}

	public String get_blood_presure_systolic() {
		return blood_presure_systolic;
	}

	public void set_blood_presure_diatolic(String blood_presure_sys) {
		this.blood_presure_diastolic = blood_presure_sys;
	}

	public String get_blood_presure_diastolic() {
		return blood_presure_diastolic;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getBody_weight() {
		return body_weight;
	}

	public void setBody_weight(String body_weight) {
		this.body_weight = body_weight;
	}

	public String getBody_weight_unit() {
		return body_weight_unit;
	}

	public void setBody_weight_unit(String body_weight_unit) {
		this.body_weight_unit = body_weight_unit;
	}

	public String getTemperature_unit() {
		return temperature_unit;
	}

	public void setTemperature_unit(String temperature_unit) {
		this.temperature_unit = temperature_unit;
	}

	public int getMedicalhistoryIds() {
		return medicalhistoryIds;
	}

	public void setMedicalhistoryIds(int medicalhistoryIds) {
		this.medicalhistoryIds = medicalhistoryIds;
	}

}
