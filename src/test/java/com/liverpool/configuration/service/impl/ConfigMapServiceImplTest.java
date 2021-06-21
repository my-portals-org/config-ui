package com.liverpool.configuration.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.liverpool.configuration.properties.ConfigrationsProeprties;
import com.liverpool.configuration.repository.ConfigMapRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;

@WebMvcTest(ConfigListServiceImpl.class)
public class ConfigMapServiceImplTest {

	@MockBean
	private ConfigMapRepository repository;
	
	@MockBean
	private MongoTemplate mongoTemplate;
	
	@MockBean
	private ConfigrationsProeprties properies;
	
	@Mock
	private InsertOneResult insertOneResult;
	
	private ConfigMapServiceImpl service;
	
	@MockBean
	private MongoCollection<Document> collection;
	
	@BeforeEach
	public void setUp() {
		service = new ConfigMapServiceImpl(repository, mongoTemplate);
	}
	
	@Test
	public void getAllConfigMap() {
		
		when(mongoTemplate.getCollection(anyString())).thenReturn(collection);
		when(collection.insertOne(any(Document.class))).thenReturn(insertOneResult);
		
		assertThat(service.getAllConfigMaps() instanceof List<?>);
	}
}
