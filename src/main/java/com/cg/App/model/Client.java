package com.cg.App.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long clientId;
	
	@NotNull(message="name cannot be null")
	@Column(name="client_name", nullable = false, length = 255)
	private String clientName;
	
	@NotNull(message="Email cannot be null")
	@Email(message="Email should be valid")
	@Column(name="client_email", nullable = false, length = 255)
	private String clientEmail;
	
	@NotNull(message="Contact cannot be null")
	
	@Column(name="client_contact", nullable = false, length = 255)
	private long clientContact;
	
	public Client() {
		
	}
	public Client(String clientName, String clientEmail, long clientContact) {
		super();
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.clientContact = clientContact;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public long getClientContact() {
		return clientContact;
	}
	public void setClientContact(long clientContact) {
		this.clientContact = clientContact;
	}
	

}

