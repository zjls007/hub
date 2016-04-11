package com.demo.core;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

public class AppBeanNamingGenerator extends AnnotationBeanNameGenerator {
	
	@Override
	public String generateBeanName(BeanDefinition arg0,
			BeanDefinitionRegistry arg1) {
		String beanName = super.generateBeanName(arg0, arg1);
		int index = beanName.toUpperCase().indexOf("IMPL");
		int length = beanName.length();
		if (index + 4 == length && index != 0) {
			beanName = beanName.substring(0, index);
		} 
		return beanName;
	}


	
}
