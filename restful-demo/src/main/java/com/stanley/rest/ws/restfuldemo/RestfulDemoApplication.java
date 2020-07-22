package com.stanley.rest.ws.restfuldemo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulDemoApplication.class, args);
	}
	
	@Bean
	public AcceptHeaderLocaleResolver localeResolver() {
	    AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
	    localeResolver.setDefaultLocale(Locale.US);
	    return localeResolver;
	}
	
//	@Bean
//	public ResourceBundleMessageSource bundleMessageSource() {
//	    ResourceBundleMessageSource bundleSource = new ResourceBundleMessageSource();
//	    bundleSource.setBasename("messages");
//	    return bundleSource;
//	}

}
