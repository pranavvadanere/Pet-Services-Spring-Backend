package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the note database table.
 * 
 */
@Entity
@Table(name="note")
@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="insert_time")
	private Timestamp insertTime;

	@Lob
	@Column(name="note_text")
	private String noteText;

	//bi-directional many-to-one association to Cas
	@ManyToOne
	@JoinColumn(name="case_id")
	private Cas cas;

	public Note() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getInsertTime() {
		return this.insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	public String getNoteText() {
		return this.noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	public Cas getCas() {
		return this.cas;
	}

	public void setCas(Cas cas) {
		this.cas = cas;
	}

}