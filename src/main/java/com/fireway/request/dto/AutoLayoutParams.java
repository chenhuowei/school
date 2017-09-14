package com.fireway.request.dto;

public class AutoLayoutParams {
	
	private String classWeek;
	private String classTime;
	private String teacherNum;
	private String classId;
	private String locationId;
	private String subjectCode;
	private String schoolYear;
	private String term;
	
	
	
	public String getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getClassWeek() {
		return classWeek;
	}
	public void setClassWeek(String classWeek) {
		this.classWeek = classWeek;
	}
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public AutoLayoutParams() {
		super();
		
	}
	public String getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}
	
	public AutoLayoutParams(String classWeek, String classTime, String teacherNum, String classId, String locationId,
			String subjectCode, String schoolYear, String term) {
		super();
		this.classWeek = classWeek;
		this.classTime = classTime;
		this.teacherNum = teacherNum;
		this.classId = classId;
		this.locationId = locationId;
		this.subjectCode = subjectCode;
		this.schoolYear = schoolYear;
		this.term = term;
	}
	
	
	
	
	

}
