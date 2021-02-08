package com.main.EmployeeManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Request")
public class Request {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int req_id;
@Column(name="req_type", nullable=false)
String req_type;
@Column(name="reason", nullable=false)
String reason;
@Column(name="category", nullable=false)
String category;
public Request(int req_no, String req_type, String reason, String category) {
	super();
	this.req_id = req_no;
	this.req_type = req_type;
	this.reason = reason;
	this.category = category;
}
public Request() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Request [req_no=" + req_id + ", req_type=" + req_type + ", reason=" + reason + ", category=" + category
			+ "]";
}
public int getReq_id() {
	return req_id;
}
public void setReq_id(int req_no) {
	this.req_id = req_no;
}
public String getReq_type() {
	return req_type;
}
public void setReq_type(String req_type) {
	this.req_type = req_type;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}


}
