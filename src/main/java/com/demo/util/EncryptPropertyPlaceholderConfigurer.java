package com.demo.util;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private Set<String> encryptedProps = Collections.emptySet();

	public void setEncryptedProps(Set<String> encryptedProps) {
		this.encryptedProps = encryptedProps;
	}
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (encryptedProps.contains(propertyName)) {
			return EncryptUtil.decrypt(propertyValue);
		}
		return super.convertProperty(propertyName, propertyValue);
	}

}
