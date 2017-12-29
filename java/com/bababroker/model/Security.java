package com.bababroker.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the SECURITY database table.
 * 
 */
@Entity
@Table(name="SECURITY")
@NamedQuery(name="Security.findAll", query="SELECT s FROM Security s")
public class Security implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String securitysymbol;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal lasttradeprice;

	@Column(nullable=false, length=50)
	private String securityname;

	//bi-directional many-to-one association to Block
	@OneToMany(mappedBy="security")
	private List<Block> blocks;

	//bi-directional one-to-one association to SecurityConfigMapping
	@OneToOne(mappedBy="security")
	private SecurityConfigMapping securityConfigMapping;

	public Security() {
	}
	
	public Security(String securitysymbol, BigDecimal lasttradeprice,
			String securityname, List<Block> blocks,
			SecurityConfigMapping securityConfigMapping) {
		super();
		this.securitysymbol = securitysymbol;
		this.lasttradeprice = lasttradeprice;
		this.securityname = securityname;
		this.blocks = blocks;
		this.securityConfigMapping = securityConfigMapping;
	}



	public String getSecuritysymbol() {
		return this.securitysymbol;
	}

	public void setSecuritysymbol(String securitysymbol) {
		this.securitysymbol = securitysymbol;
	}

	public BigDecimal getLasttradeprice() {
		return this.lasttradeprice;
	}

	public void setLasttradeprice(BigDecimal lasttradeprice) {
		this.lasttradeprice = lasttradeprice;
	}

	public String getSecurityname() {
		return this.securityname;
	}

	public void setSecurityname(String securityname) {
		this.securityname = securityname;
	}

	public List<Block> getBlocks() {
		return this.blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public Block addBlock(Block block) {
		getBlocks().add(block);
		block.setSecurity(this);

		return block;
	}

	public Block removeBlock(Block block) {
		getBlocks().remove(block);
		block.setSecurity(null);

		return block;
	}

	public SecurityConfigMapping getSecurityConfigMapping() {
		return this.securityConfigMapping;
	}

	public void setSecurityConfigMapping(SecurityConfigMapping securityConfigMapping) {
		this.securityConfigMapping = securityConfigMapping;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Security [securitysymbol=");
		builder.append(securitysymbol);
		builder.append(", lasttradeprice=");
		builder.append(lasttradeprice);
		builder.append(", securityname=");
		builder.append(securityname);
		builder.append(", blocks=");
		builder.append(blocks);
		builder.append(", securityConfigMapping=");
		builder.append(securityConfigMapping);
		builder.append("]");
		return builder.toString();
	}

}