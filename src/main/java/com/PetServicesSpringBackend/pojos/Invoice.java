package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@Table(name="invoice")
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="amount_charged")
	private BigDecimal amountCharged;

	private BigDecimal discount;

	@Column(name="invoice_amount")
	private BigDecimal invoiceAmount;

	@Column(name="invoice_code")
	private String invoiceCode;

	@Lob
	private String notes;

	@Column(name="time_charged")
	private Timestamp timeCharged;

	@Column(name="time_generated")
	private int timeGenerated;

	//bi-directional many-to-one association to Cas
	@ManyToOne
	@JoinColumn(name="case_id")
	private Cas cas;

	public Invoice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmountCharged() {
		return this.amountCharged;
	}

	public void setAmountCharged(BigDecimal amountCharged) {
		this.amountCharged = amountCharged;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getInvoiceAmount() {
		return this.invoiceAmount;
	}

	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getInvoiceCode() {
		return this.invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Timestamp getTimeCharged() {
		return this.timeCharged;
	}

	public void setTimeCharged(Timestamp timeCharged) {
		this.timeCharged = timeCharged;
	}

	public int getTimeGenerated() {
		return this.timeGenerated;
	}

	public void setTimeGenerated(int timeGenerated) {
		this.timeGenerated = timeGenerated;
	}

	public Cas getCas() {
		return this.cas;
	}

	public void setCas(Cas cas) {
		this.cas = cas;
	}

}