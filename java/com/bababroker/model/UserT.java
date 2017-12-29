package com.bababroker.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the USER_T database table.
 * 
 */
@Entity
@Table(name="USER_T")
@NamedQuery(name="UserT.findAll", query="SELECT u FROM UserT u")
public class UserT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=25)
	private String username;

	@Column(nullable=false, length=50)
	private String email;

	@Column(nullable=false, precision=1)
	private BigDecimal isadmin;

	@Column(nullable=false, length=25)
	private String password;

	public UserT() {
	}

	public UserT(String username, String email, BigDecimal isadmin,
			String password) {
		super();
		this.username = username;
		this.email = email;
		this.isadmin = isadmin;
		this.password = password;
	}



	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getIsadmin() {
		return this.isadmin;
	}

	public void setIsadmin(BigDecimal isadmin) {
		this.isadmin = isadmin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserT [username=");
		builder.append(username);
		builder.append(", email=");
		builder.append(email);
		builder.append(", isadmin=");
		builder.append(isadmin);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

	
}