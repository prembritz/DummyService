package com.nls.enquiry;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTypeAdapter;

@JsonbPropertyOrder({"status" })
public class DummyServiceObjects {
	
	@JsonbProperty("StatusDescription")
	public String status = "Relayed";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
