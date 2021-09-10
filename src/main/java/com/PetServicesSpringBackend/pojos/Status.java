package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="status")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="is_closing_status")
	private byte isClosingStatus;

	@Column(name="status_name")
	private String statusName;

	//bi-directional many-to-one association to CurrentStatus
	@OneToMany(mappedBy="status")
	private List<CurrentStatus> currentStatuses;

	//bi-directional many-to-one association to StatusCategory
	@ManyToOne
	@JoinColumn(name="status_category_id")
	private StatusCategory statusCategory;

	public Status() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getIsClosingStatus() {
		return this.isClosingStatus;
	}

	public void setIsClosingStatus(byte isClosingStatus) {
		this.isClosingStatus = isClosingStatus;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<CurrentStatus> getCurrentStatuses() {
		return this.currentStatuses;
	}

	public void setCurrentStatuses(List<CurrentStatus> currentStatuses) {
		this.currentStatuses = currentStatuses;
	}

	public CurrentStatus addCurrentStatus(CurrentStatus currentStatus) {
		getCurrentStatuses().add(currentStatus);
		currentStatus.setStatus(this);

		return currentStatus;
	}

	public CurrentStatus removeCurrentStatus(CurrentStatus currentStatus) {
		getCurrentStatuses().remove(currentStatus);
		currentStatus.setStatus(null);

		return currentStatus;
	}

	public StatusCategory getStatusCategory() {
		return this.statusCategory;
	}

	public void setStatusCategory(StatusCategory statusCategory) {
		this.statusCategory = statusCategory;
	}

}