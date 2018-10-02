package com.sanjeevaniehr.user.registration.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/SV")
public interface SanveevaniServicesIn {

	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response Register(String jsonString) throws InstantiationException, IllegalAccessException;

	@Path("/forgotPassword/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response forgotPassword(@PathParam("email") String jsonString)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/changePassword/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response changePassword(String jsonString)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/forgotPasswordSequrityQuestionVefication/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response forgotPasswordSequrityQuestionVefication(String jsonString)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response Login(String jsonString) throws InstantiationException, IllegalAccessException;

	@Path("/activate/{sessionToken}")
	@GET
	// @Produces({ MediaType.APPLICATION_JSON })
	public Response activate(@PathParam("sessionToken") String jsonString)
			throws InstantiationException, IllegalAccessException, URISyntaxException;

	@Path("/TwoFactorAuthentication")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response TwoFactorAuthentication(String jsonString) throws InstantiationException, IllegalAccessException;

	@Path("/logout/{sessionToken}")
	@GET

	public Response logout(@PathParam("sessionToken") String uer_id)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/profile")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response CreateProfile(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/activateAccount")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response ActivateAccount(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/medicalhistory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response CreateMedicalHistory(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/Reminders")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response CreateReminderHistory(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/deleteallergyhistory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteallergyhistory(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/deletemedicalhistory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletemedicalhistory(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/deletemedicationhistory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletemedicationhistory(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/deletevaccinationhistory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletevaccinationhistory(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/updateallergydetail")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateallergydetail(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/updatemedicalrecord")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatemedicalrecord(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/updatemedicationrecord")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatemedicationrecord(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/updatetestresult")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatetestresult(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/mediaction")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response CreateMedication(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/medicalresult")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response CreateMedicalResult(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException;

	@Path("/allergy")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response Createallergy(String jsonString)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/profileimageServiceInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateUserInfo(String jsonString)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/vaccinationimmunization")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response CreateVaccinationImmunization(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/EmergencyDetails")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response CreateEmergencyDetailsRecord(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/GetImage/{sessionToken}")
	@GET
	@Produces("image/png")
	public Response GetImage(@PathParam("sessionToken") String uer_id)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/GetMedicalhistory/{uer_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetMedicalhistoryById(@PathParam("uer_id") String uer_id)
			throws InstantiationException, IllegalAccessException;

	@Path("/GetRecordDetails/{uer_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetRecordDetails(@PathParam("uer_id") String uer_id)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/vaccinationimmunizationRecords/{sessionToken}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetvaccinationimmunizationRecordsById(@PathParam("sessionToken") String uer_id)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/ShowMedicalContacts/{sessionToken}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetMedicalDetailsById(@PathParam("sessionToken") String uer_id)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/GetAllergy/{sessionToken}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAllergyById(@PathParam("sessionToken") String sessionToken)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/GetPatientProfile/{sessionToken}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetPatientProfile(@PathParam("sessionToken") String sessionToken)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/GetPatientFullRecord/{sessionToken}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetPatientFullRecord(@PathParam("sessionToken") String sessionToken)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/GetPatientFullRecordData/{sessionToken}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetPatientFullRecordData(@PathParam("sessionToken") String sessionToken)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/GetEmergencyRecords/{sessionToken}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetEmergencyRecords(@PathParam("sessionToken") String sessionToken)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/GetMedicationRecords/{sessionToken}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetMedicationRecords(@PathParam("sessionToken") String sessionToken)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/GetBPPatientRecord/{doc_visit_date}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetBPPatientRecord(@PathParam("doc_visit_date") String doc_visit_date)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/SVLifeCycle/{Keyword}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getData(@PathParam("Keyword") String Keyword)
			throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/MedicalDetails")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response CreateMedicalDetailsRecord(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException;

	@Path("/VoiceService")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public String VoiceService(String jsonString)
			throws InstantiationException, IllegalAccessException, ParseException, JSONException, SQLException;

	@Path("/GetVoiceServiceData")
	@GET
	public Response VoiceServiceData() throws InstantiationException, IllegalAccessException, JSONException;

	@Path("/test")
	@GET
	public String stub();

}
