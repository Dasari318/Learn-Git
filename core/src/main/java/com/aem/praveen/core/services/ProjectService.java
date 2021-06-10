package com.aem.praveen.core.services;

import java.util.Map;

import org.apache.sling.api.resource.LoginException;

public interface ProjectService {
	Map<String, String> getPageInfo() throws LoginException;
	String getPath();
}
