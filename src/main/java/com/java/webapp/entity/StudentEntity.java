package com.java.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stud_info5")
public class StudentEntity {
@Id
	private int studId;
	private String studName;
	private String studEmail;
	private double studFees;
	private String studGender;
	private String studAddress;
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentEntity(int studId, String studName, String studEmail, double studFees, String studGender,
			String studAddress) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studEmail = studEmail;
		this.studFees = studFees;
		this.studGender = studGender;
		this.studAddress = studAddress;
	}
	@Override
	public String toString() {
		return "StudentEntity [studId=" + studId + ", studName=" + studName + ", studEmail=" + studEmail + ", studFees="
				+ studFees + ", studGender=" + studGender + ", studAddress1=" + studAddress + "]";
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudEmail() {
		return studEmail;
	}
	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}
	public double getStudFees() {
		return studFees;
	}
	public void setStudFees(double studFees) {
		this.studFees = studFees;
	}
	public String getStudGender() {
		return studGender;
	}
	public void setStudGender(String studGender) {
		this.studGender = studGender;
	}
	public String getStudAddress() {
		return studAddress;
	}
	public void setStudAddress(String studAddress1) {
		this.studAddress = studAddress1;
	}
	

}
