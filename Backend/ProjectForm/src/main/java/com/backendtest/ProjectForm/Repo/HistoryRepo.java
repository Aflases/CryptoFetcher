package com.backendtest.ProjectForm.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backendtest.ProjectForm.Entity.CryptoEntity;
import com.backendtest.ProjectForm.Entity.History;


@Repository
public interface HistoryRepo extends MongoRepository<History,Integer> {
	
	public Optional<List<History>> findByCode(String code); 
	

}
