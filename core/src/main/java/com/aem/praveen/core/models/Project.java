package com.aem.praveen.core.models;

import java.util.Map;

import org.apache.sling.api.resource.LoginException;

public interface Project {
	Map<String, String> getPageInfo() throws LoginException;
	String getPath();
}
