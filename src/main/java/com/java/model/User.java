package com.java.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",updatable=false,nullable=false)
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Column(length = 20, unique = true)
	private String username;
	private String email;
	@Column(length = 12)
	private String password;
	private String captcha1;
	private String captcha2;
	public String getCaptcha1() {
		return captcha1;
	}
	public void setCaptcha1(String captcha1) {
		this.captcha1 = captcha1;
	}
	public String getCaptcha2() {
		return captcha2;
	}
	public void setCaptcha2(String captcha2) {
		this.captcha2 = captcha2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", captcha1=" + captcha1 + ", captcha2=" + captcha2 + "]";
	}
	
	
	
	
	
	
}