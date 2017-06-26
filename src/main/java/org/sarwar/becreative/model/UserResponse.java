package org.sarwar.becreative.model;

import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserResponse {
	
	private UUID userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer age;
	private String gender;
	private String phoneNumber;
	private String zip;
	
	public UserResponse() {
	}
	public UserResponse(String firstName, String lastName, Integer age, String gender,
			String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}
	public UUID getUserId() {
		return userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getZip() {
		return zip;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
