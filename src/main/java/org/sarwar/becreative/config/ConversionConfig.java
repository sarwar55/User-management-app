package org.sarwar.becreative.config;

import java.util.HashSet;
import java.util.Set;

import org.sarwar.becreative.converter.UserRequestToUserConverter;
import org.sarwar.becreative.converter.UserToUserResponseConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConversionConfig {

	private Set<Converter> getConverters() {
		Set<Converter> converters = new HashSet<>();
		converters.add(new UserToUserResponseConverter());
		converters.add(new UserRequestToUserConverter());
		return converters;
	}

	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		return bean.getObject();
	}
}
