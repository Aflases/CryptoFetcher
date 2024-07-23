package com.backendtest.ProjectForm.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backendtest.ProjectForm.Entity.CryptoEntity;

@Repository
public interface CryptoRepo extends MongoRepository<CryptoEntity,Integer> {
	
	Optional<CryptoEntity> findByCode(String code);
	
	void deleteByCode(String code);

	
}
