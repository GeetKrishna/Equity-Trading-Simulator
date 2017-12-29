package com.bababroker.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the SECURITY_CONFIG_MAPPING database table.
 * 
 */
@Entity
@Table(name="SECURITY_CONFIG_MAPPING")
@NamedQuery(name="SecurityConfigMapping.findAll", query="SELECT s FROM SecurityConfigMapping s")
public class SecurityConfigMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String securitysymbol;

	private Timestamp datecreated;

	//bi-directional many-to-one association to ConfigurationInfo
	@ManyToOne
	@JoinColumn(name="CONFIGID", nullable=false)
	private ConfigurationInfo configurationInfo;

	//bi-directional one-to-one association to Security
	@OneToOne
	@JoinColumn(name="SECURITYSYMBOL", nullable=false, insertable=false, updatable=false)
	private Security security;

	public SecurityConfigMapping() {
	}

	public SecurityConfigMapping(String securitysymbol, Timestamp datecreated,
			ConfigurationInfo configurationInfo, Security security) {
		super();
		this.securitysymbol = securitysymbol;
		this.datecreated = datecreated;
		this.configurationInfo = configurationInfo;
		this.security = security;
	}



	public String getSecuritysymbol() {
		return this.securitysymbol;
	}

	public void setSecuritysymbol(String securitysymbol) {
		this.securitysymbol = securitysymbol;
	}

	public Timestamp getDatecreated() {
		return this.datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public ConfigurationInfo getConfigurationInfo() {
		return this.configurationInfo;
	}

	public void setConfigurationInfo(ConfigurationInfo configurationInfo) {
		this.configurationInfo = configurationInfo;
	}

	public Security getSecurity() {
		return this.security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

}