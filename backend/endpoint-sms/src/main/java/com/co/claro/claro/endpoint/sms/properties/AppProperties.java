package com.co.claro.claro.endpoint.sms.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@Data
@NoArgsConstructor
public class AppProperties {

	@Value("${name.file}")
	private String nameFile;

	@Value("${name.file.format}")
	private String nameFileFormat;

}
