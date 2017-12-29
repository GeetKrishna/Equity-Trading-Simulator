package com.bababroker.testjms;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Block")
public class JmsBlock {

    private long blockid;
    private String symbol;
    private String status;
    private String type;
    private String side;
    private BigDecimal initialqty;
    private BigDecimal avglimitprice;
    private BigDecimal avgstopprice;
    private long executionid;
    private BigDecimal executedqty;
    private BigDecimal transactionprice;
    
    

   

   

    

   

   // @Column(name="\"TYPE\"")
   

	public long getBlockid() {
		return blockid;
	}

	public long getExecutionid() {
		return executionid;
	}

	public void setExecutionid(long executionid) {
		this.executionid = executionid;
	}

	public BigDecimal getExecutedqty() {
		return executedqty;
	}

	public void setExecutedqty(BigDecimal executedqty) {
		this.executedqty = executedqty;
	}

	public BigDecimal getTransactionprice() {
		return transactionprice;
	}

	public void setTransactionprice(BigDecimal transactionprice) {
		this.transactionprice = transactionprice;
	}

	public void setBlockid(long blockid) {
		this.blockid = blockid;
	}

	public BigDecimal getAvglimitprice() {
		return avglimitprice;
	}

	public void setAvglimitprice(BigDecimal avglimitprice) {
		this.avglimitprice = avglimitprice;
	}

	public BigDecimal getAvgstopprice() {
		return avgstopprice;
	}

	public void setAvgstopprice(BigDecimal avgstopprice) {
		this.avgstopprice = avgstopprice;
	}

	public BigDecimal getInitialqty() {
		return initialqty;
	}

	public void setInitialqty(BigDecimal initialqty) {
		this.initialqty = initialqty;
	}

	
	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	
}
