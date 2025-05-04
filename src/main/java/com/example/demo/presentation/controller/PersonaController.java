package com.example.demo.presentation.controller;

import com.example.demo.presentation.dto.PersonaDTO;
import com.example.demo.service.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private IPersonaService userService;

    //FindAll
    @GetMapping("/find")
    public ResponseEntity<List<PersonaDTO>> findAll(){
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    //Find by ID
    @GetMapping("/find/{id}")
    public ResponseEntity<PersonaDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    //Create user
    @PostMapping("/create")
    public ResponseEntity<PersonaDTO> createUser(@RequestBody PersonaDTO userDTO) {
        return new ResponseEntity<>(this.userService.createUser(userDTO), HttpStatus.CREATED);
    }

    //Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<PersonaDTO> updateUser(@RequestBody PersonaDTO userDTO, @PathVariable Long id) {
        return new ResponseEntity<>(this.userService.updateUser(userDTO, id), HttpStatus.OK);
    }

    //Delete User
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deteUser(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }
}
