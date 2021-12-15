package com.asap.seguradora.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.asap.seguradora.documents.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

}
