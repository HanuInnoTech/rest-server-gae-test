package com.sanjeevaniehr.user.registration.services;

public class VaccinationImmunizationRecord {

	private String VaccinationImmunization_date;

	private String VaccinationImmunization_name;
	private String VaccinationImmunization_type;
	private String VaccinationImmunization_dose_qantity;
	private int uer_id;
	private String VaccinationImmunization_recordLocation;

	private int VaccinationImmunizationIds;

	public String getVaccinationImmunization_recordLocation() {
		return VaccinationImmunization_recordLocation;
	}

	public void setVaccinationImmunization_recordLocation(String vaccinationImmunization_recordLocation) {
		VaccinationImmunization_recordLocation = vaccinationImmunization_recordLocation;
	}

	public void set_id(int uer_id) {
		this.uer_id = uer_id;
	}

	public double get_id() {
		return uer_id;
	}

	public void set_VaccinationImmunization_date(String VaccinationImmunization_date) {
		this.VaccinationImmunization_date = VaccinationImmunization_date;
	}

	public String get_VaccinationImmunization_date() {
		return VaccinationImmunization_date;
	}

	public void set_VaccinationImmunization_name(String VaccinationImmunization_name) {
		this.VaccinationImmunization_name = VaccinationImmunization_name;
	}

	public String get_VaccinationImmunization_name() {
		return VaccinationImmunization_name;
	}

	public void set_VaccinationImmunization_type(String VaccinationImmunization_type) {
		this.VaccinationImmunization_type = VaccinationImmunization_type;
	}

	public String get_VaccinationImmunization_type() {
		return VaccinationImmunization_type;
	}

	public void set_VaccinationImmunization_dose_qantity(String VaccinationImmunization_dose_qantity) {
		this.VaccinationImmunization_dose_qantity = VaccinationImmunization_dose_qantity;
	}

	public String get_VaccinationImmunization_dose_qantity() {
		return VaccinationImmunization_dose_qantity;
	}

	public int getVaccinationImmunizationIds() {
		return VaccinationImmunizationIds;
	}

	public void setVaccinationImmunizationIds(int vaccinationImmunizationIds) {
		VaccinationImmunizationIds = vaccinationImmunizationIds;
	}

}
