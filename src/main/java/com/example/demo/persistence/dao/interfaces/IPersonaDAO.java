package com.example.demo.persistence.dao.interfaces;

import com.example.demo.persistence.entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

public interface IPersonaDAO {

    List<PersonaEntity> findAll();

    Optional<PersonaEntity> findById(Long id);

    void saveUser(PersonaEntity userEntity);

    void updateUser(PersonaEntity userEntity);

    void deleteUSer(PersonaEntity userEntity);
}
