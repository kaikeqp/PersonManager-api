package com.project.person.controller;


import com.project.person.dto.request.PersonDTO;
import com.project.person.dto.response.MessageResponseDTO;
import com.project.person.exception.PersonNotFoundExeption;
import com.project.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")


public class PersonController {

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService){
	    this.personService = personService;
    }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}

	@GetMapping
	public List<PersonDTO> listAll() {
		return personService.listAll();
	}
	
	@GetMapping("/{id}")
	public PersonDTO findByDto(@PathVariable Long id) throws PersonNotFoundExeption {
		return personService.findById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO UpdateById(@PathVariable Long id,@RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundExeption {
		return personService.updateById(id, personDTO);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PersonNotFoundExeption {
		personService.delete(id);
		
	}
}
