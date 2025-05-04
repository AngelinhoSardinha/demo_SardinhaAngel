package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.PersonaEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<PersonaEntity, Long> {
}
