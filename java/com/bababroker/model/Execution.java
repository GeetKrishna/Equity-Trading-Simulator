package com.bababroker.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the EXECUTION database table.
 * 
 */
@Entity
@Table(name="EXECUTION")
@NamedQuery(name="Execution.findAll", query="SELECT e FROM Execution e")
public class Execution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXECUTION_EXECUTIONID_GENERATOR", sequenceName="SOMESEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXECUTION_EXECUTIONID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long executionid;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal price;

	@Column(nullable=false)
	private BigDecimal qty;

	@Column(nullable=false)
	private Timestamp timeofexecution;

	//bi-directional many-to-one association to Block
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BLOCKID", nullable=false)
	private Block block;

	public Execution() {
	}

	public Execution(BigDecimal price, BigDecimal qty,
			Timestamp timeofexecution, Block block) {
		super();
		this.price = price;
		this.qty = qty;
		this.timeofexecution = timeofexecution;
		this.block = block;
	}



	public long getExecutionid() {
		return this.executionid;
	}

	public void setExecutionid(long executionid) {
		this.executionid = executionid;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQty() {
		return this.qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public Timestamp getTimeofexecution() {
		return this.timeofexecution;
	}

	public void setTimeofexecution(Timestamp timeofexecution) {
		this.timeofexecution = timeofexecution;
	}

	public Block getBlock() {
		return this.block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Execution [executionid=");
		builder.append(executionid);
		builder.append(", price=");
		builder.append(price);
		builder.append(", qty=");
		builder.append(qty);
		builder.append(", timeofexecution=");
		builder.append(timeofexecution);
		builder.append(", block=");
		builder.append(block);
		builder.append("]");
		return builder.toString();
	}
	

}