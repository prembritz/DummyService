package com.nls.enquiry;

import java.sql.SQLException;

import java.util.Set;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import com.mchange.v2.c3p0.DataSources;

@ApplicationPath("/Enquiry")
@OpenAPIDefinition(info = @Info(title = "Dummy Service API", version = "1.0.0"))
public class EnquiryDBConfiguration extends Application {

	Config configProperties;

	private static DataSource cmDBPool;
	public EnquiryDBConfiguration() {
	}

	@PreDestroy
	public void closePools() {
		try {
			DataSources.destroy(cmDBPool);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public Set<Object> getSingletons() {
		return null;
	}

	public Set<Class<?>> getClasses() {
		return null;
	}
}
