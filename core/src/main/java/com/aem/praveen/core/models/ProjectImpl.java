package com.aem.praveen.core.models;

import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.aem.praveen.core.services.ProjectService;



@Model(adaptables = SlingHttpServletRequest.class,adapters=Project.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProjectImpl implements Project {
	@OSGiService
	ProjectService service;
	@Override
	public Map<String, String> getPageInfo() throws LoginException {
	
		return service.getPageInfo();
	}
	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return service.getPath();
	}

}