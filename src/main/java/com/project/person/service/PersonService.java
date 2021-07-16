package com.project.person.service;

import com.project.person.dto.request.PersonDTO;
import com.project.person.dto.response.MessageResponseDTO;
import com.project.person.exception.PersonNotFoundExeption;
import com.project.person.models.Person;
import com.project.person.mapper.PersonMapper;
import com.project.person.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

	private PersonRepository personRep;

	private PersonMapper personMapper = PersonMapper.INSTANCE;

	@Autowired
	public PersonService(PersonRepository personRep){
		this.personRep = personRep;
	}

	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);

		Person savedPerson = personRep.save(personToSave);
		return createMessageResponse(savedPerson.getId(), "Created person with ID ");

	}

	
	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRep.findAll();
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	
	public PersonDTO findById(Long id) throws PersonNotFoundExeption{
		Person person = verifyIfExist(id);
		
		return personMapper.toDTO(person);
	}
	
	
	public void delete(Long id) throws PersonNotFoundExeption {
		verifyIfExist(id);
		personRep.deleteById(id);
	}
	
	
	public MessageResponseDTO updateById(Long id, @Valid PersonDTO personDTO) throws PersonNotFoundExeption {
		verifyIfExist(id);
		
		Person personToUpdate = personMapper.toModel(personDTO);
		
		Person updatePerson = personRep.save(personToUpdate);
		return createMessageResponse(updatePerson.getId(),"Update person with ID: ");
	}
	
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message+ id)
				.build();
	}
	
	
	private Person verifyIfExist(Long id) throws PersonNotFoundExeption {
		Person person = personRep.findById(id)
				.orElseThrow(() ->new PersonNotFoundExeption(id));
		return person;
	}

}
