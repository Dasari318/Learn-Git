package com.aem.praveen.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, adapters = Author.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AuthorImpl implements Author {
	@Inject
	@Default(values = "praveen")
	String name;
	@Inject
	@Default(values = "23")
	int age;
	@Inject

	boolean employee;

	@Override
	public String getName() {
		return name;

	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public boolean getEmployee() {
		return employee;
	}

}
