package com.sanjeevaniehr.user.registration.services;

public class MedicalTestResults {

	// private String scan_upload_results ;

	private int uer_id;

	private String date_of_test;
	private String test_results;

	private String diagnostic_center_name;

	public void set_id(int uer_id) {
		this.uer_id = uer_id;
	}

	public double get_id() {
		return uer_id;
	}

	public void set_date_of_test(String date_of_test) {
		this.date_of_test = date_of_test;
	}

	public String get_date_of_test() {
		return date_of_test;
	}

	/*
	 * public void set_scan_upload_results(String scan_upload_results) {
	 * this.scan_upload_results = scan_upload_results; } public String
	 * get_scan_upload_results() { return scan_upload_results; }
	 */

	public void set_test_results(String test_results) {
		this.test_results = test_results;
	}

	public String get_test_results() {
		return test_results;
	}

	public void set_diagnostic_center_name(String diagnostic_center_name) {
		this.diagnostic_center_name = diagnostic_center_name;
	}

	public String get_diagnostic_center_name() {
		return diagnostic_center_name;
	}

}
