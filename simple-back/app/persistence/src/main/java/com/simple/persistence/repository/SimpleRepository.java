package com.simple.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.simple.models.entities.SimpleEntity;

public interface SimpleRepository extends MongoRepository<SimpleEntity, String> {

}
