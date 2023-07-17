package com.nls.enquiry;

import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.opentracing.Traced;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/DummyService")
public class DummyService {
	
	@Timeout(value = 15, unit = ChronoUnit.SECONDS)
	@Counted()
	@POST
	@Traced()
	@Produces(MediaType.APPLICATION_JSON)
	@APIResponseSchema(value = DummyServiceObjects.class, responseDescription = "Dummy Service Response",
	responseCode = "200")
	@Operation(summary = "Dummy Service Request", description = "returns Dummy Service data")
	public Response getCallBackDetails(
			@RequestBody(description = "Trans Reference", required = true, 
			content = @Content(mediaType = "application/json")) DummyServiceRequest id) {

		DummyServiceObjects CBObj = new DummyServiceObjects();

		try {
			     System.out.println("Reference No ["+id.getReferenceNo()+"]");
			    // System.out.println("Return Status ["+Response.status(Status.ACCEPTED).entity(CBObj).build()+"]");
				return Response.status(Status.ACCEPTED).entity(CBObj).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
