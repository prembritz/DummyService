package com.nls.enquiry;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "DummyServiceRequest", description = "Request object with ReferenceNo")
@JsonbPropertyOrder({ "referenceNo" })
public class DummyServiceRequest {

	@Schema(required = true, example = "TBC1502211512002", description = "Reference No")
	@JsonbProperty("ReferenceNo")
	private String referenceNo;

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	
}
