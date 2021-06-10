package com.aem.praveen.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.aem.praveen.core.services.CsvService;



@Model(adaptables =  SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CsvModel {
	
	@OSGiService
	CsvService csvService;
	
	public String getAsset() throws LoginException {
		return csvService.getAsset();
	}
}