package com.java.webapp.bean;

import java.util.Arrays;

public class StudentBean {
	
		private int studId;
		private String studName;
		private String studEmail;
		private double studFees;
		private String studGender;
		private String studAddress;

		public StudentBean() {
			super();
			// TODO Auto-generated constructor stub
		}

		public StudentBean(int studId, String studName, String studEmail, double studFees, String studGender,
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
			return "StudentBean [studId=" + studId + ", studName=" + studName + ", studEmail=" + studEmail
					+ ", studFees=" + studFees + ", studGender=" + studGender + ", studAddress=" + studAddress + "]";
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

		public void setStudAddress(String studAddress) {
			this.studAddress = studAddress;
		}
		
		
	}



