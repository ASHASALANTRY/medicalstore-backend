package com.cg.App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity



@Table(name = "ADMIN")

public class Admin {
@Id

@GeneratedValue(strategy=GenerationType.AUTO)

private Integer aId;

@Column(name="ADMIN_NAME")

private String aName;
@Column(name="USERNAME")

private String userName;

@Column(name="PASSWORD") 
private String password;


public Admin() {
	super();
	// TODO Auto-generated constructor stub
}

public Admin(Integer aId, String aName, String userName, String password) {
	super();
	this.aId = aId;
	this.aName = aName;
	this.userName = userName;
	this.password = password;
}

public Integer getaId() {
	return aId;
}

public void setaId(Integer aId) {
	this.aId = aId;
}

public String getaName() {
	return aName;
}

public void setaName(String aName) {
	this.aName = aName;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "Admin [aId=" + aId + ", aName=" + aName + ", userName=" + userName + ", password=" + password + "]";
}

}
