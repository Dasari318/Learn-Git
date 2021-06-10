package com.aem.praveen.core.component;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
@ObjectClassDefinition(name = "orchard factory service configuration", description = "orchard training")
public @interface Config {
	@AttributeDefinition(name="Author name",description="Name of Author", type=AttributeType.STRING)
	String name();
	@AttributeDefinition(name="Author age",description="Age of Author", type=AttributeType.INTEGER)
	 int age();

}