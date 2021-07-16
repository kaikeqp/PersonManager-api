package com.project.person.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	private LocalDate birthDate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Phone> phones;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getCpf() {
//		return cpf;
//	}
//
//	public void setCpf(String cpf) {
//		this.cpf = cpf;
//	}
//
//	public LocalDate getBirthDate() {
//		return birthDate;
//	}
//
//	public void setBirthDate(LocalDate birthDate) {
//		this.birthDate = birthDate;
//	}
//
//	public List<Phone> getPhones() {
//		return phones;
//	}
//
//	public void setPhones(List<Phone> phones) {
//		this.phones = phones;
//	}
//
//	public Person(Long id, String firstName, String lastName, String cpf, LocalDate birthDate, List<Phone> phones) {
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.cpf = cpf;
//		this.birthDate = birthDate;
//		this.phones = phones;
//	}
//
//	public Person() {
//	}
}
