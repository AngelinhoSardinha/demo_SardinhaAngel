package com.example.demo.service.implementation;

import com.example.demo.persistence.dao.interfaces.IPersonaDAO;
import com.example.demo.persistence.entity.PersonaEntity;
import com.example.demo.presentation.dto.PersonaDTO;
import com.example.demo.service.interfaces.IPersonaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDAO userDAO;

    @Override
    public List<PersonaDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();

        return this.userDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, PersonaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonaDTO findById(Long id) {

        Optional<PersonaEntity> userEntity = this.userDAO.findById(id);

        if(userEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            PersonaEntity current = userEntity.get();
            return modelMapper.map(current, PersonaDTO.class);
        } else {
            return new PersonaDTO();
        }
    }

    @Override
    public PersonaDTO createUser(PersonaDTO userDTO) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            PersonaEntity userEntity = modelMapper.map(userDTO, PersonaEntity.class);
            this.userDAO.saveUser(userEntity);

            return userDTO;
        } catch (Exception e){
            throw new UnsupportedOperationException("Error creating user");
        }
    }

    @Override
    public PersonaDTO updateUser(PersonaDTO userDTO, Long id) {

        Optional<PersonaEntity> userEntity = this.userDAO.findById(id);

        if(userEntity.isPresent()) {
            PersonaEntity currentUserEntity = userEntity.get();
            currentUserEntity.setNom(userDTO.getNom());
            currentUserEntity.setCognom1(userDTO.getCognom1());
            currentUserEntity.setCognom2(userDTO.getCognom2());
            currentUserEntity.setNaixement(userDTO.getNaixement());
            currentUserEntity.setTelefon(userDTO.getTelefon());
            currentUserEntity.setEmail(userDTO.getEmail());

            this.userDAO.updateUser(currentUserEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentUserEntity, PersonaDTO.class);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    @Override
    public String deleteUser(Long id) {

        Optional<PersonaEntity> userEntity = this.userDAO.findById(id);

        if(userEntity.isPresent()) {
            PersonaEntity currentUSerEntity = userEntity.get();
            this.userDAO.deleteUSer(currentUSerEntity);
            return "The User with ID: " + id + " was deleted";
        } else {
            return "The User with ID: " + id + " was not found";
        }
    }
}
