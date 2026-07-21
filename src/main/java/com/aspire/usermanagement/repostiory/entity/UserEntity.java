package com.aspire.usermanagement.repostiory.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name ="USER_TL")
public class UserEntity implements Serializable {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	
	private Long userId;
	@Column(name = " FIRST_NAME",length = 50, nullable = false)
	private String firstName;
	@Column(name = " LAST_NAME",length = 50, nullable = false)
	private String lastName;
	@Column(name = " EMAIL_ID",length = 50, nullable = false, unique = true)
	private String emailId;
	@Column(name = " PASSWORD",length = 10, nullable = false)
	private String passWord;
	@Column(name = "MOBILE_NUMBER",length =10, nullable =false )
	private String mobileNumber;
	@Column(name = "DATA_OF_BIRTH")
	private LocalDate dataofBirth;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public LocalDate getDataofBirth() {
		return dataofBirth;
	}
	public void setDataofBirth(LocalDate dataofBirth) {
		this.dataofBirth = dataofBirth;
	}
	

}
