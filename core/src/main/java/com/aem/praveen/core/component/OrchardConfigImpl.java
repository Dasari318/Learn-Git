package com.aem.praveen.core.component;

import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;



@Component(service = OrcharConfig.class, immediate = true)
@Designate(ocd = com.aem.praveen.core.component.Config.class)
public class OrchardConfigImpl implements OrcharConfig {
	private Config config;
	private String data = null;
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	@Activate
	@Modified
	protected void activate(final Config config) {

		this.data = PropertiesUtil.toString(config.name() + "-" + config.age(), "No configuration found");
		logger.info("orchard info: " + data);
		this.config = config;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return config.name();
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return config.age();
	}

}