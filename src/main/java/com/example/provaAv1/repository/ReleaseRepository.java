package com.example.provaAv1.repository;

import com.example.provaAv1.model.ReleaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends MongoRepository<ReleaseEntity,String> {
}
