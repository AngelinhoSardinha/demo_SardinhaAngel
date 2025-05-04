package com.example.demo.service.interfaces;

import com.example.demo.presentation.dto.PersonaDTO;

import java.util.List;


public interface IPersonaService {
    List<PersonaDTO> findAll();

    PersonaDTO findById(Long id);

    PersonaDTO createUser(PersonaDTO userDTO);

    PersonaDTO updateUser(PersonaDTO userDTO, Long id);

    String deleteUser(Long id);
}