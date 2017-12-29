package com.bababroker.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CONFIGURATION_INFO database table.
 * 
 */
@Entity
@Table(name="CONFIGURATION_INFO")
@NamedQuery(name="ConfigurationInfo.findAll", query="SELECT c FROM ConfigurationInfo c")
public class ConfigurationInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONFIGURATION_INFO_CONFIGID_GENERATOR", sequenceName="SOMESEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONFIGURATION_INFO_CONFIGID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long configid;

	@Column(nullable=false)
	private BigDecimal maxnumexecutions;

	@Column(nullable=false)
	private BigDecimal maxpricespread;

	@Column(nullable=false)
	private BigDecimal maxtimebtwexecutions;

	@Column(nullable=false)
	private BigDecimal probpercentfullexec;

	//bi-directional many-to-one association to SecurityConfigMapping
	@OneToMany(mappedBy="configurationInfo")
	private List<SecurityConfigMapping> securityConfigMappings;

	public ConfigurationInfo() {
	}
	
	public ConfigurationInfo(BigDecimal maxnumexecutions,
			BigDecimal maxpricespread, BigDecimal maxtimebtwexecutions,
			BigDecimal probpercentfullexec,
			List<SecurityConfigMapping> securityConfigMappings) {
		super();
		this.maxnumexecutions = maxnumexecutions;
		this.maxpricespread = maxpricespread;
		this.maxtimebtwexecutions = maxtimebtwexecutions;
		this.probpercentfullexec = probpercentfullexec;
		this.securityConfigMappings = securityConfigMappings;
	}



	public long getConfigid() {
		return this.configid;
	}

	public void setConfigid(long configid) {
		this.configid = configid;
	}

	public BigDecimal getMaxnumexecutions() {
		return this.maxnumexecutions;
	}

	public void setMaxnumexecutions(BigDecimal maxnumexecutions) {
		this.maxnumexecutions = maxnumexecutions;
	}

	public BigDecimal getMaxpricespread() {
		return this.maxpricespread;
	}

	public void setMaxpricespread(BigDecimal maxpricespread) {
		this.maxpricespread = maxpricespread;
	}

	public BigDecimal getMaxtimebtwexecutions() {
		return this.maxtimebtwexecutions;
	}

	public void setMaxtimebtwexecutions(BigDecimal maxtimebtwexecutions) {
		this.maxtimebtwexecutions = maxtimebtwexecutions;
	}

	public BigDecimal getProbpercentfullexec() {
		return this.probpercentfullexec;
	}

	public void setProbpercentfullexec(BigDecimal probpercentfullexec) {
		this.probpercentfullexec = probpercentfullexec;
	}

	public List<SecurityConfigMapping> getSecurityConfigMappings() {
		return this.securityConfigMappings;
	}

	public void setSecurityConfigMappings(List<SecurityConfigMapping> securityConfigMappings) {
		this.securityConfigMappings = securityConfigMappings;
	}

	public SecurityConfigMapping addSecurityConfigMapping(SecurityConfigMapping securityConfigMapping) {
		getSecurityConfigMappings().add(securityConfigMapping);
		securityConfigMapping.setConfigurationInfo(this);

		return securityConfigMapping;
	}

	public SecurityConfigMapping removeSecurityConfigMapping(SecurityConfigMapping securityConfigMapping) {
		getSecurityConfigMappings().remove(securityConfigMapping);
		securityConfigMapping.setConfigurationInfo(null);

		return securityConfigMapping;
	}

}