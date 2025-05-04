package com.example.demo.persistence.dao.implementation;

import com.example.demo.persistence.dao.interfaces.IPersonaDAO;
import com.example.demo.persistence.entity.PersonaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaDaoImpl implements IPersonaDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<PersonaEntity> findAll() {
        return this.em.createQuery("Select u from PersonaEntity u").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PersonaEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(PersonaEntity.class, id));
    }

    @Override
    @Transactional
    public void saveUser(PersonaEntity userEntity) {
        this.em.persist(userEntity);
        this.em.flush();
    }

    @Override
    @Transactional
    public void updateUser(PersonaEntity userEntity) {
        this.em.merge(userEntity);
    }

    @Override
    @Transactional
    public void deleteUSer(PersonaEntity userEntity) {
        this.em.remove(userEntity);
    }
}
