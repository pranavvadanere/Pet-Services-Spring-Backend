package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status_category database table.
 * 
 */
@Entity
@Table(name="status_category")
@NamedQuery(name="StatusCategory.findAll", query="SELECT s FROM StatusCategory s")
public class StatusCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="status_category_name")
	private String statusCategoryName;

	//bi-directional many-to-one association to Status
	@OneToMany(mappedBy="statusCategory")
	private List<Status> statuses;

	public StatusCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatusCategoryName() {
		return this.statusCategoryName;
	}

	public void setStatusCategoryName(String statusCategoryName) {
		this.statusCategoryName = statusCategoryName;
	}

	public List<Status> getStatuses() {
		return this.statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public Status addStatus(Status status) {
		getStatuses().add(status);
		status.setStatusCategory(this);

		return status;
	}

	public Status removeStatus(Status status) {
		getStatuses().remove(status);
		status.setStatusCategory(null);

		return status;
	}

}