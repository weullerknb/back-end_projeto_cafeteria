package com.projeto.cafeteria.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "cpf", length = 15, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "birthdate", nullable = false)
	private String birthdate;

	@Column(name = "phone", length = 15, nullable = false, unique = true)
	private String phone;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "password", length = 20,  nullable = false)
	private String password;
}
