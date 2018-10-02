package com.sanjeevaniehr.user.registration.services;

// package com.sanjeevaniehr.user.registration.services;
//
// import java.sql.Statement;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
//
// import org.json.JSONArray;
// import org.json.JSONObject;
// import org.json.JSONException;
//
// import exception.NotFoundException;
//
// import com.mysql.jdbc.PreparedStatement;
// import com.sanjeevaniehr.user.registration.services.User ;
//
// import java.util.*;
// import java.text.*;
// import java.util.UUID;
// import java.security.MessageDigest;
//
// import javax.mail.Address;
// import javax.mail.Message;
// import javax.mail.Session;
// import javax.mail.Transport;
// import javax.mail.internet.InternetAddress;
// import javax.mail.internet.MimeMessage;
//
// public class DatabaseBackup {
//
//
// Connection connection = null;
//
// Statement statement = null;
//
// ResultSet rs = null;
// int MAX_SESSION_ALLOWED_TIME = 900; // 900 seconds - 15 minutes
//
//
// // create session record
// private String closeUserSession(String strSessionKey, long
// curLogoutTime)throws InstantiationException, IllegalAccessException {
//
// String returnStr="SUCCESS";
// try {
//
// System.out.println("**************** INside Database profile closeUserSession
// *************");
// // Get Connection
// connection = getConnection();
// Date curDate = new Date();
// // Prepare SQL Statement
// statement = connection.createStatement();
//
// /* UPDATE activesessions
// Set isActive='N', logoutNanoTime='12'
// where accessKey='5ae3206a-ecc1-484b-a5f6-2d0bd4c32646'; */
// String sqlStatement = "UPDATE activesessions Set isActive='" + "N" + "'
// ,logoutNanoTime='" + curLogoutTime + "',logoutDateTime='" +
// curDate.toString() + "' WHERE accessKey='" + strSessionKey + "'";
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
// }
//
// // create session record
// private String createSessionRecord(int user_id,String strSessionKey)throws
// InstantiationException, IllegalAccessException {
//
// String returnStr="SUCCESS";
// try {
//
// System.out.println("**************** INside Database profile
// createSessionRecord *************");
// // Get Connection
// connection = getConnection();
// Date curDate = new Date();
// // Prepare SQL Statement
// statement = connection.createStatement();
// String sqlStatement = "INSERT INTO activesessions" + "(accessKey , uer_id ,
// isActive , creationDateTime , creationNanoTime)" +
// " values(" + "'" + strSessionKey + "'" + ", '" + user_id + "'" + ",'" + "Y"
// +"'" + ",'" + curDate.toString() +"'" + ",'" + System.nanoTime() +"'" +")";
//
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
// }
//
//
// /**
// * The byte[] returned by MessageDigest does not have a nice
// * textual representation, so some form of encoding is usually performed.
// *
// * This implementation follows the example of David Flanagan's book
// * "Java In A Nutshell", and converts a byte array into a String
// * of hex characters.
// *
// * Another popular alternative is to use a "Base64" encoding.
// */
// static private String hexEncode( byte[] aInput){
// StringBuilder result = new StringBuilder();
// char[] digits = {'0', '1', '2', '3',
// '4','5','6','7','8','9','a','b','c','d','e','f'};
// for ( int idx = 0; idx < aInput.length; ++idx) {
// byte b = aInput[idx];
// result.append( digits[ (b&0xf0) >> 4 ] );
// result.append( digits[ b&0x0f] );
// }
// return result.toString();
// }
//
//
// // Purpose of createSessionAccessKey is to create an unique session argument
// key
// private String createActivationLinkCode(int user_id) throws
// InstantiationException, IllegalAccessException
// {
// String strActivationLinkCode = null;
// try {
// //generate random UUIDs
//
// System.out.println("*************** Inside Database -
// createActivationLinkCode****************");
// UUID randomSessionToken = UUID.randomUUID();
// String randomNum= randomSessionToken.toString();
// System.out.println("randomNum="+randomNum);
//
// randomNum += String.valueOf(user_id);
// System.out.println("randomNum with user_id added ="+randomNum);
//
// // Insert Session Key into Sessions Table
// //get its digest
// System.out.println("before Message Digest");
// MessageDigest sha = MessageDigest.getInstance("SHA-1");
// byte[] result = sha.digest( randomNum.getBytes() );
// System.out.println("after Message Digest");
// strActivationLinkCode = hexEncode(result);
//
// System.out.println("!!!!!!!!!!!!!! strActivationLinkCode = " +
// strActivationLinkCode);
//
// } catch(Exception e) {
//
// strActivationLinkCode = "ERROR";
// System.out.println(e);
//
// }
//
// return strActivationLinkCode;
// }
//
//
// // Purpose of createSessionAccessKey is to create an unique session argument
// key
// private String createSessionAccessTokenKey(int user_id) throws
// InstantiationException, IllegalAccessException
// {
// //generate random UUIDs
// UUID randomSessionToken = UUID.randomUUID();
// // Insert Session Key into Sessions Table
// String strSessionCreationStatus =
// createSessionRecord(user_id,randomSessionToken.toString());
// if(strSessionCreationStatus == "SUCCESS")
// {
// return randomSessionToken.toString();
// }
// else
// {
// return "[ERROR]" + strSessionCreationStatus;
// }
// }
// private Connection getConnection() throws InstantiationException,
// IllegalAccessException {
//
// String driverName = "com.mysql.jdbc.Driver";
//
// String conectionURI = "jdbc:mysql://localhost:3306/sanjeevani";
//
// String userName = "root";
//
// String password = "";
//
//
//
//
//
// try {
//
// Class.forName(driverName).newInstance();
//
// try {
//
// connection = DriverManager.getConnection(conectionURI, userName, password);
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// try {
//
// connection.setAutoCommit(true);
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
//
//
// } catch (ClassNotFoundException e) {
//
// e.printStackTrace();
//
// }
//
//
//
// return connection;
//
// }
//
//
//
// //CREATE operation
//
// public String addUser(User users) throws InstantiationException,
// IllegalAccessException {
// String returnStr="SUCCESS";
// try {
//
// System.out.println("**************** INside Database addUser *************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
// // INSERT INTO `sanjeevani`.`users` (`user_type`, `user_description`,
// `user_email`, `user_pass`, `user_firstname`, `user_lastname`) VALUES
// ('Provider', 'Provider', 'aba', 'aba', 'aba', 'aab');
// // Prepare INSERT SQL Statement
// // Please note: for first time registration, that is before sending
// activation link, user active value is set to No]
// System.out.println("SELECT * FROM users WHERE user_email
// ="+users.get_email());
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM users WHERE user_email = ?") ;
// ps.setString(1, users.get_email());
//
// ResultSet rs = ps.executeQuery() ;
// int resultSetSize = 0;
// int id = 0;
// System.out.println("value of rs.next:"+rs.next());
// if (rs.next())
// {
// System.out.println("User name Already present") ;
// returnStr="User name Already present";
// } else{
//
// String sqlStatement = "INSERT INTO users" +
// "(user_type,user_email,user_pass,user_firstname,user_lastname,active_user,SecurityQuestion,SecurityQuestionAnswer)"
// +
// " values(" + "'" + users.getuser_type() + "'" + ",'" + users.get_email() +"'"
// + ",'" + users.getuser_pass() +"'"
// + ",'" + users.get_firstname() +"'" + ",'" + users.get_lastname() + "'" +
// ",'" + "No" + "'" + ",'"
// + users.get_securityQuestion() + "'" + ",'" + users.get_securityAnswer() +
// "'" + ")";
//
//
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
//
// }
//
//
//
//
//
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
//
// }
//
//
// public JSONObject createActivationsRecord(User users) throws
// InstantiationException, IllegalAccessException, JSONException {
// String returnStr="SUCCESS";
// JSONObject returnActivationsRecordJson = null;
// try
// {
// returnActivationsRecordJson = new JSONObject();
// System.out.println("**************** INside Database createActivationRecord
// *************");
// // Get Connection
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT uer_id ,user_email, user_pass FROM users WHERE user_email = ? and
// user_pass =? ") ;
// ps.setString(1, users.get_email());
// ps.setString(2, users.getuser_pass()) ;
// ResultSet rs = ps.executeQuery() ;
// int resultSetSize = 0;
// int id = 0;
//
//
// if (rs != null)
// {
// rs.beforeFirst();
// rs.last();
// resultSetSize = rs.getRow();
// }
//
//
//
// if(!(resultSetSize > 0)){
//
// System.out.println("User name and password not matched") ;
// returnStr="User name and password not matched";
//
// }
// else
// {
// id = rs.getInt("uer_id");
// }
//
// // generate unique activation key
// String strActivationLinkKey = createActivationLinkCode(id);
// Date curDate = new Date();
// String strActivationStatus="Not Complete";
// String strAccountActive = "No";
// returnActivationsRecordJson.put("ActivationKey", strActivationLinkKey);
// returnActivationsRecordJson.put("EMRN", String.valueOf(id));
// returnActivationsRecordJson.put("Email", users.get_email());
// returnActivationsRecordJson.put("FName", users.get_firstname());
// returnActivationsRecordJson.put("LName", users.get_lastname());
// // Prepare SQL Statement
// statement = connection.createStatement();
// // First get user_id from users
//
// String sqlStatement = "INSERT INTO activations" +
// "(activationKey,issueDate,Status,accountActive,uer_id)" +
// " values(" + "'" + strActivationLinkKey + "'" + ",'" + curDate.toString()
// +"'" + ",'" + strActivationStatus +"'"
// + ",'" + strAccountActive +"'" + ",'" + id + "'" + ")";
//
//
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
// returnActivationsRecordJson.put("returnStr", returnStr);
//
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
// returnActivationsRecordJson.put("returnStr", returnStr);
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
// }
// if (connection != null)
// {
// try {
//
// connection.close();
//
// } catch (SQLException e) {
// e.printStackTrace();
// }
//
// }
// }
// return returnActivationsRecordJson;
// }
//
//
// public JSONObject activateUserAccount(String activationCode) throws
// InstantiationException, IllegalAccessException, JSONException {
// String returnStr="SUCCESS";
// JSONObject returnActivationsRecordJson = null;
// try
// {
// returnActivationsRecordJson = new JSONObject();
// System.out.println("**************** INside Database activateUserAccount
// *************");
// // Get Connection
// Date curDate = new Date();
// connection = getConnection();
// statement = connection.createStatement();
//
// String sqlStatement = "UPDATE activations Set Status='" + "Complete" + "'
// ,accountActive='" + "Yes" + "' ,completionDate='" + curDate.toString() + "'
// WHERE activationKey='" + activationCode + "'";
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// // Now is the time to create active session record so that User can complete
// Profile or can go to Landing Page
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT uer_id FROM activations WHERE activationKey = ? ") ;
// ps.setString(1, activationCode);
// ResultSet rs = ps.executeQuery() ;
// int resultSetSize = 0;
// if (rs != null)
// {
// rs.beforeFirst();
// rs.last();
// resultSetSize = rs.getRow();
// }
//
// if(!(resultSetSize > 0)){
//
// System.out.println("How come no User ID for the activations....") ;
// returnStr="No activation record found";
// returnActivationsRecordJson.put("returnCode",returnStr);
//
// }
// else
// {
// int id = rs.getInt("uer_id");
//
// System.out.println("Got the User ID=" + id);
// // Time to create an unique session identifier
// String strSessionToken = createSessionAccessTokenKey(id);
//
// if(strSessionToken.contains("[ERROR]") == true)
// {
// returnActivationsRecordJson.put("sessionToken",strSessionToken);
// returnActivationsRecordJson.put("returnCode",strSessionToken);
// }
// else
// {
// returnActivationsRecordJson.put("sessionToken",strSessionToken);
// returnStr="SUCCESS";
// returnActivationsRecordJson.put("returnCode",returnStr);
// }
//
// }
// } catch (SQLException e) {
// returnStr=e.getMessage();
// returnActivationsRecordJson.put("returnCode", returnStr);
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
// }
// if (connection != null)
// {
// try {
//
// connection.close();
//
// } catch (SQLException e) {
// e.printStackTrace();
// }
//
// }
// }
// return returnActivationsRecordJson;
// }
//
//
// public JSONObject login(String userName, String password) throws
// InstantiationException, IllegalAccessException, JSONException
//
// {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
//
// try {
//
//
// returnJson = new JSONObject();
// System.out.println("********** At Database level............***********");
// System.out.println("UserName=" + userName);
// System.out.println("password=" + password);
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT uer_id ,user_email, user_pass FROM users WHERE user_email = ? and
// user_pass =? ") ;
// ps.setString(1, userName);
// ps.setString(2, password) ;
// ResultSet rs = ps.executeQuery() ;
// int resultSetSize = 0;
//
//
//
// if (rs != null)
// {
// rs.beforeFirst();
// rs.last();
// resultSetSize = rs.getRow();
// }
//
//
//
// if(!(resultSetSize > 0)){
//
// System.out.println("User name and password not matched") ;
// returnStr="User name and password not matched";
//
// }
// else
// {
//
// int id = rs.getInt("uer_id");
//
// returnJson.put("userid", id);
// System.out.println("User name and password matched") ;
//
// // Time to create an unique session identifier
// String strSessionToken = createSessionAccessTokenKey(id);
// if(strSessionToken.contains("[ERROR]") == true)
// {
// returnJson.put("sessionToken",strSessionToken);
// returnJson.put("returnCode",strSessionToken);
// }
// else
// {
// returnJson.put("sessionToken",strSessionToken);
// returnStr="SUCCESS";
// returnJson.put("returnCode",returnStr);
// }
//
// }
//
// } catch (SQLException e) {
//
// returnStr=e.getMessage();
//
// returnJson.put("status",returnStr);
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return returnJson ;
// }
//
//
// public String UpdateProfile(Profile profile )throws InstantiationException,
// IllegalAccessException {
//
// String returnStr="SUCCESS";
// try {
// System.out.println("**************** INside Database UpdateProfile
// *************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
// /* UPDATE activesessions
// Set isActive='N', logoutNanoTime='12'
// where accessKey='5ae3206a-ecc1-484b-a5f6-2d0bd4c32646'; */
// String sqlStatement = "UPDATE profile Set hight='" + profile.get_hight()
// + "' ,weight='" + profile.get_weight()
// + "' ,address='" + profile.get_address()
// + "' ,phone='" + profile.get_phone()
// + "' ,emergency_contact='" + profile.get_emergency_contact()
// + "' ,relationship='" + profile.get_relationship()
// + "' ,blood_type='" + profile.getblood_type()
// + "' ,gender='" + profile.getgender()
// + "' ,ethinicity='" + profile.getethinicity()
// + "' ,languagetype='" + profile.getlanguage()
// + "',Birthday='" + profile.getDateOfBirth() + "' WHERE uer_id='" +
// String.valueOf(profile.get_id()) + "'";
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
// statement.close();
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// if (connection != null) {
// try {
// connection.close();
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// }
// return returnStr;
// }
//
//
// public String CreateProfile(Profile profile )throws InstantiationException,
// IllegalAccessException {
//
// String returnStr="SUCCESS";
// try {
// System.out.println("**************** INside Database profile *************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
// String sqlStatement = "INSERT INTO profile" + "(uer_id , hight , weight ,
// address , phone ,emergency_contact , " +
// "relationship, blood_type ,gender , ethinicity ,languagetype , Birthday)" +
// "values(" + "'" + profile.get_id() + "'" +
// ", '" + profile.get_hight() + "'" + ",'" + profile.get_weight() +"'" + ",'" +
// profile.get_address() +"'" + ",'"
// + profile.get_phone() +"'" + ",'" + profile.get_emergency_contact() +"'" +
// ",'" + profile.get_relationship() +"'"
// + ",'" + profile.getblood_type()+"'" + ",'" + profile.getgender() +"'" + ",'"
// + profile.getethinicity() +"'"
// + ",'" + profile.getlanguage() +"'" + ",'" + profile.getDateOfBirth() + "')";
//
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
// statement.close();
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// if (connection != null) {
// try {
// connection.close();
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// }
// return returnStr;
// }
//
//
//
// public String CreateMedicalHistory(MedicalHistoryRecord MHrecord )throws
// InstantiationException, IllegalAccessException {
//
// String returnStr="SUCCESS";
// try {
//
// System.out.println("**************** INside Database MedicalHistoryRecord
// *************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
//
// String sqlStatement = "INSERT INTO MedicalHistoryRecord" +
// "(uer_id,doc_visit_date,doc_name,primary_doc,mode_of_visit,body_weight,blood_presure_systolic,blood_presure_diastolic,temperature,prescribed_medicaltest_drugs,comments_from_doc
// )" + "values(" + "'" + MHrecord.get_id() + "'" + ", '" +
// MHrecord.get_doc_visit_date() + "'" + ",'" + MHrecord.get_doc_name() +"'" +
// ",'" + MHrecord.get_primary_doc() +"'" + ",'" + MHrecord.get_mode_of_visit()
// +"'" + ",'" + MHrecord.get_body_weight() +"'" + ",'" +
// MHrecord.get_blood_presure_systolic() +"'" + ",'" +
// MHrecord.get_blood_presure_diastolic() +"'" + ",'" +
// MHrecord.get_temperature()+"'" + ",'" +
// MHrecord.get_prescribed_medicaltest_drugs() +"'" + ",'" +
// MHrecord.get_comments_from_doc() + "')";
//
//
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
// }
//
//
// /* delete medical history record
// *
// */
// public boolean deleteMedicalHistoryRecord(int medicalId ) throws
// InstantiationException, IllegalAccessException {
//
// boolean result = false;
// try {
// connection = getConnection();
// statement = connection.createStatement();
// String sqlStatement = "delete FROM MedicalHistoryRecord WHERE
// medicalhistoryIds ='" + medicalId + "'";
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
// result = true;
// return result;
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// }
// return result;
// }
//
//
// public String CreateMedications(Medications medications )throws
// InstantiationException, IllegalAccessException {
//
// String returnStr="SUCCESS";
// try {
//
// System.out.println("**************** INside Database Medications
// *************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
//
//
// String sqlStatement = "INSERT INTO Medications" + "(
// uer_id,date_of_medication,type_of_medication,name_of_mediaction,instructions,dose_qantity,rate_quantity,prescriber_name
// )" + "values(" + "'" + medications.get_id() + "'" + ", '" +
// medications.get_date_of_medication() + "'" + ",'" +
// medications.get_type_of_medication() +"'" + ",'" +
// medications.get_name_of_mediaction() +"'" + ",'" +
// medications.get_instructions() +"'" + ",'" + medications.get_dose_qantity()
// +"'" + ",'" + medications.get_rate_quantity() +"'" + ",'" +
// medications.get_prescriber_name()+ "')";
//
//
//
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
// }
//
//
//
//
// public String CreateMedicalTestResults(MedicalTestResults testresult )throws
// InstantiationException, IllegalAccessException {
//
// String returnStr="SUCCESS";
// try {
//
// System.out.println("**************** INside Database MedicalTestResults
// *************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
//
//
// String sqlStatement = "INSERT INTO MedicalTestResults" +
// "(uer_id,date_of_test,test_results,diagnostic_center_name)" + "values(" + "'"
// + testresult.get_id() + "'" + ", '" + testresult.get_date_of_test() + "'" +
// ",'" + testresult.get_test_results() +"'" + ",'" +
// testresult.get_diagnostic_center_name() + "')";
//
//
//
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
// }
//
//
//
//
//
// public String CreateVaccinationImmunization(VaccinationImmunizationRecord
// result )throws InstantiationException, IllegalAccessException {
//
// String returnStr="SUCCESS";
// try {
//
// System.out.println("**************** INside Database VaccinationImmunization
// *************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
// String sqlStatement = "INSERT INTO VaccinationImmunization" +
// "(uer_id,VaccinationImmunization_date,VaccinationImmunization_name,VaccinationImmunization_type,VaccinationImmunization_dose_qantity)"
// + "values(" + "'" + result.get_id() + "'" + ", '" +
// result.get_VaccinationImmunization_date() + "'" + ",'" +
// result.get_VaccinationImmunization_name() +"'" + ",'" +
// result.get_VaccinationImmunization_type() +"'" + ",'" +
// result.get_VaccinationImmunization_dose_qantity() + "')";
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
// }
//
//
//
// public String CreateAllergies(Allergies allergy )throws
// InstantiationException, IllegalAccessException {
//
// String returnStr="SUCCESS";
// try {
//
// System.out.println("**************** INside Database allergy *************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
//
// String sqlStatement = "INSERT INTO allergy" +
// "(uer_id,allergy_date,allergy_name,reaction,severity)" + "values(" + "'" +
// allergy.get_id() + "'" + ", '" +allergy.get_allergy_date() + "'" + ", '"
// +allergy.get_allergy_name() + "'" + ",'" + allergy.get_reaction() +"'" + ",'"
// + allergy.get_severity() + "')";
//
//
//
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
// }
//
//
//// Get Medical History Records
// public JSONObject getMedicalHistory(int id) throws InstantiationException,
// IllegalAccessException, JSONException
//
// {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
//
// try {
//
//
// returnJson = new JSONObject();
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM MedicalHistoryRecord WHERE uer_id = ? ") ;
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery() ;
// //int resultSetSize = 0;
//
//
//
//
// while(rs.next()){
// //Retrieve by column name
// String doc_visit_date = rs.getString("doc_visit_date");
//
// String doc_name = rs.getString("doc_name");
//
// String primary_doc = rs.getString("primary_doc");
//
// String mode_of_visit = rs.getString("mode_of_visit");
//
// String body_weight = rs.getString("body_weight");
//
// String blood_presure_systolic = rs.getString("blood_presure_systolic");
//
// String blood_presure_diastolic = rs.getString("blood_presure_diastolic");
//
// String temperature = rs.getString("temperature");
//
// String prescribed_medicaltest_drugs =
// rs.getString("prescribed_medicaltest_drugs");
//
// String comments_from_doc = rs.getString("comments_from_doc");
//
// returnJson.put("doc_visit_date", doc_visit_date);
// returnJson.put("doc_name", doc_name);
// returnJson.put("primary_doc", primary_doc);
// returnJson.put("mode_of_visit", mode_of_visit);
// returnJson.put("body_weight", body_weight);
// returnJson.put("blood_presure_systolic", blood_presure_systolic);
// returnJson.put("blood_presure_diastolic", blood_presure_diastolic);
// returnJson.put("temperature", temperature);
// returnJson.put("prescribed_medicaltest_drugs", prescribed_medicaltest_drugs);
// returnJson.put("comments_from_doc", comments_from_doc);
//
//
// //Display values
// System.out.print("visit_date: " + doc_visit_date);
// System.out.print(", doc_name: " + doc_name);
// System.out.print(", primary_doc: " + primary_doc);
// System.out.println(", mode_of_visit: " + mode_of_visit);
//
// returnStr="SUCCESS";
// returnJson.put("status",returnStr);
// }
// rs.close();
//
//
// } catch (SQLException e) {
//
// returnStr=e.getMessage();
//
// returnJson.put("status",returnStr);
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return returnJson ;
// }
//
//
//
//// Get Allergy Records
// public JSONArray getAllergy(int id) throws InstantiationException,
// IllegalAccessException, JSONException
//
// {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray allergyRecordsArray =null;
// try {
// allergyRecordsArray = new JSONArray();
// returnJson = new JSONObject();
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM allergy WHERE uer_id = ? ") ;
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery() ;
// //int resultSetSize = 0;
//
//
// int i=0;
// while(rs.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
// //Retrieve by column name
// String allergy_date = rs.getString("allergy_date") ;
// String allergy_name = rs.getString("allergy_name") ;
// String reaction = rs.getString("reaction");
// String severity = rs.getString("severity") ;
// int allergyId = rs.getInt("allergyIds");
//
// //Put values into the JSON object
// tmpeturnJson.put("recordID", String.valueOf(allergyId));
// tmpeturnJson.put("allergy_date", allergy_date);
// tmpeturnJson.put("allergy_name", allergy_name);
// tmpeturnJson.put("reaction", reaction);
// tmpeturnJson.put("severity", severity); //Display values
// System.out.print("allergy_date: " + allergy_date);
// System.out.print(", allergy_name: " + allergy_name);
// System.out.print(", reaction: " + reaction);
// System.out.println(",severity: " + severity);
// returnStr="SUCCESS";
// tmpeturnJson.put("status",returnStr);
// allergyRecordsArray.put(i,tmpeturnJson);
// i++;
//
// }
// rs.close();
//
//
// } catch (SQLException e) {
//
// returnStr=e.getMessage();
//
// returnJson.put("status",returnStr);
// allergyRecordsArray.put(returnJson);
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return allergyRecordsArray;
// }
//
//// Get PatientProfile Records
// public JSONObject getPatientProfile(int id) throws InstantiationException,
// IllegalAccessException, JSONException
//
// {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
//
// try {
//
// returnJson = new JSONObject();
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM users,profile WHERE users.uer_id =profile.uer_id and
// users.uer_id = ? ") ;
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery() ;
// //int resultSetSize = 0;
//
//
// int i=0;
// while(rs.next()){
//
// //Retrieve by column name
// String user_firstname = rs.getString("user_firstname") ;
// String user_lastname = rs.getString("user_lastname") ;
// String height = rs.getString("hight") ;
// String weight = rs.getString("weight") ;
// String address = rs.getString("address") ;
// String phone = rs.getString("phone") ;
// String emergency_contact = rs.getString("emergency_contact") ;
// String relationship = rs.getString("relationship") ;
// String blood_type = rs.getString("blood_type") ;
// String gender = rs.getString("gender") ;
// String ethinicity = rs.getString("ethinicity") ;
// String languagetype = rs.getString("languagetype") ;
// String birthday = rs.getString("birthday") ;
//
//
// //Put values into the JSON object
// returnJson.put("user_firstname", user_firstname);
// returnJson.put("user_lastname", user_lastname);
// returnJson.put("height", height);
// returnJson.put("address", address);
// returnJson.put("phone", phone);
// returnJson.put("emergency_contact", emergency_contact);
// returnJson.put("relationship", relationship);
// returnJson.put("blood_type", blood_type);
// returnJson.put("gender", gender);
// returnJson.put("ethinicity", ethinicity);
// returnJson.put("languagetype", languagetype);
// returnJson.put("birthday", birthday);
// returnJson.put("weight", weight); //Display values
//
// System.out.print("user_firstname: " + user_firstname);
// System.out.print(", user_lastname: " + user_lastname);
// System.out.print(", ethinicity: " + ethinicity);
// System.out.println(",birthday: " + birthday);
// returnStr="SUCCESS";
// returnJson.put("status",returnStr);
//
// i++;
//
// }
// rs.close();
//
//
// } catch (SQLException e) {
//
// returnStr=e.getMessage();
//
// returnJson.put("status",returnStr);
//
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return returnJson;
// }
//
//
//
//// Get Allergy Records
// public JSONArray getPatientFullRecord(int id) throws InstantiationException,
// IllegalAccessException, JSONException, ParseException
//
// {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray medicalRecordsArray =null;
// try {
// DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
// ArrayList datesSortedList=null;
// medicalRecordsArray = new JSONArray();
// returnJson = new JSONObject();
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// // now we have sorted array list - loop through the list and get each reacord
// for the date
// connection = getConnection();
// // get sorted array list
// datesSortedList = getSortedDatesList(id);
// System.out.println("**************getPatientFullRecord***********");
//
// for(int j=0; j<datesSortedList.size(); j++)
// {
// System.out.println(datesSortedList.get(j));
//
// }
//
// System.out.println("after getSortedDatesList");
//
//
// for(int dtRecordIndex=0; dtRecordIndex<datesSortedList.size();
// dtRecordIndex++)
// {
// JSONArray tmpmedicalHistoryRecordsArray =null;
// System.out.println(datesSortedList.get(dtRecordIndex));
// String medical_record_date = (String) datesSortedList.get(dtRecordIndex);
// System.out.println("medical_record_date=" + medical_record_date);
// System.out.println("Before getMedicalHistoryRecords");
// tmpmedicalHistoryRecordsArray =
// getMedicalHistoryRecords(id,medical_record_date);
//
// if(tmpmedicalHistoryRecordsArray.length() > 0)
// {
// // got JSON objects
// // Copy it to main one
// for(int i = 0; i < tmpmedicalHistoryRecordsArray.length(); i++)
// {
// JSONObject tmpeturnJson=tmpmedicalHistoryRecordsArray.getJSONObject(i);
// System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
// System.out.println(tmpeturnJson);
// medicalRecordsArray.put(tmpeturnJson);
// }
// }
// // Get Medications (if any...)
// tmpmedicalHistoryRecordsArray = getMedicationRecords(id,medical_record_date);
//
// if(tmpmedicalHistoryRecordsArray.length() > 0)
// {
// // got JSON objects
// // Copy it to main one
// for(int i = 0; i < tmpmedicalHistoryRecordsArray.length(); i++)
// {
// JSONObject tmpeturnJson=tmpmedicalHistoryRecordsArray.getJSONObject(i);
// System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
// medicalRecordsArray.put(tmpeturnJson);
// }
// }
// // Get getMedicalTestResultRecords
// tmpmedicalHistoryRecordsArray =
// getMedicalTestResultRecords(id,medical_record_date);
// if(tmpmedicalHistoryRecordsArray.length() > 0)
// {
// // got JSON objects
// // Copy it to main one
// for(int i = 0; i < tmpmedicalHistoryRecordsArray.length(); i++)
// {
// JSONObject tmpeturnJson=tmpmedicalHistoryRecordsArray.getJSONObject(i);
// System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
// medicalRecordsArray.put(tmpeturnJson);
// }
// }
// //getVaccinationImmunizationRecords
// tmpmedicalHistoryRecordsArray =
// getVaccinationImmunizationRecords(id,medical_record_date);
// if(tmpmedicalHistoryRecordsArray.length() > 0)
// {
// // got JSON objects
// // Copy it to main one
// for(int i = 0; i < tmpmedicalHistoryRecordsArray.length(); i++)
// {
// JSONObject tmpeturnJson=tmpmedicalHistoryRecordsArray.getJSONObject(i);
// System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
// medicalRecordsArray.put(tmpeturnJson);
// }
// }
// }
//
// }
// catch (Exception e)
// {
// System.out.println (e);
//
// returnStr=e.getMessage();
//
// returnJson.put("status",returnStr);
// medicalRecordsArray.put(returnJson);
//
// }
// finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
// return medicalRecordsArray;
// }
//
//
//// Get VaccinationImmunization
//
// public JSONArray getVaccinationImmunizationRecords(int id, String strDate)
// throws InstantiationException, IllegalAccessException, JSONException,
// ParseException
//
// {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray VaccinationImmunizationRecordsArray = null;
// VaccinationImmunizationRecordsArray = new JSONArray();
// try {
// connection = getConnection();
//
// String VaccinationImmunization_date=null;
// String VaccinationImmunization_name=null;
// String VaccinationImmunization_type=null;
// String VaccinationImmunization_dose_qantity=null;
// String record_type=null;
// int VaccinationImmunizationIds=0;
// returnJson = new JSONObject();
// System.out.println("********** At Database level
// getVaccinationImmunizationRecords............***********");
// System.out.println("Userid=" + id);
// connection = getConnection();
//
// PreparedStatement psVaccinationImmunization = (PreparedStatement)
// connection.prepareStatement( "select * from VaccinationImmunization where
// uer_id =? And VaccinationImmunization_date =?") ;
// psVaccinationImmunization.setInt(1, id);
// psVaccinationImmunization.setString(2,strDate);
// ResultSet rsVaccinationImmunization =
// psVaccinationImmunization.executeQuery() ;
//
// int i=0;
// // it may not be possible to have records for the given date
// while(rsVaccinationImmunization.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
// VaccinationImmunization_date =
// rsVaccinationImmunization.getString("VaccinationImmunization_date");
// VaccinationImmunization_name =
// rsVaccinationImmunization.getString("VaccinationImmunization_name");
// VaccinationImmunization_type =
// rsVaccinationImmunization.getString("VaccinationImmunization_type");
// VaccinationImmunization_dose_qantity =
// rsVaccinationImmunization.getString("VaccinationImmunization_dose_qantity");
// VaccinationImmunizationIds =
// rsVaccinationImmunization.getInt("VaccinationImmunizationIds");
// record_type="VaccinationImmunization";
// tmpeturnJson.put("VaccinationImmunization_date",
// VaccinationImmunization_date);
// tmpeturnJson.put("VaccinationImmunization_name", VaccinationImmunization_name
// );
// tmpeturnJson.put("VaccinationImmunization_type", VaccinationImmunization_type
// );
// tmpeturnJson.put("VaccinationImmunization_dose_qantity",
// VaccinationImmunization_dose_qantity);
// tmpeturnJson.put("record_type", record_type);
// tmpeturnJson.put("recordID", String.valueOf(VaccinationImmunizationIds));
//
// returnStr="SUCCESS";
// System.out.println(tmpeturnJson);
// tmpeturnJson.put("status",returnStr);
// VaccinationImmunizationRecordsArray.put(i,tmpeturnJson);
// }
// rsVaccinationImmunization.close();
// }
// catch (SQLException e)
// {
// returnStr=e.getMessage();
// returnJson.put("status",returnStr);
// VaccinationImmunizationRecordsArray.put(returnJson);
// }
// finally
// {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// }
// return VaccinationImmunizationRecordsArray;
// }
//
//
//// Get MedicalTestResults
// public JSONArray getMedicalTestResultRecords(int id, String strDate) throws
// InstantiationException, IllegalAccessException, JSONException, ParseException
//
// {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray medicalTestResultsRecordsArray = null;
// medicalTestResultsRecordsArray = new JSONArray();
// try {
// connection = getConnection();
//
// String date_of_test=null;
// String test_results=null;
// String diagnostic_center_name=null;
// String record_type=null;
// int medicaltestresultsIds=0;
// returnJson = new JSONObject();
// System.out.println("********** At Database level
// getMedicalTestResultRecords............***********");
// System.out.println("Userid=" + id);
// connection = getConnection();
//
// PreparedStatement psMedicalTestResult = (PreparedStatement)
// connection.prepareStatement( "select * from MedicalTestResults where uer_id
// =? And date_of_test =?") ;
// psMedicalTestResult.setInt(1, id);
// psMedicalTestResult.setString(2,strDate);
// ResultSet rsMedicalTestResult = psMedicalTestResult.executeQuery() ;
//
// int i=0;
// // it may not be possible to have records for the given date
// while(rsMedicalTestResult.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
// // Test results
// date_of_test = rsMedicalTestResult.getString("date_of_test") ;
// test_results = rsMedicalTestResult.getString("test_results") ;
// diagnostic_center_name =
// rsMedicalTestResult.getString("diagnostic_center_name");
// medicaltestresultsIds = rsMedicalTestResult.getInt("medicaltestresultsIds");
//
// record_type="MedicalTestResults";
// tmpeturnJson.put("date_of_test", date_of_test);
// tmpeturnJson.put("test_results", test_results);
// tmpeturnJson.put("diagnostic_center_name", diagnostic_center_name);
// tmpeturnJson.put("recordID", String.valueOf(medicaltestresultsIds));
// tmpeturnJson.put("record_type", record_type);
// returnStr="SUCCESS";
// System.out.println(tmpeturnJson);
// tmpeturnJson.put("status",returnStr);
// medicalTestResultsRecordsArray.put(i,tmpeturnJson);
// }
// rsMedicalTestResult.close();
// }
// catch (SQLException e)
// {
// returnStr=e.getMessage();
// returnJson.put("status",returnStr);
// medicalTestResultsRecordsArray.put(returnJson);
// }
// finally
// {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// }
// return medicalTestResultsRecordsArray;
// }
//
//// Get Medical History Records
// public JSONArray getMedicalHistoryRecords(int id, String strDate) throws
// InstantiationException, IllegalAccessException, JSONException, ParseException
//
// {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray medicalHistoryRecordsArray = null;
// medicalHistoryRecordsArray = new JSONArray();
// try {
// connection = getConnection();
//
// String doc_visit_date=null;
// String doc_name=null;
// String primary_doc=null;
// String mode_of_visit=null;
// String body_weight=null;
// String blood_presure_systolic=null;
// String blood_presure_diastolic=null;
// String temperature=null;
// String prescribed_medicaltest_drugs=null;
// String comments_from_doc=null;
// String record_type=null;
//
// returnJson = new JSONObject();
// System.out.println("********** At Database level
// getMedicalHistoryRecords............***********");
// System.out.println("Userid=" + id);
// connection = getConnection();
// PreparedStatement psMedicalHistoryRecord = (PreparedStatement)
// connection.prepareStatement( "select * from MedicalHistoryRecord where uer_id
// =? And doc_visit_date =?") ;
// psMedicalHistoryRecord.setInt(1, id);
// psMedicalHistoryRecord.setString(2,strDate);
// ResultSet rsMedicalHistoryRecord = psMedicalHistoryRecord.executeQuery() ;
// int i=0;
// int medicalhistoryIds=0;
// // it may not be possible to have records for the given date
// while(rsMedicalHistoryRecord.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
// doc_visit_date = rsMedicalHistoryRecord.getString("doc_visit_date");
// doc_name = rsMedicalHistoryRecord.getString("doc_name");
// primary_doc = rsMedicalHistoryRecord.getString("primary_doc");
// mode_of_visit = rsMedicalHistoryRecord.getString("mode_of_visit");
// body_weight = rsMedicalHistoryRecord.getString("body_weight");
// blood_presure_systolic =
// rsMedicalHistoryRecord.getString("blood_presure_systolic");
// blood_presure_diastolic =
// rsMedicalHistoryRecord.getString("blood_presure_diastolic");
// temperature = rsMedicalHistoryRecord.getString("temperature");
// prescribed_medicaltest_drugs =
// rsMedicalHistoryRecord.getString("prescribed_medicaltest_drugs");
// comments_from_doc = rsMedicalHistoryRecord.getString("comments_from_doc");
// medicalhistoryIds = rsMedicalHistoryRecord.getInt("medicalhistoryIds");
//
// //Put values into the JSON object
//
//
// record_type="MedicalHistory";
// tmpeturnJson.put("recordID", String.valueOf(medicalhistoryIds));
// tmpeturnJson.put("doc_visit_date", doc_visit_date);
// tmpeturnJson.put("doc_name", doc_name);
// tmpeturnJson.put("primary_doc", primary_doc);
// tmpeturnJson.put("mode_of_visit",mode_of_visit );
// tmpeturnJson.put("body_weight",body_weight );
// tmpeturnJson.put("blood_presure_systolic", blood_presure_systolic);
// tmpeturnJson.put("blood_presure_diastolic", blood_presure_diastolic);
// tmpeturnJson.put("temperature", temperature);
// tmpeturnJson.put("prescribed_medicaltest_drugs",
// prescribed_medicaltest_drugs);
// tmpeturnJson.put("comments_from_doc",comments_from_doc );
// tmpeturnJson.put("record_type", record_type);
// returnStr="SUCCESS";
// System.out.println(tmpeturnJson);
// tmpeturnJson.put("status",returnStr);
// medicalHistoryRecordsArray.put(i,tmpeturnJson);
// }
// rsMedicalHistoryRecord.close();
// }
// catch (SQLException e)
// {
// returnStr=e.getMessage();
// returnJson.put("status",returnStr);
// medicalHistoryRecordsArray.put(returnJson);
// }
// finally
// {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// }
// return medicalHistoryRecordsArray;
// }
//
//
//// Get Medications
//
// public JSONArray getMedicationRecords(int id, String strDate) throws
// InstantiationException, IllegalAccessException, JSONException, ParseException
//
// {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray medicationRecordsArray = null;
// medicationRecordsArray = new JSONArray();
// try {
// connection = getConnection();
//
// String date_of_medication=null;
// String type_of_medication=null;
// String name_of_mediaction=null;
// String instructions =null;
// String dose_qantity=null;
// String rate_quantity=null;
// String prescriber_name=null;
// String record_type=null;
// int medicationsIds=0;
// returnJson = new JSONObject();
// System.out.println("********** At Database level
// getMedicationsRecord............***********");
// System.out.println("Userid=" + id);
// connection = getConnection();
//
// PreparedStatement psMedications = (PreparedStatement)
// connection.prepareStatement( "select * from Medications where uer_id =? And
// date_of_medication =?") ;
// psMedications.setInt(1, id);
// psMedications.setString(2,strDate);
// ResultSet rsMedications = psMedications.executeQuery() ;
//
// int i=0;
// // it may not be possible to have records for the given date
// while(rsMedications.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
// date_of_medication = rsMedications.getString("date_of_medication");
// type_of_medication = rsMedications.getString("type_of_medication");
// name_of_mediaction = rsMedications.getString("name_of_mediaction");
// instructions = rsMedications.getString("instructions");
// dose_qantity = rsMedications.getString("dose_qantity");
// rate_quantity = rsMedications.getString("rate_quantity");
// prescriber_name= rsMedications.getString("prescriber_name");
// medicationsIds = rsMedications.getInt("medicationsIds");
// record_type="Medications";
// tmpeturnJson.put("date_of_medication", date_of_medication);
// tmpeturnJson.put("type_of_medication", type_of_medication);
// tmpeturnJson.put("name_of_mediaction", name_of_mediaction);
// tmpeturnJson.put("instructions",instructions );
// tmpeturnJson.put("dose_qantity", dose_qantity);
// tmpeturnJson.put("rate_quantity", rate_quantity);
// tmpeturnJson.put("prescriber_name", prescriber_name);
// tmpeturnJson.put("recordID", String.valueOf(medicationsIds));
//
// tmpeturnJson.put("record_type", record_type);
// returnStr="SUCCESS";
// System.out.println(tmpeturnJson);
// tmpeturnJson.put("status",returnStr);
// medicationRecordsArray.put(i,tmpeturnJson);
// }
// rsMedications.close();
// }
// catch (SQLException e)
// {
// returnStr=e.getMessage();
// returnJson.put("status",returnStr);
// medicationRecordsArray.put(returnJson);
// }
// finally
// {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// }
// return medicationRecordsArray;
// }
//
//
// public ArrayList getSortedDatesList(int id) throws InstantiationException,
// IllegalAccessException, JSONException, ParseException
//
// {
// ArrayList sortedDatesList = new ArrayList();
// ArrayList tmpsortedDatesList = new ArrayList();
// try {
//
// System.out.println("********** At Database level
// getSortedDatesList............***********");
// System.out.println("Userid=" + id);
// DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
// connection = getConnection();
// PreparedStatement psMedicalHistoryRecord = (PreparedStatement)
// connection.prepareStatement( "select * from MedicalHistoryRecord where uer_id
// =?") ;
// psMedicalHistoryRecord.setInt(1, id);
// ResultSet rsMedicalHistoryRecord = psMedicalHistoryRecord.executeQuery() ;
// int i=0;
// ArrayList arrayList = new ArrayList();
// String doc_visit_date=null;
//
// while(rsMedicalHistoryRecord.next()){
// doc_visit_date = rsMedicalHistoryRecord.getString("doc_visit_date");
// Date dt_visit_date = df.parse(doc_visit_date);
// System.out.println("MedicalHistoryRecord - doc_visit_date = " +
// doc_visit_date);
// arrayList.add(dt_visit_date);
// System.out.println(arrayList.size());
//
// }
//
//
// PreparedStatement psMedications = (PreparedStatement)
// connection.prepareStatement( "select * from Medications where uer_id =?");
// psMedications.setInt(1, id);
// ResultSet rsMedications = psMedications.executeQuery() ;
// i=0;
//
// while(rsMedications.next()){
// doc_visit_date = rsMedications.getString("date_of_medication");
// Date dt_visit_date = df.parse(doc_visit_date);
// System.out.println("Medications - date_of_medication = " + doc_visit_date);
// arrayList.add(dt_visit_date);
// System.out.println(arrayList.size());
//
// }
//
//
// PreparedStatement psMedicalTestResults = (PreparedStatement)
// connection.prepareStatement( "select * from MedicalTestResults where uer_id
// =?");
// psMedicalTestResults.setInt(1, id);
// ResultSet rsMedicalTestResults = psMedicalTestResults.executeQuery() ;
// i=0;
//
// while(rsMedicalTestResults.next()){
// doc_visit_date = rsMedicalTestResults.getString("date_of_test");
// Date dt_visit_date = df.parse(doc_visit_date);
// System.out.println("MedicalTestResults - date_of_test = " + doc_visit_date);
// arrayList.add(dt_visit_date);
// System.out.println(arrayList.size());
//
// }
//
//
// PreparedStatement psVaccinationImmunization = (PreparedStatement)
// connection.prepareStatement( "select * from VaccinationImmunization where
// uer_id =?");
// psVaccinationImmunization.setInt(1, id);
// ResultSet rsVaccinationImmunization =
// psVaccinationImmunization.executeQuery() ;
// i=0;
//
// while(rsVaccinationImmunization.next()){
// doc_visit_date =
// rsVaccinationImmunization.getString("VaccinationImmunization_date");
// Date dt_visit_date = df.parse(doc_visit_date);
// System.out.println("VaccinationImmunization - VaccinationImmunization_date =
// " + doc_visit_date);
//
// arrayList.add(dt_visit_date);
// }
//
// System.out.println(arrayList.size());
// System.out.println("ArrayList elements no order : ");
// for(int j=0; j<arrayList.size(); j++)
// System.out.println(arrayList.get(j));
//
// DateCompare compare = new DateCompare();
//
//
//
//
//
// Collections.sort(arrayList,compare);
//
//
// //display elements of ArrayList
// System.out.println("ArrayList elements after sorting in ascending order : ");
// for(int j=0; j<arrayList.size(); j++)
// System.out.println(arrayList.get(j));
//
// //display elements of ArrayList
// System.out.println("STRING ArrayList elements after sorting in ascending
// order : ");
// for(int j=0; j<arrayList.size(); j++)
// {
// sortedDatesList.add(df.format(arrayList.get(j)));
// System.out.println("After add into sortedDatesList" +
// df.format(arrayList.get(j)));
//
// }
//
//
// System.out.println("STRING ************** sortedDatesList elements after
// sorting in ascending order : ");
// for(int j=0; j<sortedDatesList.size(); j++)
// {
// System.out.println("After add into sortedDatesList" +
// sortedDatesList.get(j));
//
// }
//
//
// System.out.println("STRING ************** sortedDatesList elements after
// sorting in ascending order : ");
// for(int j=0; j<sortedDatesList.size(); j++)
// {
// System.out.println("After add into sortedDatesList" +
// sortedDatesList.get(j));
//
// }
//
//
// // Reverse sort - to display latest records...
// System.out.println("Reverse Sort ************** sortedDatesList elements
// after sorting in ascending order : ");
// for(int j=sortedDatesList.size()-1; j >= 0; j--)
// {
// System.out.println("^&**((" + sortedDatesList.get(j));
// tmpsortedDatesList.add(sortedDatesList.get(j));
// }
//
//
// rsVaccinationImmunization.close();
// rsMedicalTestResults.close();
// rsMedicalHistoryRecord.close();
// rsMedications.close();
// }
// catch (SQLException e)
// {
// }
// finally
// {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
// }
// return tmpsortedDatesList;
// }
//
//
//
// public JSONArray getBPPatientRecord( String strDate) throws
// InstantiationException, IllegalAccessException, JSONException, ParseException
//
// {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray medicationRecordsArray = null;
// medicationRecordsArray = new JSONArray();
// try {
//
//
// String doc_visit_date=null;
// String blood_presure_systolic=null;
// String blood_presure_diastolic=null;
// String user_firstname=null ;
// String address=null;
// String gender=null;
// String ethinicity=null;
// String birthday=null;
// String user_lastname =null ;
// String weight=null ;
// String record_type=null;
//
// DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//
//
//
// returnJson = new JSONObject();
// System.out.println("********** At Database level
// getBPPatientRecord............***********");
// System.out.println("incoming strDate=" + strDate);
// strDate = strDate.replaceAll("-", "/");
//
// System.out.println("Formatted strDate=" + strDate);
// connection = getConnection();
//
//
// /* select a.uer_id ,b.user_firstname , b.user_lastname , c.weight,
// a.doc_visit_date, a.blood_presure_systolic,a.blood_presure_diastolic
// from sanjeevani.medicalhistoryrecord a,sanjeevani.users b ,sanjeevani.profile
// c where a.uer_id = b.uer_id
// and a.uer_id = c.uer_id and (Str_to_Date(a.doc_visit_date,"%m/%d/%Y")) In (
// select (Str_to_Date(d.doc_visit_date,"%m/%d/%Y"))
// from sanjeevani.medicalhistoryrecord d where
// (Str_to_Date(d.doc_visit_date,"%m/%d/%Y")) BETWEEN
// (Str_to_Date('05/09/2013',"%m/%d/%Y") - interval 30 day ) and (Str_to_Date
// ('05/09/2013',"%m/%d/%Y")))
// and a.blood_presure_systolic > 140 and a.blood_presure_diastolic > 60;
// */
// String strSQL = "select b.user_firstname , b.user_lastname , c.weight,
// a.doc_visit_date, a.blood_presure_systolic,a.blood_presure_diastolic, " +
// " c.address,c.gender, c.ethinicity,c.Birthday" +
// " from medicalhistoryrecord a ,users b , profile c " +
// " where a.uer_id = b.uer_id and a.uer_id = c.uer_id and " +
// " (Str_to_Date(a.doc_visit_date,'%m/%d/%Y')) In ( " +
// " select (Str_to_Date(d.doc_visit_date,'%m/%d/%Y')) from medicalhistoryrecord
// d " +
// " where (Str_to_Date(d.doc_visit_date,'%m/%d/%Y')) BETWEEN
// ((Str_to_Date(?,'%m/%d/%Y')) - interval 30 day ) and (Str_to_Date
// (?,'%m/%d/%Y'))) " +
// " and a.blood_presure_systolic > 140 and a.blood_presure_diastolic > 60";
//
// System.out.println("strSQL=" + strSQL);
//
// PreparedStatement psBPPatientRecords = (PreparedStatement)
// connection.prepareStatement(strSQL) ;
// psBPPatientRecords.setString(1,strDate);
// psBPPatientRecords.setString(2,strDate);
//
// ResultSet rsBPPatientRecords = psBPPatientRecords.executeQuery() ;
//
// int i=0;
// // it may not be possible to have records for the given date
// while(rsBPPatientRecords.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
//
// doc_visit_date = rsBPPatientRecords.getString("doc_visit_date");
// Date dt_visit_date = df.parse(doc_visit_date);
// user_firstname = rsBPPatientRecords.getString("user_firstname");
// user_lastname = rsBPPatientRecords.getString("user_lastname");
// weight = rsBPPatientRecords.getString("weight");
// blood_presure_systolic =
// rsBPPatientRecords.getString("blood_presure_systolic");
// blood_presure_diastolic =
// rsBPPatientRecords.getString("blood_presure_diastolic");
// address=rsBPPatientRecords.getString("address");
// gender=rsBPPatientRecords.getString("gender");
// ethinicity=rsBPPatientRecords.getString("ethinicity");
// birthday=rsBPPatientRecords.getString("Birthday");
// record_type="BPPatientRecords";
// tmpeturnJson.put("address", address);
// tmpeturnJson.put("gender", gender);
// tmpeturnJson.put("ethinicity", ethinicity);
// tmpeturnJson.put("birthday", birthday);
//
// tmpeturnJson.put("user_firstname", user_firstname);
// tmpeturnJson.put("user_lastname", user_lastname);
// tmpeturnJson.put("weight", weight);
// tmpeturnJson.put("blood_presure_systolic",blood_presure_systolic );
// tmpeturnJson.put("blood_presure_diastolic", blood_presure_diastolic);
// tmpeturnJson.put("doc_visit_date", dt_visit_date);
//
//
// tmpeturnJson.put("record_type", record_type);
// returnStr="SUCCESS";
// System.out.println(tmpeturnJson);
// tmpeturnJson.put("status",returnStr);
// medicationRecordsArray.put(i,tmpeturnJson);
// i++ ;
// }
// rsBPPatientRecords.close();
// }
// catch (SQLException e)
// {
// returnStr=e.getMessage();
// returnJson.put("status",returnStr);
// medicationRecordsArray.put(returnJson);
// }
// finally
// {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// }
// return medicationRecordsArray;
// }
//
//
//
//// public boolean isSessionActive(String strSessionToken) throws
// InstantiationException, IllegalAccessException, JSONException
////
//// {
//// return true;
//// }
//
//
// // Check whether session is active or not
// public boolean isSessionActive(String strSessionToken) throws
// InstantiationException, IllegalAccessException, JSONException
//
// {
// boolean bSessionActive = false;
//
// try {
//
//
//
// System.out.println("********** At Database level........... isSessionActive
// .***********");
// System.out.println("strSessionToken=" + strSessionToken);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM activesessions WHERE accessKey = ? ") ;
// ps.setString(1, strSessionToken);
// ResultSet rs = ps.executeQuery();
//
// while(rs.next())
// {
// //Retrieve by column name
// String strIsActive = rs.getString("isActive");
// String strCreationNanoTime = rs.getString("creationNanoTime");
// System.out.println("strIsActive: " + strIsActive);
// System.out.println("strCreationNanoTime: " + strCreationNanoTime);
// if(strIsActive.compareToIgnoreCase("y") != 0)
// {
// System.out.println("Session is no longer active ....: ");
//
// // session is inactive
// return false;
// }
// // Seems like session is still active.
// // now, lets check lease of 15 minutes is complete or not
// long curNanoTime = System.nanoTime();
// System.out.println("curNanoTime: " + curNanoTime);
//
// long sessionCreationNanoTime = Long.parseLong(strCreationNanoTime);
//
//
//
// // Session is considered to be expired the difference between Current Time
// and Creation Time is greater than 15 minutes
//
// long elapsedTime = curNanoTime - sessionCreationNanoTime;
//
// System.out.println("elapsedTime: " + elapsedTime);
//
// double elapsedSeconds = (double)elapsedTime / 1000000000.0;
// System.out.println("elapsedSeconds: " + elapsedSeconds);
//
// if(elapsedSeconds > MAX_SESSION_ALLOWED_TIME) // 15 minutes = 15 * 60 = 900
// seconds
// {
// // session is inactive
//
//
// closeUserSession(strSessionToken,curNanoTime);
// return false;
// }
// System.out.println("Session is not elapsed....");
// }
// //Display values
// rs.close();
// bSessionActive = true;
// } catch (SQLException e) {
// bSessionActive = false;
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return bSessionActive;
// }
//
//
// // Check whether session is active or not
// public String fetchEMRN(String strSessionToken) throws
// InstantiationException, IllegalAccessException, JSONException
//
// {
// String strEMRN=null;
//
// try {
//
// System.out.println("********** At Database level........... fetchEMRN
// .***********");
// System.out.println("strSessionToken=" + strSessionToken);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM activesessions WHERE accessKey = ? ") ;
// ps.setString(1, strSessionToken);
// ResultSet rs = ps.executeQuery();
//
// while(rs.next())
// {
// //Retrieve by column name
// String strIsActive = rs.getString("isActive");
// strEMRN = rs.getString("uer_id");
// System.out.println("strEMRN: " + strEMRN);
// System.out.println("Session is not elapsed....");
// }
// //Display values
// rs.close();
//
// } catch (SQLException e) {
// strEMRN = null;
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return strEMRN;
// }
//
// public String CreateEmergencyRecords(EmergencyDetails result) throws
// InstantiationException, IllegalAccessException {
// // TODO Auto-generated method stub
// String returnStr="SUCCESS";
// try {
// System.out.println("************** Inside Emergency Details**************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
// String sqlStatement = "INSERT INTO EmergencyDetails" +
// "(uer_id,EmergencyContactName,EmergencyContactNumber,Allergies,Medication,Relationship,Blood_group)"
// + "values(" + "'" + result.getUer_id() + "'" + ", '" +
// result.getEmergencyContactName() + "'" + ",'" +
// result.getEmergencyContactNumber() +"'" + ",'" + result.getMedication() +"'"
// + ",'" + result.getRelationship() + "'"+", '" + result.getBlood_group() + "'"
// +", '" + result.getAllergies() + "')";
// System.out.println(sqlStatement) ;
// System.out.println(result.getMedication());
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
// }
//
// public JSONArray getEmergencyRecord(int id) throws InstantiationException,
// IllegalAccessException, JSONException {
//
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray EmergencyRecordsArray =null;
// try {
// EmergencyRecordsArray = new JSONArray();
// returnJson = new JSONObject();
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM EmergencyDetails WHERE uer_id = ? ") ;
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery() ;
// //int resultSetSize = 0;
//
// int i=0;
// while(rs.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
// //Retrieve by column name
// String EmergencyContactName = rs.getString("EmergencyContactName") ;
// String EmergencyContactNumber = rs.getString("EmergencyContactNumber") ;
// String Allergies = rs.getString("Allergies");
// String Medication = rs.getString("Medication") ;
// String Relationship = rs.getString("Relationship") ;
// String Blood_group = rs.getString("Blood_group") ;
//
//
// //Put values into the JSON object
// tmpeturnJson.put("EmergencyContactName", EmergencyContactName);
// tmpeturnJson.put("EmergencyContactNumber", EmergencyContactNumber);
// tmpeturnJson.put("Allergies", Allergies);
// tmpeturnJson.put("Medication", Medication);
// tmpeturnJson.put("Relationship", Relationship);
// tmpeturnJson.put("Blood_group", Blood_group);
// System.out.print("EmergencyContactName: " + EmergencyContactName);
// System.out.print(",EmergencyContactNumber: " + EmergencyContactNumber);
// System.out.print(", Allergies: " + Allergies);
// System.out.println(",Medication: " + Medication);
// System.out.print(", Relationship: " + Allergies);
// System.out.println(",Blood_group: " + Medication);
// returnStr="SUCCESS";
// tmpeturnJson.put("status",returnStr);
// EmergencyRecordsArray.put(i,tmpeturnJson);
// i++;
//
// }
// rs.close();
//
//
// } catch (SQLException e) {
//
// returnStr=e.getMessage();
//
// returnJson.put("status",returnStr);
// EmergencyRecordsArray.put(returnJson);
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return EmergencyRecordsArray;
// }
//
// public String CreateMedicationContacts(MedicalContacts medications) throws
// InstantiationException, IllegalAccessException {
// String returnStr="SUCCESS";
// try {
// System.out.println("************** Inside Emergency Details**************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
// String sqlStatement = "INSERT INTO MedicalContacts" +
// "(uer_id,Medical_contactName,Medical_email,Medical_Hospital_Details,Medical_Address,Medical_contactNumber)"
// + "values(" + "'" + medications.getUer_ID() + "'" + ", '" +
// medications.getMedical_contactName() + "'" + ",'" +
// medications.getMedical_email() +"'" + ",'" +
// medications.getMedical_Hospital_Details() +"'" + ",'" +
// medications.getMedical_Address()+"'" +", '" +
// medications.getMedical_contactNumber() + "')";
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
// }
//
// public JSONArray getMedicalContacts(int id) throws JSONException,
// InstantiationException, IllegalAccessException {
// // TODO Auto-generated method stub
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray allergyRecordsArray =null;
// try {
// allergyRecordsArray = new JSONArray();
// returnJson = new JSONObject();
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM MedicalContacts WHERE uer_id = ? ") ;
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery() ;
// //int resultSetSize = 0;
//
//
// int i=0;
// while(rs.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
// //Retrieve by column name
// String Medical_email = rs.getString("Medical_email") ;
// String Medical_contactName = rs.getString("Medical_contactName") ;
// String Medical_contactNumber = rs.getString("Medical_contactNumber");
// String Medical_Address = rs.getString("Medical_Address") ;
// String Medical_Hospital_Details = rs.getString("Medical_Hospital_Details");
// int Record_id = rs.getInt("Record_id");
//
// //Put values into the JSON object
// tmpeturnJson.put("recordID", String.valueOf(Record_id));
// tmpeturnJson.put("Medical_email", Medical_email);
// tmpeturnJson.put("Medical_contactName", Medical_contactName);
// tmpeturnJson.put("Medical_contactNumber", Medical_contactNumber);
// tmpeturnJson.put("Medical_Address", Medical_Address);
// tmpeturnJson.put("Medical_Hospital_Details", Medical_Hospital_Details);
//
// //Display values
// System.out.print("Medical_Hospital_Details: " + Medical_Hospital_Details);
// System.out.print(", Medical_Address: " + Medical_Address);
// System.out.print(", Medical_contactNumber: " + Medical_contactNumber);
// System.out.println(",Medical_contactName: " + Medical_contactName);
// System.out.println(",Medical_email: " + Medical_email);
//
// returnStr="SUCCESS";
// tmpeturnJson.put("status",returnStr);
// allergyRecordsArray.put(i,tmpeturnJson);
// i++;
//
// }
// rs.close();
//
//
// } catch (SQLException e) {
//
// returnStr=e.getMessage();
//
// returnJson.put("status",returnStr);
// allergyRecordsArray.put(returnJson);
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return allergyRecordsArray; }
//
// public String updateProfileImage(Profile imageInfo, int id) throws
// InstantiationException, IllegalAccessException {
// String returnStr="SUCCESS";
// try {
// System.out.println("************** Inside Emergency Details**************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
// String sqlStatement ="UPDATE profile SET
// ImageDocumentID='"+imageInfo.getImagedocumentID()+"' WHERE
// uer_id='"+imageInfo.get_id()+"'";
// System.out.println(sqlStatement) ;
// System.out.println(imageInfo.get_id());
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
// }
//
// public JSONArray getMedicationRecord(int id) throws InstantiationException,
// IllegalAccessException, JSONException {
//
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray MedicationRecordsArray =null;
// try {
// MedicationRecordsArray = new JSONArray();
// returnJson = new JSONObject();
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM Medications WHERE uer_id = ? ") ;
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery() ;
// //int resultSetSize = 0;
//
// int i=0;
// while(rs.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
// //Retrieve by column name
// String date_of_medication = rs.getString("date_of_medication") ;
// String type_of_medication = rs.getString("type_of_medication") ;
// String name_of_mediaction = rs.getString("name_of_mediaction");
// String instructions = rs.getString("instructions") ;
// String dose_qantity = rs.getString("dose_qantity") ;
// String rate_quantity = rs.getString("rate_quantity") ;
// String prescriber_name = rs.getString("prescriber_name") ;
// String medicationsIds = rs.getString("medicationsIds") ;
//
//
//
// //Put values into the JSON object
// tmpeturnJson.put("date_of_medication", date_of_medication);
// tmpeturnJson.put("type_of_medication", type_of_medication);
// tmpeturnJson.put("name_of_mediaction", name_of_mediaction);
// tmpeturnJson.put("dose_qantity", dose_qantity);
// tmpeturnJson.put("rate_quantity", rate_quantity);
// tmpeturnJson.put("prescriber_name", prescriber_name);
// System.out.print("date_of_medication: " + date_of_medication);
// System.out.print(",type_of_medication: " + type_of_medication);
// System.out.print(", name_of_mediaction: " + name_of_mediaction);
// System.out.println(",dose_qantity: " + dose_qantity);
// System.out.print(", rate_quantity: " + rate_quantity);
// System.out.println(",prescriber_name: " + prescriber_name);
// returnStr="SUCCESS";
// tmpeturnJson.put("status",returnStr);
// MedicationRecordsArray.put(i,tmpeturnJson);
// i++;
//
// }
// rs.close();
//
//
// } catch (SQLException e) {
//
// returnStr=e.getMessage();
//
// returnJson.put("status",returnStr);
// MedicationRecordsArray.put(returnJson);
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return MedicationRecordsArray;
// }
//
// public JSONArray getvaccinationimmunizationRecord(int id) throws
// JSONException, InstantiationException, IllegalAccessException {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray VaccinationimmunizationRecords =null;
// try {
// VaccinationimmunizationRecords = new JSONArray();
// returnJson = new JSONObject();
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM VaccinationImmunization WHERE uer_id = ? ") ;
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery() ;
// //int resultSetSize = 0;
//
// int i=0;
// while(rs.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
// //Retrieve by column name
// String VaccinationImmunization_date =
// rs.getString("VaccinationImmunization_date") ;
// String VaccinationImmunization_name =
// rs.getString("VaccinationImmunization_name") ;
// String VaccinationImmunization_type =
// rs.getString("VaccinationImmunization_type");
// String VaccinationImmunization_dose_qantity =
// rs.getString("VaccinationImmunization_dose_qantity") ;
// String VaccinationImmunizationIds =
// rs.getString("VaccinationImmunizationIds") ;
//
//
//
// //Put values into the JSON object
// tmpeturnJson.put("date_of_medication", VaccinationImmunization_date);
// tmpeturnJson.put("VaccinationImmunization_name",
// VaccinationImmunization_name);
// tmpeturnJson.put("VaccinationImmunization_type",
// VaccinationImmunization_type);
// tmpeturnJson.put("VaccinationImmunization_dose_qantity",
// VaccinationImmunization_dose_qantity);
// tmpeturnJson.put("VaccinationImmunizationIds", VaccinationImmunizationIds);
// //tmpeturnJson.put("prescriber_name", prescriber_name);
// System.out.print("date_of_medication: " + VaccinationImmunization_date);
// System.out.print(",VaccinationImmunization_name: " +
// VaccinationImmunization_name);
// System.out.print(", VaccinationImmunization_type: " +
// VaccinationImmunization_type);
// System.out.println(",VaccinationImmunization_dose_qantity: " +
// VaccinationImmunization_dose_qantity);
// System.out.print(", VaccinationImmunizationIds: " +
// VaccinationImmunizationIds);
// //System.out.println(",prescriber_name: " + prescriber_name);
// returnStr="SUCCESS";
// tmpeturnJson.put("status",returnStr);
// VaccinationimmunizationRecords.put(i,tmpeturnJson);
// i++;
//
// }
// rs.close();
//
//
// } catch (SQLException e) {
//
// returnStr=e.getMessage();
//
// returnJson.put("status",returnStr);
// VaccinationimmunizationRecords.put(returnJson);
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return VaccinationimmunizationRecords;
// }
//
// public String getdocumrntID(int id) throws InstantiationException,
// IllegalAccessException {
// // TODO Auto-generated method stub
// String returnStr="SUCCESS";
// String returnJson = null;
// String documentID =null;
// try {
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM profile WHERE uer_id = ?") ;
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery() ;
// //int resultSetSize = 0;
//
//
// while(rs.next()){
// //Retrieve by column name
// documentID = rs.getString("ImageDocumentID") ;
//
// System.out.println(", documentID: "+documentID);
//
//
// }
// rs.close();
//
//
// } catch (SQLException e) {
//
// returnStr=e.getMessage();
//
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return documentID;
// }
//
// public String CreateReminderDetails(ReminderDetails reminders) throws
// InstantiationException, IllegalAccessException {
// String returnStr="SUCCESS";
// try {
// System.out.println("************** Inside Emergency Details**************");
// // Get Connection
// connection = getConnection();
// // Prepare SQL Statement
// statement = connection.createStatement();
// String sqlStatement = "INSERT INTO ReminderDetails" +
// "(uer_id,reminders_Date,reminders_Time,reminders_DRname,reminders_Reason,reminders_Description)"
// + "values(" + "'" + reminders.getUer_ID() + "'" + ", '" +
// reminders.getReminders_Date() + "'" + ",'" + reminders.getReminders_Time()
// +"'" +", '" + reminders.getReminders_DRname() + "'" + ",'" +
// reminders.getReminders_Reason() +"'" + ",'" +
// reminders.getReminders_Description()+"')";
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
// } catch (SQLException e) {
// returnStr=e.getMessage();
//
// } finally {
//
// if (statement != null)
// {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
// return returnStr;
//
// }
//
// public JSONArray getRecordDetails(int id) throws InstantiationException,
// IllegalAccessException, JSONException {
// String returnStr="SUCCESS";
// JSONObject returnJson = null;
// JSONArray RecordsDetails =null;
// try {
// RecordsDetails = new JSONArray();
// returnJson = new JSONObject();
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM ReminderDetails WHERE uer_id = ? ") ;
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery() ;
// //int resultSetSize = 0;
//
// int i=0;
// while(rs.next()){
// JSONObject tmpeturnJson=null;
// tmpeturnJson = new JSONObject();
// //Retrieve by column name
// String reminders_Date = rs.getString("reminders_Date") ;
// String reminders_Time = rs.getString("reminders_Time") ;
// String reminders_DRname = rs.getString("reminders_DRname");
// String reminders_Reason = rs.getString("reminders_Reason") ;
// String reminders_Description = rs.getString("reminders_Description") ;
//
//
//
// //Put values into the JSON object
// tmpeturnJson.put("reminders_Date", reminders_Date);
// tmpeturnJson.put("reminders_Time", reminders_Time);
// tmpeturnJson.put("reminders_DRname", reminders_DRname);
// tmpeturnJson.put("reminders_Reason", reminders_Reason);
// tmpeturnJson.put("reminders_Description", reminders_Description);
// //tmpeturnJson.put("prescriber_name", prescriber_name);
// System.out.print("date_of_medication: " + reminders_Date);
// System.out.print(",VaccinationImmunization_name: " + reminders_Time);
// System.out.print(", VaccinationImmunization_type: " + reminders_DRname);
// System.out.println(",VaccinationImmunization_dose_qantity: " +
// reminders_Reason);
// System.out.print(", VaccinationImmunizationIds: " + reminders_Description);
// //System.out.println(",prescriber_name: " + prescriber_name);
// returnStr="SUCCESS";
// tmpeturnJson.put("status",returnStr);
// RecordsDetails.put(i,tmpeturnJson);
// i++;
//
// }
// rs.close();
//
//
// } catch (SQLException e) {
//
// returnStr=e.getMessage();
//
// returnJson.put("status",returnStr);
// RecordsDetails.put(returnJson);
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return RecordsDetails;
// }
//
// public boolean checkProfileStatus(int id) throws InstantiationException,
// IllegalAccessException {
// boolean returnStr=false;
//
// try {
//
// System.out.println("********** At Database level............***********");
// System.out.println("Userid=" + id);
//
// connection = getConnection();
// PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
// "SELECT * FROM profile WHERE uer_id = ?") ;
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery() ;
// //int resultSetSize = 0;
//
//
// int i=0;
// while(rs.next()){
// returnStr = true;
// }
// rs.close();
//
//
// } catch (SQLException e) {
//
// returnStr=false;
//
//
//
// } finally {
//
// // Check if connection is open, then, close it
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
// return returnStr;
// }
//
// }
//
// class DateCompare implements Comparator<Date> {
//
// public int compare(Date one, Date two){
//
//
// return one.compareTo(two);
//
//
// }
//
//
//
//
// }