package com.liverpool.configuration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Configuration
public class ConfigrationsProeprties {
	@Value("${liverpool.configuration.statickeys.type}")
	private String staticKeysTypeName;

	@Value("${liverpool.configuration.configlist.type}")
	private String configListTypeName;

	@Value("${liverpool.configuration.configmap.type}")
	private String configMapTypeName;

	@Value("${liverpool.configuration.secretKey}")
	private String secretKey;
}
