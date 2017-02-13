package com.theironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CampBlipApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampBlipApplication.class, args);
	}

	//Creates rest template for bringing in APIs can read over ride provided
	// by Ben Sterrett to deal with the text/html headers coming back from Lego API
	@Bean
	public RestTemplate restTemplateBuilderBean(RestTemplateBuilder builder) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter() {
			@Override
			protected boolean canRead(MediaType mediaType) {
				return mediaType != null && (mediaType.equals(MediaType.parseMediaType("text/html;charset=utf-8")) || super.canRead(mediaType));
			}
		};

		List<HttpMessageConverter<?>> converters = new ArrayList<>();

		converters.add(converter);

		return builder.additionalMessageConverters(converters).build();
	}
}
