package com.aem.praveen.core.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.praveen.core.utils.ResolverUtil;
import com.day.cq.wcm.api.Page;
@Component(name="praveen test",service=ProjectService.class,immediate=true)
public class ProjectServiceImpl implements ProjectService {
	private ResourceResolver resourceResolver;

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

	@Override
	public Map<String, String> getPageInfo() throws LoginException {

		Map<String, String> pageInfo = null;

		pageInfo = new HashMap<String, String>();

		resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
		Resource res = resourceResolver.getResource("/content/praveen/en");
		Page page = res.adaptTo(Page.class);

		pageInfo.put("title", page.getTitle());
		pageInfo.put("path", page.getPath());

		pageInfo.put("isChildExists", String.valueOf(res.hasChildren()));

		/*
		 * if (res.hasChildren()) { Iterator<Resource> childResources =
		 * res.listChildren();
		 * 
		 * List<String> childPageNames = new ArrayList<String>();
		 * 
		 * while (childResources.hasNext()) { Resource childResource =
		 * childResources.next();
		 * 
		 * childPageNames.add(childResource.getName());
		 * 
		 * } pageInfo.put("childrenNames", childPageNames); }
		 */
		return pageInfo;
	}

	@Activate
	@Modified
	public void activate() {

		logger.info(": ACTIVATE THE RESOURCE RESOLVER :");
	}

	@Override
	public String getPath() {
		String path = "";
		Resource res = resourceResolver.getResource("/content/praveen/en");

		path = res.getPath();

		return path;
	}

}
