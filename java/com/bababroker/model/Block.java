package com.bababroker.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the "BLOCK" database table.
 * 
 */
@Entity
//@XmlRootElement(name="Block")
@Table(name="BLOCK")
@NamedQuery(name="Block.findAll", query="SELECT b FROM Block b")
public class Block implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	/*@SequenceGenerator(name="BLOCK_BLOCKID_GENERATOR", sequenceName="SOMESEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLOCK_BLOCKID_GENERATOR")*/
	@Column(unique=true, nullable=false)
	private long blockid;

	private BigDecimal executedqty;

	@Column(precision=10, scale=2)
	private BigDecimal limitprice;

	@Column(nullable=false, length=6)
	private String side;

	@Column(nullable=false, length=30)
	private String status;

	@Column(precision=10, scale=2)
	private BigDecimal stopprice;

	private Timestamp timeexecuted;

	@Column(nullable=false)
	private Timestamp timereceived;

	@Column(nullable=false)
	private BigDecimal totalqty;

	//bi-directional many-to-one association to Security
	@ManyToOne
	@JoinColumn(name="SYMBOL", nullable=false)
	private Security security;

	//bi-directional many-to-one association to Execution
	@OneToMany(mappedBy="block", fetch=FetchType.EAGER)
	private List<Execution> executions;

	public Block() {
	}

	public Block(BigDecimal executedqty, BigDecimal limitprice, String side,
			String status, BigDecimal stopprice, Timestamp timeexecuted,
			Timestamp timereceived, BigDecimal totalqty, Security security,
			List<Execution> executions) {
		super();
		this.executedqty = executedqty;
		this.limitprice = limitprice;
		this.side = side;
		this.status = status;
		this.stopprice = stopprice;
		this.timeexecuted = timeexecuted;
		this.timereceived = timereceived;
		this.totalqty = totalqty;
		this.security = security;
		this.executions = executions;
	}




	public Block(BigDecimal executedqty, BigDecimal limitprice, String side,
			String status, BigDecimal stopprice, Timestamp timeexecuted,
			Timestamp timereceived, BigDecimal totalqty) {
		this.executedqty = executedqty;
		this.limitprice = limitprice;
		this.side = side;
		this.status = status;
		this.stopprice = stopprice;
		this.timeexecuted = timeexecuted;
		this.timereceived = timereceived;
		this.totalqty = totalqty;
	}

	public long getBlockid() {
		return this.blockid;
	}

	public void setBlockid(long blockid) {
		this.blockid = blockid;
	}

	public BigDecimal getExecutedqty() {
		return this.executedqty;
	}

	public void setExecutedqty(BigDecimal executedqty) {
		this.executedqty = executedqty;
	}

	public BigDecimal getLimitprice() {
		return this.limitprice;
	}

	public void setLimitprice(BigDecimal limitprice) {
		this.limitprice = limitprice;
	}

	public String getSide() {
		return this.side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getStopprice() {
		return this.stopprice;
	}

	public void setStopprice(BigDecimal stopprice) {
		this.stopprice = stopprice;
	}

	public Timestamp getTimeexecuted() {
		return this.timeexecuted;
	}

	public void setTimeexecuted(Timestamp timeexecuted) {
		this.timeexecuted = timeexecuted;
	}

	public Timestamp getTimereceived() {
		return this.timereceived;
	}

	public void setTimereceived(Timestamp timereceived) {
		this.timereceived = timereceived;
	}

	public BigDecimal getTotalqty() {
		return this.totalqty;
	}

	public void setTotalqty(BigDecimal totalqty) {
		this.totalqty = totalqty;
	}

	public Security getSecurity() {
		return this.security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public List<Execution> getExecutions() {
		return this.executions;
	}

	public void setExecutions(List<Execution> executions) {
		this.executions = executions;
	}

	public Execution addExecution(Execution execution) {
		getExecutions().add(execution);
		execution.setBlock(this);

		return execution;
	}

	public Execution removeExecution(Execution execution) {
		getExecutions().remove(execution);
		execution.setBlock(null);

		return execution;
	}

	public void addSecurityToBlock(Security security)
	{
		if(security==null)
			return ;
		this.security=security;
		security.getBlocks().add(this);
		
	}

}