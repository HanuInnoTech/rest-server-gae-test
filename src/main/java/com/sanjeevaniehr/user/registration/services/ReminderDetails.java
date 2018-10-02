package com.sanjeevaniehr.user.registration.services;

public class ReminderDetails {
	private String reminders_Date = null;
	private String reminders_Time = null;
	private String reminders_DRname = null;
	private String reminders_Reason = null;
	private String reminders_Description = null;
	private int Uer_ID;

	public int getUer_ID() {
		return Uer_ID;
	}

	public void setUer_ID(int uer_ID) {
		Uer_ID = uer_ID;
	}

	public String getReminders_Date() {
		return reminders_Date;
	}

	public void setReminders_Date(String reminders_Date) {
		this.reminders_Date = reminders_Date;
	}

	public String getReminders_Time() {
		return reminders_Time;
	}

	public void setReminders_Time(String reminders_Time) {
		this.reminders_Time = reminders_Time;
	}

	public String getReminders_DRname() {
		return reminders_DRname;
	}

	public void setReminders_DRname(String reminders_DRname) {
		this.reminders_DRname = reminders_DRname;
	}

	public String getReminders_Reason() {
		return reminders_Reason;
	}

	public void setReminders_Reason(String reminders_Reason) {
		this.reminders_Reason = reminders_Reason;
	}

	public String getReminders_Description() {
		return reminders_Description;
	}

	public void setReminders_Description(String reminders_Description) {
		this.reminders_Description = reminders_Description;
	}

}
