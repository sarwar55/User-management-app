package org.sarwar.becreative.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = -8825010309076840323L;
	
	@Id
	@Column(name = "USER_ID")
	private UUID userId;
	
	@Pattern(regexp="^[A-Za-z]+$", message= "First Name should be only Alphabets!!")
	@NotNull
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Pattern(regexp="^[A-Za-z]+$", message= "Middle Name should be only Alphabets!!")
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Pattern(regexp="^[A-Za-z]+$", message= "Last Name should be only Alphabets!!")
	@NotNull
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@NotNull @Min(13) @Max(110)
	@Column(name = "AGE")
	private Integer age;
	
	@NotNull
	@Pattern(regexp="^[MF]$", message= "Gender Format is 'F' or 'M'!!")
	@Column(name = "GENDER")
	private String gender;
	
	@Pattern(regexp="(^$|[0-9]{10})", message= "Phone Number should be 10 Digit positive number!")
	@Column(name = "PHONE_NUMBER")
	@NotNull
	private String phoneNumber;
	
	@Size(max = 10)
	@Pattern(regexp="[0-9]+", message= "Zip Code can only contain numbers up-to 10 digits!!")
	@Column(name = "ZIP_CODE")
	private String zip;
	
	public User() {
		super();
	}
	public User(String firstName, String middleName, String lastName, Integer age, String gender,
			String phoneNumber, String zip) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.zip = zip;
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
