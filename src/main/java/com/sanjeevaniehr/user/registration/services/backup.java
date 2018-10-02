package com.sanjeevaniehr.user.registration.services;

// package com.sanjeevaniehr.user.registration.services;
//
// import java.io.File;
// import java.io.InputStream;
// import java.text.DateFormat;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;
//
// import javax.ws.rs.core.Response;
// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.parsers.ParserConfigurationException;
// import javax.xml.transform.Transformer;
// import javax.xml.transform.TransformerException;
// import javax.xml.transform.TransformerFactory;
// import javax.xml.transform.dom.DOMSource;
// import javax.xml.transform.stream.StreamResult;
//
// import org.json.JSONArray;
// import org.json.JSONException;
// import org.json.JSONObject;
// import org.w3c.dom.Document;
// import org.w3c.dom.Element;
// import org.w3c.dom.ls.DOMImplementationLS;
// import org.w3c.dom.ls.LSSerializer;
//
//
//// import exception.NotFoundException;
//
// public class SanveevaniServicesImpl implements SanveevaniServicesIn {
//
//
// public SanveevaniServicesImpl() {
//
// }
// @Override
// public JSONObject Register(String jsonString) throws InstantiationException,
// IllegalAccessException
// {
//
// System.out.println("************** adduser **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
// String usertype = null;
// String userlastname = null;
// String userfirstname = null;
// String userpass = null;
// String useremail=null;
// String strActivationLinkCode=null;
// String returnCode = "SUCCESS";
// String strEMRN=null;
// String strSecurityQuestion=null;
// String strSecurityAnswer=null;
//
// returnJson = new JSONObject();
//
//
//
// try {
// JSONObject json = new JSONObject(jsonString);
// // JSON Signature
// // firstname,lastname,usertype,userpass,useremail
//
//
// // Parse All JSON Components - make sure name matches
// usertype = json.getString("usertype");
// userfirstname = json.getString("firstname");
// userlastname = json.getString("lastname");
// userpass = json.getString("userpass");
// useremail = json.getString("useremail");
// strSecurityQuestion = json.getString("securityQuestion");
// strSecurityAnswer = json.getString("securityAnswer");
//
// System.out.println("*** usertype=" + usertype);
// System.out.println("*** userfirstname=" + userfirstname);
// System.out.println("*** userlastname=" + userlastname);
// System.out.println("*** userpass=" + userpass);
// System.out.println("*** useremail=" + useremail);
// System.out.println("*** SecurityQuestion=" + strSecurityQuestion);
// System.out.println("*** SecurityAnswer=" + strSecurityAnswer);
//
// // Create User Object and Store it in the Database
// User users = new User() ;
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// //Database storage = new Database();
// users.setuser_type(usertype);
// users.set_firstname(userfirstname);
// users.set_lastname(userlastname);
// users.setuser_pass(userpass);
// users.set_email(useremail);
// users.set_securityQuestion(strSecurityQuestion);
// users.set_securityAnswer(strSecurityAnswer);
// // add it to the database
// returnCode = storage.addUser(users);
//
// if(returnCode.compareToIgnoreCase("success") == 0)
// {
// // we have successfully created registration account.
// // Now get ActivationLinkCode
//
// System.out.println("****** Before Activation Code");
//
// JSONObject activationLinkCodeJSON = storage.createActivationsRecord(users);
//
//
// String returnActivationCode = (String)
// activationLinkCodeJSON.get("returnStr");
// System.out.println("returnActivationCode= " + returnActivationCode);
// if(returnActivationCode.compareToIgnoreCase("success") == 0)
// {
// strActivationLinkCode = (String) activationLinkCodeJSON.get("ActivationKey");
// strEMRN = (String) activationLinkCodeJSON.get("EMRN");
// returnJson.put("Email", (String) activationLinkCodeJSON.get("Email"));
// returnJson.put("FName", (String) activationLinkCodeJSON.get("FName"));
// returnJson.put("LName", (String) activationLinkCodeJSON.get("LName"));
// }
//
//
// }
// System.out.println("DONE - returnCode" + returnCode);
//
// returnJson.put("returnCode", returnCode);
// System.out.println("DONE - ActivationLinkCode" + strActivationLinkCode);
// returnJson.put("ActivationLinkCode", strActivationLinkCode);
// returnJson.put("EMRN", strEMRN);
//
//
// System.out.println("DONE");
//
//
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
//
//
// }
//
//
// return returnJson;
// }
//
//
// @Override
// public JSONObject Login(String jsonString) throws InstantiationException,
// IllegalAccessException {
//
// String username = null;
// String userpass = null;
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
//
// try {
//
// System.out.println("************** Login **********************");
// System.out.println(jsonString);
//
// JSONObject json = new JSONObject(jsonString);
//
//
// username = json.getString("username");
// userpass = json.getString("userpass");
//
// System.out.println("Username=" + username);
// System.out.println("Passwor=" + userpass);
//
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
//
// returnCode = storage.login(username, userpass) ;
//
// System.out.println("DONE - returnCode" + returnCode);
//
// //returnJson.put("returnCode", returnCode);
//
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
//
// }
//
//
// return returnCode;
// }
//
//
// @Override
// public JSONObject CreateProfile(String jsonString) throws
// InstantiationException, IllegalAccessException, ParseException, JSONException
// {
//
// System.out.println("************** profile **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
//
//
// double height = 0.0;
// double weight = 0.0;
// String address = null;
// String phone = null;
// String sessionToken=null;
// int id = 0;
// String emergency_contact = null;
// String relationship = null;
// String blood_type = null;
// String gender = null; ;
// String ethinicity = null;
// String language = null;
// String returnCode = "SUCCESS";
// boolean strFirstTimeProfileUpdate = false;
// returnJson = new JSONObject();
// //Date Birthday_date = new Date();
// String dob=null;
// try {
// // Create profile Object and Store it in the Database
// Profile profile = new Profile() ;
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
//
// System.out.println("jsonString=" + jsonString);
// JSONObject json = new JSONObject(jsonString);
// sessionToken = json.getString("sessionToken");
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnJson;
// }
// // Session is active - get Patient Medical Record Number, now..
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnJson;
// }
//
// id = Integer.parseInt(User_ID);
// height = json.getDouble("height");
// weight = json.getDouble("weight");
// address = json.getString("address");
// phone = json.getString("phone");
//
// strFirstTimeProfileUpdate = storage.checkProfileStatus(id);
// System.out.println(strFirstTimeProfileUpdate);
// emergency_contact = json.getString("emergency_contact");
// relationship = json.getString("relationship");
// blood_type = json.getString("blood_type");
// gender = json.getString("gender");
// System.out.println("************ got all json objects ********");
//
// // Birthday_date = convertInJavaDate(json.getString("bdate"));
// dob = json.getString("bdate");
// System.out.println("************ Done conversion date ********");
// ethinicity = json.getString("ethinicity");
// language = json.getString("language");
//
// System.out.println("*** hight=" + height);
// System.out.println("*** weight=" + weight);
// System.out.println("*** Birthday_date=" + dob);
// System.out.println("*** emergency_contact=" + emergency_contact);
// System.out.println("*** relationship=" + relationship);
// profile.set_address(address) ;
// profile.set_emergency_contacte(emergency_contact) ;
// profile.set_hight(height) ;
// profile.set_weight(weight);
// profile.set_relationship(relationship);
// profile.setDateOfBirth(dob) ;
// profile.setblood_type(blood_type) ;
// profile.setethinicity(ethinicity) ;
// profile.setgender(gender) ;
// profile.setlanguage(language) ;
// profile.set_phone(phone) ;
// profile.set_id(id) ;
//
// if(!strFirstTimeProfileUpdate)
// returnCode = storage.CreateProfile(profile);
// else
// returnCode = storage.UpdateProfile(profile);
//
//
// System.out.println("DONE - returnCode" + returnCode);
//
// returnJson.put("ForceLogOn", "false");
// returnJson.put("returnCode", returnCode);
//
// System.out.println("DONE");
//
//
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
// }
//
//
// return returnJson;
// }
//
//
//
// @Override
// public JSONObject ActivateAccount(String jsonString) throws
// InstantiationException, IllegalAccessException, ParseException, JSONException
// {
//
// System.out.println("************** ActivateAccount **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
// String strActivationCode=null;
//
// try {
// // Very straight function
// // user clicks activation link and
// // activates
//
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// System.out.println("jsonString=" + jsonString);
// JSONObject json = new JSONObject(jsonString);
//
// strActivationCode = json.getString("activation_code");
// System.out.println("strActivationCode=" + strActivationCode);
//
// JSONObject activateJSON = storage.activateUserAccount(strActivationCode);
//
// String returnActivationCode = (String) activateJSON.get("returnCode");
// System.out.println("returnActivationCode= " + returnActivationCode);
// if(returnActivationCode.compareToIgnoreCase("success") == 0)
// {
// returnJson.put("sessionToken", (String) activateJSON.get("sessionToken"));
// }
// returnJson.put("returnCode", returnCode);
// System.out.println("DONE");
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
// }
//
//
// return returnJson;
// }
//
//
//
// //Method to check validity of date
// private Date convertInJavaDate(String d) throws ParseException {
//
// DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
// Date date = formatter.parse(d);
// System.out.println("************ Done convertInJavaDate ********");
// return date;
// }
//
//
//
//
//
//
// @Override
// public JSONObject CreateMedicalHistory(String jsonString) throws
// InstantiationException, IllegalAccessException, ParseException,JSONException
// {
//
// System.out.println("************** MedicalHistory **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
// int id = 0;
// String doc_name = null;
// boolean primary_doc = null != null ;
// String mode_of_visit = null;
// String body_weight = null;
// String blood_presure_systolic = null;
// String blood_presure_diastolic = null;
// String temperature = null;
// String prescribed_medicaltest_drugs = null;
// String comments_from_doc = null;
// String doc_visit_date = null;
// String sessionToken= null;
// try
// {
//
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// JSONObject json = new JSONObject(jsonString);
// System.out.println("jsonString=" + jsonString);
// sessionToken = json.getString("sessionToken");
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnJson;
// }
// // Session is active - get Patient Medical Record Number, now..
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnJson;
// }
//
// id = Integer.parseInt(User_ID);
// doc_visit_date = json.getString("doc_visit_date");
// doc_name = json.getString("doc_name");
// primary_doc = json.optBoolean("primary_doc") ;
// mode_of_visit = json.getString("mode_of_visit");
// body_weight = json.getString("body_weight");
// blood_presure_systolic = json.getString("blood_presure_systolic");
// blood_presure_diastolic = json.getString("blood_presure_diastolic");
// temperature = json.getString("temperature");
// prescribed_medicaltest_drugs =
// json.getString("prescribed_medicaltest_drugs");
// comments_from_doc = json.getString("comments_from_doc");
// System.out.println("*** EMRN=" + id);
// System.out.println("*** doc_visit_date=" + doc_visit_date);
// System.out.println("*** doc_name=" + doc_name);
// System.out.println("*** primary_doc=" + primary_doc);
// System.out.println("*** mode_of_visit=" + mode_of_visit);
//
// // Create profile Object and Store it in the Database
// MedicalHistoryRecord MHrecord = new MedicalHistoryRecord() ;
//
// //Database storage = new Database();
//
// MHrecord.set_id(id) ;
// MHrecord.set_blood_presure_systolic(blood_presure_systolic);
// MHrecord.set_blood_presure_diatolic(blood_presure_diastolic);
// MHrecord.set_body_weight(body_weight) ;
// MHrecord.set_doc_name(doc_name) ;
// MHrecord.set_doc_visit_date(doc_visit_date) ;
// MHrecord.set_mode_of_visit(mode_of_visit) ;
// MHrecord.set_temperature(temperature) ;
// MHrecord.setprescribed_medicaltest_drugs(prescribed_medicaltest_drugs) ;
// MHrecord.set_comments_from_doc(comments_from_doc) ;
// MHrecord.set_primary_doc(primary_doc) ;
//
//
// returnCode = storage.CreateMedicalHistory(MHrecord);
//
// System.out.println("DONE - returnCode" + returnCode);
//
// returnJson.put("ForceLogOn", "false");
// returnJson.put("returnCode", returnCode);
//
// System.out.println("DONE");
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
// }
//
//
// return returnJson;
// }
//
// /* To delete Medical History Record Ids
// * (non-Javadoc)
// * @see
// com.sanjeevaniehr.user.registration.services.SanveevaniServicesIn#deletemedicalhistory(java.lang.String)
// */
// public JSONObject deletemedicalhistory(String jsonString) throws
// InstantiationException, IllegalAccessException, ParseException,JSONException
// {
//
//
// System.out.println("************** deletemedicalhistory
// **********************");
// JSONObject returnJson = null;
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
// String medicalhistoryId=null;
// String sessionToken=null;
// try
// {
// JSONObject json = new JSONObject(jsonString);
// System.out.println("jsonString=" + jsonString);
// sessionToken = json.getString("sessionToken");
// medicalhistoryId = json.getString("medicalhistoryId");
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnJson;
// }
// // Session is active - get Patient Medical Record Number, now..
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnJson;
// }
//
// int medicalId = Integer.parseInt(medicalhistoryId);
//
// boolean result = storage.deleteMedicalHistoryRecord(medicalId);
//
// if(result)
// {
// System.out.print("MedicalhistoryRecord deleted successfully");
// returnJson.put("returnCode", returnCode);
// }
// else
// {
// returnJson.put("returnCode", "Unable to delete the record");
// }
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
// }
// return returnJson;
// }
//
// @Override
// public JSONObject CreateMedication(String jsonString) throws
// InstantiationException, IllegalAccessException, ParseException,JSONException
// {
//
// System.out.println("**************Medication **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
// String date_of_medication = null;
// String type_of_medication = null;
// String name_of_mediaction = null;
// String instructions = null;
// String dose_qantity = null;
// String rate_quantity = null;
// String prescriber_name = null;
// String sessionToken=null;
// int id = 0;
// try
// {
// JSONObject json = new JSONObject(jsonString);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// System.out.println("jsonString=" + jsonString);
// sessionToken = json.getString("sessionToken");
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnJson;
// }
// // Session is active - get Patient Medical Record Number, now..
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnJson;
// }
// id = Integer.parseInt(User_ID);
// date_of_medication = json.getString("date_of_medication");
// type_of_medication = json.getString("type_of_medication") ;
// name_of_mediaction = json.getString("name_of_mediaction");
// instructions = json.getString("instructions") ;
// dose_qantity = json.getString("dose_qantity");
// rate_quantity = json.getString("rate_quantity");
// prescriber_name= json.getString("prescriber_name");
// System.out.println("*** EMRN=" + id);
// System.out.println("*** date_of_medication=" + date_of_medication);
// System.out.println("*** name_of_mediaction=" + name_of_mediaction);
// System.out.println("*** instructions=" + instructions);
// System.out.println("*** dose_qantity=" + dose_qantity);
// // Create profile Object and Store it in the Database
// Medications medications = new Medications() ;
// //Database storage = new Database();
// medications.set_id(id) ;
// medications.set_name_of_mediaction(name_of_mediaction);
// medications.set_instructions(instructions) ;
// medications.set_type_of_medication(type_of_medication) ;
// medications.set_dose_qantity(dose_qantity) ;
// medications.set_date_of_medication(date_of_medication) ;
// medications.set_rate_quantity(rate_quantity) ;
// medications.set_prescriber_name(prescriber_name) ;
// returnCode = storage.CreateMedications(medications);
// System.out.println("DONE - returnCode" + returnCode);
// returnJson.put("ForceLogOn", "false");
// returnJson.put("returnCode", returnCode);
// System.out.println("DONE");
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
// }
//
//
// return returnJson;
// }
//
//
//
//
// @Override
// public JSONObject CreateMedicalResult(String jsonString) throws
// InstantiationException, IllegalAccessException, ParseException {
//
// System.out.println("************** MedicalResult **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
// int id = 0;
// String date_of_test = null;
// String test_results = null;
// String diagnostic_center_name = null;
// String sessionToken=null;
// try
// {
// JSONObject json = new JSONObject(jsonString);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// System.out.println("jsonString=" + jsonString);
// sessionToken = json.getString("sessionToken");
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnJson;
// }
// // Session is active - get Patient Medical Record Number, now..
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnJson;
// }
// id = Integer.parseInt(User_ID);
// date_of_test = json.getString("date_of_test");
// test_results = json.getString("test_results");
// diagnostic_center_name = json.getString("diagnostic_center_name") ;
// System.out.println("*** EMRN=" + id);
// System.out.println("*** date_of_test=" + date_of_test);
// System.out.println("*** test_results=" + test_results);
// System.out.println("*** diagnostic_center_name=" + diagnostic_center_name);
// // Create profile Object and Store it in the Database
// MedicalTestResults testresult = new MedicalTestResults() ;
// testresult.set_id(id) ;
// testresult.set_date_of_test(date_of_test);
// testresult.set_test_results(test_results) ;
// testresult.set_diagnostic_center_name(diagnostic_center_name) ;
// returnCode = storage.CreateMedicalTestResults(testresult);
// System.out.println("DONE - returnCode" + returnCode);
// returnJson.put("ForceLogOn", "false");
// returnJson.put("returnCode", returnCode);
// System.out.println("DONE");
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// }
// return returnJson;
// }
// @Override
// public JSONObject CreateEmergencyDetailsRecord(String jsonString)
// throws InstantiationException, IllegalAccessException,
// ParseException, JSONException {
// System.out.println("************** Emmergency Details
// **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
// int id = 0;
// String EmergencyContactName = null;
// String EmergencyContactNumber = null;
// String Allergies = null;
// String Medication = null;
// String Blood_group =null;
// String Relationship =null;
// String sessionToken=null;
// try {
// JSONObject json = new JSONObject(jsonString);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// System.out.println("jsonString=" + jsonString);
// sessionToken = json.getString("sessionToken");
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnJson;
// }
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnJson;
// }
// id = Integer.parseInt(User_ID);
//
// EmergencyContactName = json.getString("contactName");
// EmergencyContactNumber = json.getString("contactNumber");
// Allergies = json.getString("allergyName");
// Medication = json.getString("Medications");
// Blood_group = json.getString("Blood_group");
// Relationship = json.getString("relationship");
// System.out.println(Medication);
// EmergencyDetails result = new EmergencyDetails() ;
// result.setUer_id(id);
// result.setAllergies(Allergies);
// result.setBlood_group(Blood_group);
// result.setEmergencyContactName(EmergencyContactName);
// result.setEmergencyContactNumber(EmergencyContactNumber);
// result.setMedication(Medication);
// result.setRelationship(Relationship);
// System.out.println(result.getMedication());
// returnCode = storage.CreateEmergencyRecords(result);
// }
// catch(Exception e)
// {
//
// }
// return returnJson;
// }
//
//
// @Override
// public Response CreateVaccinationImmunization(String jsonString) throws
// InstantiationException, IllegalAccessException, ParseException, JSONException
// {
//
// System.out.println("************** VaccinationImmunization
// **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
// int id = 0;
// String VaccinationImmunization_date = null;
// String VaccinationImmunization_name = null;
// String VaccinationImmunization_type = null;
// String VaccinationImmunization_dose_qantity = null;
// String sessionToken=null;
// String VaccinationImmunization_recordLocation = null;
// try {
// JSONObject json = new JSONObject(jsonString);
//
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// System.out.println("jsonString=" + jsonString);
// sessionToken = json.getString("sessionToken");
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return Response.status(404).entity(returnJson).build();
// }
// // Session is active - get Patient Medical Record Number, now..
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return Response.status(404).entity(returnJson).build();
// }
// id = Integer.parseInt(User_ID);
//
//
// VaccinationImmunization_date =
// json.getString("VaccinationImmunization_date");
// VaccinationImmunization_type =
// json.getString("VaccinationImmunization_type");
// VaccinationImmunization_dose_qantity =
// json.getString("VaccinationImmunization_dose_quantity");
// VaccinationImmunization_name = json.getString("VaccinationImmunization_name")
// ;
// VaccinationImmunization_recordLocation =
// json.getString("VaccinationImmunization_recordLocation");
//
// System.out.println("*** EMRN=" + id);
// System.out.println("*** VaccinationImmunization_date =" +
// VaccinationImmunization_date );
// System.out.println("*** VaccinationImmunization_type=" +
// VaccinationImmunization_type);
// System.out.println("*** VaccinationImmunization_dose_qantity=" +
// VaccinationImmunization_dose_qantity);
// System.out.println("*** VaccinationImmunization_recordLocation=" +
// VaccinationImmunization_recordLocation);
//
//
// // Create profile Object and Store it in the Database
// VaccinationImmunizationRecord result = new VaccinationImmunizationRecord() ;
//
// result.set_id(id) ;
// result.set_VaccinationImmunization_date(VaccinationImmunization_date);
// result.set_VaccinationImmunization_name(VaccinationImmunization_name);
// result.set_VaccinationImmunization_type(VaccinationImmunization_type) ;
// result.set_VaccinationImmunization_dose_qantity(VaccinationImmunization_dose_qantity)
// ;
// result.setVaccinationImmunization_recordLocation(VaccinationImmunization_recordLocation);
//
// returnCode = storage.CreateVaccinationImmunization(result);
//
// System.out.println("DONE - returnCode" + returnCode);
//
// returnJson.put("ForceLogOn", "false");
// returnJson.put("returnCode", returnCode);
//
// System.out.println("DONE");
//
//
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
// }
//
// return Response.status(201).entity(returnJson).build();
// }
//
//
//
// @Override
// public JSONObject Createallergy(String jsonString) throws
// InstantiationException, IllegalAccessException,JSONException {
//
// System.out.println("************** allergy **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
//
//
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
//
//
// int id = 0;
// String sessionToken=null;
// String allergy_name = null;
// String reaction = null;
// String severity = null;
// String allergy_date = null;
//
//
//
// try {
// JSONObject json = new JSONObject(jsonString);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// System.out.println("jsonString=" + jsonString);
// sessionToken = json.getString("sessionToken");
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnJson;
// }
// // Session is active - get Patient Medical Record Number, now..
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnJson;
// }
// id = Integer.parseInt(User_ID);
// allergy_date = json.getString("allergy_date") ;
// allergy_name = json.getString("allergy_name");
// reaction = json.getString("reaction") ;
// severity = json.getString("severity") ;
// System.out.println("*** EMRN=" + id);
// System.out.println("*** allergy_name =" + allergy_name );
// System.out.println("*** reaction=" + reaction);
// System.out.println("*** severity=" + severity);
//
// // Create profile Object and Store it in the Database
// Allergies allergy = new Allergies() ;
//
// allergy.set_id(id) ;
// allergy.set_allergy_date(allergy_date);
// allergy.set_allergy_name(allergy_name) ;
// allergy.set_reaction(reaction) ;
// allergy.set_severity(severity) ;
// returnCode = storage.CreateAllergies(allergy);
// System.out.println("DONE - returnCode" + returnCode);
// returnJson.put("ForceLogOn", "false");
// returnJson.put("returnCode", returnCode);
// System.out.println("DONE");
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
// }
//
// return returnJson;
// }
//
//
//
//
// @Override
// public JSONObject GetMedicalhistoryById(String jsonString) throws
// InstantiationException, IllegalAccessException {
//
// int id = 0;
//
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
// System.out.println("************** GetMedicalhistoryById
// **********************");
// System.out.println(jsonString);
// String sessionToken = jsonString;
//
// try {
//
//
// //JSONObject json = new JSONObject(jsonString);
//
// System.out.println("sessionToken=" + sessionToken);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnCode;
// }
// // Session is active - get Patient Medical Record Number, now..
// String uer_id = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+uer_id);
// if(uer_id == null)
// {
// returnCode.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnCode.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnCode;
// }
//
// System.out.println(uer_id);
//
// id = Integer.parseInt(uer_id);
//
//
// System.out.println("Userid=" + id);
//
// // com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
//
// returnCode = storage.getMedicalHistory(id) ;
//
// System.out.println("DONE - returnCode" + returnCode);
//
// //returnJson.put("returnCode", returnCode);
//
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
//
// }
//
//
// return returnCode;
// }
//
//
// @Override
// public JSONObject GetAllergyById(String sessionToken) throws
// InstantiationException, IllegalAccessException, JSONException {
//
// int id = 0;
//
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
// JSONArray allergyRecordsArray =null;
// allergyRecordsArray = new JSONArray();
//
// try {
//
// System.out.println("************** GetAlleryById **********************");
//
// System.out.println("sessionToken=" + sessionToken);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnCode;
// }
// // Session is active - get Patient Medical Record Number, now..
// String uer_id = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+uer_id);
// if(uer_id == null)
// {
// returnCode.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnCode.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnCode;
// }
//
// System.out.println(uer_id);
//
// id = Integer.parseInt(uer_id);
//
//
// System.out.println("Userid=" + id);
// allergyRecordsArray = storage.getAllergy(id) ;
//
// System.out.println("DONE - returnCode" + returnCode);
//
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "false");
// returnCode.put("AllergyRecords",allergyRecordsArray);
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
//
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
// returnCode.put("returnCode", e.getMessage());
//
// }
//
//
// return returnCode;
// }
//
//
// @Override
// public JSONObject GetPatientProfile(String sessionToken) throws
// InstantiationException, IllegalAccessException, JSONException {
//
// int id = 0;
//
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
//
// try {
//
// System.out.println("************** GetAlleryById **********************");
//
// System.out.println("sessionToken=" + sessionToken);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnCode;
// }
// // Session is active - get Patient Medical Record Number, now..
// String uer_id = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+uer_id);
// if(uer_id == null)
// {
// returnCode.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnCode.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnCode;
// }
//
// System.out.println(uer_id);
//
// id = Integer.parseInt(uer_id);
//
//
// System.out.println("Userid=" + id);
//
//
//
//
// returnCode = storage.getPatientProfile(id) ;
//
// System.out.println("DONE - returnCode" + returnCode);
//
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "false");
//
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
//
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
// returnCode.put("returnCode", e.getMessage());
//
// }
//
//
// return returnCode;
// }
//
// @Override
// public JSONObject GetEmergencyRecords(String sessionToken)
// throws InstantiationException, IllegalAccessException,
// JSONException {
//
// int id = 0;
//
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
// JSONArray EmergencyRecordsArray =null;
// EmergencyRecordsArray = new JSONArray();
//
// try {
//
// System.out.println("************** GetAlleryById **********************");
//
// System.out.println("sessionToken=" + sessionToken);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnCode;
// }
// // Session is active - get Patient Medical Record Number, now..
// String uer_id = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+uer_id);
// if(uer_id == null)
// {
// returnCode.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnCode.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnCode;
// }
//
// System.out.println(uer_id);
//
// id = Integer.parseInt(uer_id);
//
//
// System.out.println("Userid=" + id);
// EmergencyRecordsArray = storage.getEmergencyRecord(id) ;
//
// System.out.println("DONE - returnCode" + returnCode);
//
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "false");
// returnCode.put("EmergencyRecords",EmergencyRecordsArray);
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
//
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
// returnCode.put("returnCode", e.getMessage());
//
// }
//
//
// return returnCode;
//
// }
//
// @Override
// public JSONObject GetPatientFullRecord(String sessionToken) throws
// InstantiationException, IllegalAccessException, JSONException
// {
// int id = 0;
// JSONObject returnCode = new JSONObject();
//
// JSONArray patientMedicalRecordsArray =null;
// patientMedicalRecordsArray = new JSONArray();
// try
// {
// String uer_id=null;
//
// System.out.println("sessionToken=" + sessionToken);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnCode;
// }
// // Session is active - get Patient Medical Record Number, now..
// uer_id = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+uer_id);
// if(uer_id == null)
// {
// returnCode.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnCode.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnCode;
// }
//
// System.out.println("************** GetPatientFullRecord
// **********************");
// System.out.println(uer_id);
// id = Integer.parseInt(uer_id);
// System.out.println("Userid=" + id);
//
// patientMedicalRecordsArray = storage.getPatientFullRecord(id);
//
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "false");
// returnCode.put("PatientMedicalRecords",patientMedicalRecordsArray);
// System.out.println("=================================");
// System.out.println(patientMedicalRecordsArray.toString());
// System.out.println("=================================");
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
// }
// return returnCode;
// }
//
//
// @Override
// public JSONObject GetBPPatientRecord( String doc_visit_date) throws
// InstantiationException, IllegalAccessException, JSONException {
//
//
//
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
// JSONArray patientMedicalRecordsArray =null;
// patientMedicalRecordsArray = new JSONArray();
//
// try {
//
// System.out.println("************** GetBPPatientRecord
// **********************");
//
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// patientMedicalRecordsArray = storage.getBPPatientRecord(doc_visit_date);
// if(patientMedicalRecordsArray.length() > 0)
// {
// // create patient.xml file
// returnCode.put("patientXML",
// createPatientXMLFile(patientMedicalRecordsArray));
//
// }
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("PatientMedicalRecords",patientMedicalRecordsArray);
// System.out.println("=================================");
// System.out.println(patientMedicalRecordsArray.toString());
// System.out.println("=================================");
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
// }
// return returnCode;
// }
// private String createPatientXMLFile(JSONArray patientMedicalRecordsArray)
// throws JSONException
// {
// String patientXML=null;
//
// try {
//
// System.out.println("************** createPatientXMLFile
// **********************");
//
// DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
// DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//
// // root elements
// Document doc = docBuilder.newDocument();
// Element rootElement = doc.createElement("PatientDetails");
// doc.appendChild(rootElement);
//
//
// // staff elements
// Element patients = doc.createElement("Patients");
// rootElement.appendChild(patients);
//
// System.out.println("Created Patients Node");
//
//
//
// // shorten way
// // staff.setAttribute("id", "1");
//
// int listLength = patientMedicalRecordsArray.length();
//
//
// // TotalResults elements
// Element TotalResults = doc.createElement("TotalResults");
// TotalResults.appendChild(doc.createTextNode(Integer.toString(listLength)));
// patients.appendChild(TotalResults);
//
// System.out.println("Created TotalResults Node");
//
// // TotalPages elements
// Element TotalPages = doc.createElement("TotalPages");
// TotalPages.appendChild(doc.createTextNode(Integer.toString(listLength)));
// patients.appendChild(TotalPages);
//
// for( int i = 0; i< listLength; i++)
// {
//
//
// JSONObject patientRecord = patientMedicalRecordsArray.getJSONObject(i);
//
// System.out.println("Created TotalPages Node");
//
// // TotalPages elements
// Element Item = doc.createElement("Item");
// // set attribute to staff element
// Item.setAttribute("patient.name",patientRecord.getString("user_firstname"));
//
// System.out.println("Created Item attribute");
//
// Element ItemAttributes = doc.createElement("ItemAttributes");
// Element Disease = doc.createElement("Disease");
//
// Disease.appendChild(doc.createTextNode(patientRecord.getString("user_firstname")));
// ItemAttributes.appendChild(Disease);
//
// System.out.println("Created Disease Node");
//
// Element City = doc.createElement("City");
//
// City.appendChild(doc.createTextNode(patientRecord.getString("user_firstname")));
// ItemAttributes.appendChild(City);
//
//
// Element DoctorVisitDate = doc.createElement("DoctorVisitDate");
//
// DoctorVisitDate.appendChild(doc.createTextNode(patientRecord.getString("doc_visit_date")));
// ItemAttributes.appendChild(DoctorVisitDate);
//
// System.out.println("Created DoctorVisitDate Node");
//
//
// Element Weight = doc.createElement("Weight");
//
// Weight.appendChild(doc.createTextNode(patientRecord.getString("weight")));
// ItemAttributes.appendChild(Weight);
//
// System.out.println("Created Weight Node");
//
//
// Element address = doc.createElement("Address");
//
// address.appendChild(doc.createTextNode(patientRecord.getString("address")));
// ItemAttributes.appendChild(address);
//
// System.out.println("Created address Node");
//
// Element gender = doc.createElement("Gender");
//
// gender.appendChild(doc.createTextNode(patientRecord.getString("gender")));
// ItemAttributes.appendChild(gender);
//
// System.out.println("Created gender Node");
//
// Element ethinicity = doc.createElement("Ethinicity");
//
// ethinicity.appendChild(doc.createTextNode(patientRecord.getString("ethinicity")));
// ItemAttributes.appendChild(ethinicity);
//
// System.out.println("Created ethinicity Node");
//
//
// Element birthday = doc.createElement("Birthday");
//
// birthday.appendChild(doc.createTextNode(patientRecord.getString("birthday")));
// ItemAttributes.appendChild(birthday);
//
// System.out.println("Created birthday Node");
//
//
//
//
// System.out.println("Created City Node");
//
//
// Item.appendChild(ItemAttributes);
//
// patients.appendChild(Item);
//
// System.out.println("Created Item Node");
//
//
//
// }
//
//
//
// File fileXML = new File("PatientsList.xml");
// System.out.println("File path = !" + fileXML.getAbsolutePath());
// // write the content into xml file
// TransformerFactory transformerFactory = TransformerFactory.newInstance();
// Transformer transformer = transformerFactory.newTransformer();
// DOMSource source = new DOMSource(doc);
// StreamResult result = new StreamResult(fileXML);
//
//
// patientXML = getStringFromDoc(doc);
//
// System.out.println("****************XML*************");
// System.out.println(patientXML);
//
//
// // Output to console for testing
// // StreamResult result = new StreamResult(System.out);
//
// transformer.transform(source, result);
//
// System.out.println("File saved!");
//
// } catch (ParserConfigurationException pce) {
// pce.printStackTrace();
// System.out.println(pce.getClass().getName() + " " + pce.getMessage());
//
// } catch (TransformerException tfe) {
// tfe.printStackTrace();
// System.out.println(tfe.getClass().getName() + " " + tfe.getMessage());
// }
// return patientXML;
// }
// public String getStringFromDoc(org.w3c.dom.Document doc) {
// DOMImplementationLS domImplementation = (DOMImplementationLS)
// doc.getImplementation();
// LSSerializer lsSerializer = domImplementation.createLSSerializer();
// return lsSerializer.writeToString(doc);
// }
//
// @Override
// public JSONObject getEHRReportsData(String sessionToken)
// throws InstantiationException, IllegalAccessException,
// JSONException {
// // TODO Auto-generated method stub
// JSONObject dataObj = new JSONObject();
//
// JSONObject obj = new JSONObject();
// obj.put("allergy_date","10/20/2000");
// obj.put("allergy_name","Dust Allergy");
// obj.put("reaction","Headache");
// obj.put("recordID","5");
// obj.put("severity","High fever");
// obj.put("status","SUCCESS");
//
// JSONObject obj1 = new JSONObject();
// obj1.put("allergy_date","09/20/2016");
// obj1.put("allergy_name","food");
// obj1.put("reaction","Headache");
// obj1.put("recordID","6");
// obj1.put("severity","High fever");
// obj1.put("status","SUCCESS");
// JSONObject obj2 = new JSONObject();
// obj2.put("allergy_date","10/20/2000");
// obj2.put("allergy_name","Dust Allergy");
// obj2.put("reaction","Headache");
// obj2.put("recordID","7");
// obj2.put("severity","High fever");
// obj2.put("status","SUCCESS");
// JSONObject obj3 = new JSONObject();
// obj3.put("allergy_date","20/9/2015");
// obj3.put("allergy_name","Dust Allergy");
// obj3.put("reaction","Headache");
// obj3.put("recordID","8");
// obj3.put("severity","High fever");
// obj3.put("status","SUCCESS");
// JSONObject obj4 = new JSONObject();
// obj4.put("allergy_date","20/4/2016");
// obj4.put("allergy_name","Dust Allergy");
// obj4.put("reaction","Headache");
// obj4.put("recordID","9");
// obj4.put("severity","High fever");
// obj4.put("status","SUCCESS");
//
// JSONObject PatientProfileobj = new JSONObject();
// PatientProfileobj.put("ForceLogOn","false");
// PatientProfileobj.put("address","Krishna Nagar Colony, Secunderabad, A.P
// India ");
// PatientProfileobj.put("birthday","11/08/1940");
// PatientProfileobj.put("blood_type","B+");
// PatientProfileobj.put("emergency_contact","01 510 754 6269");
// PatientProfileobj.put("ethinicity","Indian");
// PatientProfileobj.put("gender","Female");
// PatientProfileobj.put("height","4.85");
// PatientProfileobj.put("languagetype","Telugu");
// PatientProfileobj.put("phone","914027619269");
// PatientProfileobj.put("relationship","Son");
// PatientProfileobj.put("returnCode","SUCCESS");
// PatientProfileobj.put("status","SUCCESS");
// PatientProfileobj.put("user_firstname","Hanumayamma");
// PatientProfileobj.put("user_lastname","Vuppalapati");
// PatientProfileobj.put("weight","138.00");
//
// JSONObject PatientProfileobj1 = new JSONObject();
// PatientProfileobj1.put("ForceLogOn","false");
// PatientProfileobj1.put("address","Krishna Nagar Colony, Secunderabad, A.P
// India ");
// PatientProfileobj1.put("birthday","11/08/1940");
// PatientProfileobj1.put("blood_type","B+");
// PatientProfileobj1.put("emergency_contact","01 510 754 6269");
// PatientProfileobj1.put("ethinicity","Indian");
// PatientProfileobj1.put("gender","Female");
// PatientProfileobj1.put("height","4.85");
// PatientProfileobj1.put("languagetype","Telugu");
// PatientProfileobj1.put("phone","914027619269");
// PatientProfileobj1.put("relationship","Son");
// PatientProfileobj1.put("returnCode","SUCCESS");
// PatientProfileobj1.put("status","SUCCESS");
// PatientProfileobj1.put("user_firstname","Hanumayamma");
// PatientProfileobj1.put("user_lastname","Vuppalapati");
// PatientProfileobj1.put("weight","138.00");
//
// JSONObject PatientProfileobj2 = new JSONObject();
// PatientProfileobj2.put("ForceLogOn","false");
// PatientProfileobj2.put("address","Krishna Nagar Colony, Secunderabad, A.P
// India ");
// PatientProfileobj2.put("birthday","11/08/1940");
// PatientProfileobj2.put("blood_type","B+");
// PatientProfileobj2.put("emergency_contact","01 510 754 6269");
// PatientProfileobj2.put("ethinicity","Indian");
// PatientProfileobj2.put("gender","Female");
// PatientProfileobj2.put("height","4.85");
// PatientProfileobj2.put("languagetype","Telugu");
// PatientProfileobj2.put("phone","914027619269");
// PatientProfileobj2.put("relationship","Son");
// PatientProfileobj2.put("returnCode","SUCCESS");
// PatientProfileobj2.put("status","SUCCESS");
// PatientProfileobj2.put("user_firstname","Hanumayamma");
// PatientProfileobj2.put("user_lastname","Vuppalapati");
// PatientProfileobj2.put("weight","138.00");
//
// JSONObject PatientProfileobj3 = new JSONObject();
// PatientProfileobj3.put("ForceLogOn","false");
// PatientProfileobj3.put("address","Krishna Nagar Colony, Secunderabad, A.P
// India ");
// PatientProfileobj3.put("birthday","11/08/1940");
// PatientProfileobj3.put("blood_type","B+");
// PatientProfileobj3.put("emergency_contact","01 510 754 6269");
// PatientProfileobj3.put("ethinicity","Indian");
// PatientProfileobj3.put("gender","Female");
// PatientProfileobj3.put("height","4.85");
// PatientProfileobj3.put("languagetype","Telugu");
// PatientProfileobj3.put("phone","914027619269");
// PatientProfileobj3.put("relationship","brother");
// PatientProfileobj3.put("returnCode","SUCCESS");
// PatientProfileobj3.put("status","SUCCESS");
// PatientProfileobj3.put("user_firstname","Raja");
// PatientProfileobj3.put("user_lastname","Vuppalapati");
// PatientProfileobj3.put("weight","138.00");
//
// JSONObject PatientProfileobj4 = new JSONObject();
// PatientProfileobj4.put("ForceLogOn","false");
// PatientProfileobj4.put("address","Krishna Nagar Colony, Secunderabad, A.P
// India ");
// PatientProfileobj4.put("birthday","14/08/1972");
// PatientProfileobj4.put("blood_type","A-");
// PatientProfileobj4.put("emergency_contact","01 510 754 6269");
// PatientProfileobj4.put("ethinicity","Indian");
// PatientProfileobj4.put("gender","Female");
// PatientProfileobj4.put("height","4.85");
// PatientProfileobj4.put("languagetype","Telugu");
// PatientProfileobj4.put("phone","914027619269");
// PatientProfileobj4.put("relationship","Brother");
// PatientProfileobj4.put("returnCode","SUCCESS");
// PatientProfileobj4.put("status","SUCCESS");
// PatientProfileobj4.put("user_firstname","Jaya Shankar");
// PatientProfileobj4.put("user_lastname","Vuppalapati");
// PatientProfileobj4.put("weight","138.00");
//
// JSONArray array = new JSONArray();
// array.put(obj);
// array.put(obj1);
// array.put(obj2);
// array.put(obj3);
// array.put(obj4);
//
// JSONArray PatientMedicalRecords = new JSONArray();
// JSONObject PatientMedicalRecord = new JSONObject();
// PatientMedicalRecord.put("blood_presure_diastolic","120");
// PatientMedicalRecord.put("blood_presure_systolic","90");
// PatientMedicalRecord.put("body_weight","120");
// PatientMedicalRecord.put("comments_from_doc","Confirmed! \nPregnancy");
// PatientMedicalRecord.put("doc_name","Pushpalatha");
// PatientMedicalRecord.put("doc_visit_date","08/20/1969");
// PatientMedicalRecord.put("mode_of_visit","Pregnancy check");
// PatientMedicalRecord.put("prescribed_medicaltest_drugs","Capsules");
// PatientMedicalRecord.put("primary_doc","false");
// PatientMedicalRecord.put("recordID","16");
// PatientMedicalRecord.put("record_type","MedicalHistory");
// PatientMedicalRecord.put("status","SUCCESS");
// PatientMedicalRecord.put("temperature","97");
// PatientMedicalRecords.put(PatientMedicalRecord);
// PatientMedicalRecords.put(PatientMedicalRecord);
//
//
// JSONArray vaccinationImmunizationMedicalRecords = new JSONArray();
// JSONObject vaccinationImmunizationMedicalRecordsObj = new JSONObject();
// vaccinationImmunizationMedicalRecordsObj.put("VaccinationImmunization_date","12/20/1940");
// vaccinationImmunizationMedicalRecordsObj.put("VaccinationImmunization_dose_qantity","1");
// vaccinationImmunizationMedicalRecordsObj.put("VaccinationImmunization_name","Polio
// Shot");
// vaccinationImmunizationMedicalRecordsObj.put("VaccinationImmunization_type","Polio");
// vaccinationImmunizationMedicalRecordsObj.put("recordID","2");
// vaccinationImmunizationMedicalRecordsObj.put("record_type","VaccinationImmunization");
// vaccinationImmunizationMedicalRecordsObj.put("status","SUCCESS");
// vaccinationImmunizationMedicalRecords.put(vaccinationImmunizationMedicalRecordsObj);
//
// JSONArray MedicationRecords = new JSONArray();
// JSONObject MedicationRecordsObj = new JSONObject();
// MedicationRecordsObj.put("date_of_medication","01/10/1969");
// MedicationRecordsObj.put("dose_qantity","2");
// MedicationRecordsObj.put("reactinstructionsion","Daily take two capsule");
// MedicationRecordsObj.put("name_of_mediaction","Vitamin C");
// MedicationRecordsObj.put("prescriber_name","Pushpalatha");
// MedicationRecordsObj.put("rate_quantity","1");
// MedicationRecordsObj.put("recordID","6");
// MedicationRecordsObj.put("record_type","Medications");
// MedicationRecordsObj.put("status","SUCCESS");
// MedicationRecordsObj.put("type_of_medication","Capsules");
// MedicationRecords.put(MedicationRecordsObj);
// MedicationRecords.put(MedicationRecordsObj);
//
//
// JSONArray PatientProfilearray = new JSONArray();
// PatientProfilearray.put(PatientProfileobj);
// PatientProfilearray.put(PatientProfileobj1);
// PatientProfilearray.put(PatientProfileobj2);
// PatientProfilearray.put(PatientProfileobj3);
// PatientProfilearray.put(PatientProfileobj4);
//
// dataObj.put("ForceLogOn", false);
// dataObj.put("AllergyRecords", array);
// dataObj.put("Patient Profile", PatientProfilearray);
// dataObj.put("Vaccination", vaccinationImmunizationMedicalRecords);
// dataObj.put("Medication", MedicationRecords);
// dataObj.put("Medical Records", PatientMedicalRecords);
// dataObj.put("returnCode", "SUCCESS");
//
// return dataObj;
//
//
// }
// @Override
// public JSONObject CreateMedicalDetailsRecord(String jsonString)
// throws InstantiationException, IllegalAccessException,
// ParseException, JSONException {
// System.out.println("************** profile **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
// String Medical_contactName = null;
// String Medical_email = null;
// String Medical_Address = null;
// String Medical_Hospital_Details = null;
// String Medical_contactNumber = null;
// String sessionToken=null;
// int id = 0;
// try
// {
// JSONObject json = new JSONObject(jsonString);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// System.out.println("jsonString=" + jsonString);
// sessionToken = json.getString("sessionToken");
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnJson;
// }
// // Session is active - get Patient Medical Record Number, now..
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnJson;
// }
// id = Integer.parseInt(User_ID);
// Medical_contactName = json.getString("MedicalcontactName");
// Medical_email = json.getString("Medical_email") ;
// Medical_Address = json.getString("Medical_Address");
// Medical_Hospital_Details = json.getString("Medical_Hospital_Details") ;
// Medical_contactNumber = json.getString("MedicalcontactNumber");
//// data.MedicalcontactName = $scope.Medical_contactName;
//// data.Medical_email = $scope.Medical_email;
//// data.Medical_Address = $scope.Medical_Address;
//// data.Medical_Hospital_Details = $scope.Medical_Hospital_Details;
//// data.MedicalcontactNumber = $scope.Medical_contactNumber;
// System.out.println("*** EMRN=" + id);
// System.out.println("*** Medical_contactName=" + Medical_contactName);
// System.out.println("*** name_of_mediaction=" + Medical_email);
// System.out.println("*** Medical_Address=" + Medical_Address);
// System.out.println("*** Medical_Hospital_Details=" +
// Medical_Hospital_Details);
// System.out.println("*** Medical_contactNumber=" + Medical_contactNumber);
//
// // Create profile Object and Store it in the Database
// MedicalContacts medications = new MedicalContacts() ;
// //Database storage = new Database();
// medications.setMedical_Address(Medical_Address);
// medications.setMedical_Hospital_Details(Medical_Hospital_Details);
// medications.setMedical_contactName(Medical_contactName);
// medications.setMedical_email(Medical_email);
// medications.setMedical_contactNumber(Medical_contactNumber);
// medications.setUer_ID(id);
// returnCode = storage.CreateMedicationContacts(medications);
// System.out.println("DONE - returnCode" + returnCode);
// returnJson.put("ForceLogOn", "false");
// returnJson.put("returnCode", returnCode);
// System.out.println("DONE");
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
// }
//
//
// return returnJson;
// }
// @Override
// public JSONObject GetMedicalDetailsById(String sessionToken)
// throws InstantiationException, IllegalAccessException,
// JSONException {
// int id = 0;
//
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
// JSONArray allergyRecordsArray =null;
// allergyRecordsArray = new JSONArray();
//
// try {
//
// System.out.println("************** GetAlleryById **********************");
//
// System.out.println("sessionToken=" + sessionToken);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnCode;
// }
// // Session is active - get Patient Medical Record Number, now..
// String uer_id = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+uer_id);
// if(uer_id == null)
// {
// returnCode.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnCode.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnCode;
// }
//
// System.out.println(uer_id);
//
// id = Integer.parseInt(uer_id);
//
//
// System.out.println("Userid=" + id);
// allergyRecordsArray = storage.getMedicalContacts(id) ;
//
// System.out.println("DONE - returnCode" + returnCode);
//
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "false");
// returnCode.put("MedicalContacts",allergyRecordsArray);
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
//
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
// returnCode.put("returnCode", e.getMessage());
//
// }
//
//
// return returnCode;
// }
// @Override
// public Response updateUserInfo(String jsonString)
// throws InstantiationException, IllegalAccessException,
// JSONException {
// System.out.println("************** Profile Image Update
// **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
// String documentID = null;
// String sessionToken=null;
// int id = 0;
// try
// {
// JSONObject json = new JSONObject(jsonString);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// System.out.println("jsonString=" + jsonString);
// sessionToken = json.getString("sessionToken");
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return Response.status(404).build();
// }
// // Session is active - get Patient Medical Record Number, now..
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return Response.status(404).build();
// }
// id = Integer.parseInt(User_ID);
// documentID = json.getString("documentID");
//
// System.out.println("*** EMRN=" + id);
// System.out.println("*** documentName=" + documentID);
//
//
// // Create profile Object and Store it in the Database
// Profile imageInfo = new Profile() ;
//
// imageInfo.set_id(id);
// imageInfo.setImagedocumentID(documentID);
// returnCode = storage.updateProfileImage(imageInfo,id);
// //System.out.println("DONE - returnCode" + returnCode);
// returnJson.put("ForceLogOn", "false");
// returnJson.put("returnCode", returnCode);
// System.out.println("DONE");
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
// }
//
//
// return Response.status(201).entity(returnJson).build();
// }
// @Override
// public JSONObject getData(String Keyword)
// throws InstantiationException, IllegalAccessException,
// JSONException {
// System.out.println(Keyword);
// TwitterDataTweets tweet = new TwitterDataTweets();
// //tweet.getTweets(jsonString);
// return tweet.getTweets(Keyword);
// }
// @Override
// public JSONObject GetMedicationRecords(String sessionToken)
// throws InstantiationException, IllegalAccessException,
// JSONException {
//
// int id = 0;
//
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
// JSONArray MedicationRecordsArray =null;
// MedicationRecordsArray = new JSONArray();
//
// try {
//
// System.out.println("************** Get Medication Records
// **********************");
//
// System.out.println("sessionToken=" + sessionToken);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnCode;
// }
// // Session is active - get Patient Medical Record Number, now..
// String uer_id = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+uer_id);
// if(uer_id == null)
// {
// returnCode.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnCode.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnCode;
// }
//
// System.out.println(uer_id);
//
// id = Integer.parseInt(uer_id);
//
//
// System.out.println("Userid=" + id);
// MedicationRecordsArray = storage.getMedicationRecord(id) ;
//
// System.out.println("DONE - returnCode" + returnCode);
//
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "false");
// returnCode.put("MedicationRecords",MedicationRecordsArray);
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
//
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
// returnCode.put("returnCode", e.getMessage());
//
// }
//
//
// return returnCode;
//
//
// }
// @Override
// public JSONObject GetvaccinationimmunizationRecordsById(String sessionToken)
// throws InstantiationException, IllegalAccessException,
// JSONException {
//
// int id = 0;
//
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
// JSONArray vaccinationimmunizationRecordsArray =null;
// vaccinationimmunizationRecordsArray = new JSONArray();
//
// try {
//
// System.out.println("************** Get vaccinationimmunization Records
// **********************");
//
// System.out.println("sessionToken=" + sessionToken);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnCode;
// }
// // Session is active - get Patient Medical Record Number, now..
// String uer_id = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+uer_id);
// if(uer_id == null)
// {
// returnCode.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnCode.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnCode;
// }
//
// System.out.println(uer_id);
//
// id = Integer.parseInt(uer_id);
//
//
// System.out.println("Userid=" + id);
// vaccinationimmunizationRecordsArray =
// storage.getvaccinationimmunizationRecord(id) ;
//
// System.out.println("DONE - returnCode" + returnCode);
//
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "false");
// returnCode.put("vaccinationimmunizationRecords",vaccinationimmunizationRecordsArray);
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
//
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
// returnCode.put("returnCode", e.getMessage());
//
// }
//
//
// return returnCode;
//
//
// }
// @Override
// public Response GetImage(String sessionToken)
// throws InstantiationException, IllegalAccessException, JSONException {
// // TODO Auto-generated method stub
// int id = 0;
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
// JSONArray vaccinationimmunizationRecordsArray =null;
// vaccinationimmunizationRecordsArray = new JSONArray();
// InputStream imageData = null;
// try {
//
// System.out.println("************** Get Image Records
// **********************");
//
// System.out.println("sessionToken=" + sessionToken);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// System.out.println(storage.isSessionActive(sessionToken));
//
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return Response.ok().status(404).build();
// }
// // Session is active - get Patient Medical Record Number, now..
// String uer_id = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+uer_id);
// if(uer_id == null)
// {
// returnCode.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnCode.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return Response.ok().status(400).build();
// }
//
// System.out.println(uer_id);
//
// id = Integer.parseInt(uer_id);
//
//
// System.out.println("Userid=" + id);
// String DocumentID = storage.getdocumrntID(id);
// System.out.println("inside impl:"+DocumentID);
// String nonstuff = null;
// System.out.println(DocumentID == null);
// if(DocumentID == null)
// {
// return Response.ok().status(304).build();
// }
// else
// {
// imageService image = new imageService();
// imageData = image.getImage(DocumentID);
// }
// //System.out.println("DONE - returnCode" + returnCode);
//
//// returnCode.put("returnCode", "SUCCESS");
//// returnCode.put("ForceLogOn", "false");
//// returnCode.put("vaccinationimmunizationRecords",vaccinationimmunizationRecordsArray);
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
//
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
// returnCode.put("returnCode", e.getMessage());
//
// }
//
// return Response.ok(imageData).status(200).build();
// //return imageData;
//
// }
//// data.sessionToken=gSessionTokenssion;
//// data.reminders_Date = $scope.reminders_Date;
//// data.reminders_Time = $scope.reminders_Time;
//// data.reminders_DRname = $scope.reminders_DRname;
//// data.reminders_Reason = $scope.reminders_Reason;
//// data.reminders_Description = $scope.reminders_Description;
//
// @Override
// public JSONObject CreateReminderHistory(String jsonString)
// throws InstantiationException, IllegalAccessException,
// ParseException, JSONException {
// System.out.println("************** reminders **********************");
// System.out.println(jsonString);
// JSONObject returnJson = null;
// String returnCode = "SUCCESS";
// returnJson = new JSONObject();
// String reminders_Date = null;
// String reminders_Time = null;
// String reminders_DRname = null;
// String reminders_Reason = null;
// String reminders_Description = null;
// String sessionToken=null;
// int id = 0;
// try
// {
// JSONObject json = new JSONObject(jsonString);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// System.out.println("jsonString=" + jsonString);
// sessionToken = json.getString("sessionToken");
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnJson.put("returnCode", "SUCCESS");
// returnJson.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnJson;
// }
// // Session is active - get Patient Medical Record Number, now..
// String User_ID = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+User_ID);
// if(User_ID == null)
// {
// returnJson.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnJson.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnJson;
// }
// id = Integer.parseInt(User_ID);
// reminders_Date = json.getString("reminders_Date");
// reminders_Time = json.getString("reminders_Time") ;
// reminders_DRname = json.getString("reminders_DRname");
// reminders_Reason = json.getString("reminders_Reason") ;
// reminders_Description = json.getString("reminders_Description");
//// data.MedicalcontactName = $scope.Medical_contactName;
//// data.Medical_email = $scope.Medical_email;
//// data.Medical_Address = $scope.Medical_Address;
//// data.Medical_Hospital_Details = $scope.Medical_Hospital_Details;
//// data.MedicalcontactNumber = $scope.Medical_contactNumber;
// System.out.println("*** EMRN=" + id);
// System.out.println("*** reminders_Date=" + reminders_Date);
// System.out.println("*** reminders_Time=" + reminders_Time);
// System.out.println("*** reminders_DRname=" + reminders_DRname);
// System.out.println("*** reminders_Reason=" + reminders_Reason);
// System.out.println("*** reminders_Description=" + reminders_Description);
//
// // Create profile Object and Store it in the Database
// ReminderDetails reminders = new ReminderDetails() ;
// //Database storage = new Database();
// reminders.setReminders_Date(reminders_Date);
// reminders.setReminders_Description(reminders_Description);
// reminders.setReminders_Time(reminders_Time);
// reminders.setReminders_DRname(reminders_DRname);
// reminders.setReminders_Reason(reminders_Reason);
// reminders.setUer_ID(id);
// returnCode = storage.CreateReminderDetails(reminders);
// System.out.println("DONE - returnCode" + returnCode);
// returnJson.put("ForceLogOn", "false");
// returnJson.put("returnCode", returnCode);
// System.out.println("DONE");
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode = "ERROR";
// returnJson.put("returnCode", e.getMessage());
// }
//
//
// return returnJson; }
// @Override
// public JSONObject GetRecordDetails(String sessionToken)
// throws InstantiationException, IllegalAccessException, JSONException {
//
// int id = 0;
//
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
// JSONArray recordsDetailsArray =null;
// recordsDetailsArray = new JSONArray();
//
// try {
//
// System.out.println("************** Get Records Details
// **********************");
//
// System.out.println("sessionToken=" + sessionToken);
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
// // check whether session is elasped or not
// if(storage.isSessionActive(sessionToken) == false)
// {
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "true");
// System.out.println("************ Session is not active - FORCE LOGON
// ********");
// return returnCode;
// }
// // Session is active - get Patient Medical Record Number, now..
// String uer_id = storage.fetchEMRN(sessionToken);
// System.out.println("User_ID="+uer_id);
// if(uer_id == null)
// {
// returnCode.put("returnCode", "ERROR - Unable to initiate session - please
// contact administrator");
// returnCode.put("displayErrorPage", "true");
// System.out.println("************ EMRN cannot be NULL ********");
// return returnCode;
// }
//
// System.out.println(uer_id);
//
// id = Integer.parseInt(uer_id);
//
//
// System.out.println("Userid=" + id);
// recordsDetailsArray = storage.getRecordDetails(id) ;
//
// System.out.println("DONE - returnCode" + returnCode);
//
// returnCode.put("returnCode", "SUCCESS");
// returnCode.put("ForceLogOn", "false");
// returnCode.put("RecordsDetails",recordsDetailsArray);
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
// returnCode.put("returnCode", e.getMessage());
//
//
// } catch (Exception e)
// {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
// returnCode.put("returnCode", e.getMessage());
//
// }
//
//
// return returnCode;
//
//
// }
// @Override
// public JSONObject TwoFactorAuthentication(String jsonString)
// throws InstantiationException, IllegalAccessException {
// // TODO Auto-generated method stub
//
// int Passcode;
// String Email = null;
//
// //JSONObject returnJson = null;
// JSONObject returnCode = null;
// //returnJson = new JSONObject();
// returnCode = new JSONObject();
//
// try {
//
// System.out.println("************** Login **********************");
// System.out.println(jsonString);
//
// JSONObject json = new JSONObject(jsonString);
//
// Email = json.getString("email");
// Passcode = json.getInt("Passcode");
//
//
// System.out.println("Passcode=" + Passcode);
// //System.out.println("Passwor=" + userpass);
//
// com.sanjeevaniehr.user.registration.services.Database storage = new
// com.sanjeevaniehr.user.registration.services.Database();
//
// returnCode = storage.verifyTwofactorAuthentication(Email,Passcode) ;
//
// System.out.println("DONE - returnCode" + returnCode);
//
// //returnJson.put("returnCode", returnCode);
//
//
//
// } catch (JSONException e) {
// System.out.println(e.getClass().getName() + " " + e.getMessage());
// e.printStackTrace();
//
//
// }
//
//
// return returnCode;
// }
//
//
// }