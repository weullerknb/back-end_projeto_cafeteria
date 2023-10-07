package com.projeto.cafeteria.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_user")
public class User {
	
	public interface CreateUser {
		
	}
	
	public interface UpdateUser {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotBlank(groups = CreateUser.class)
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@NotBlank(groups = CreateUser.class)
	@Column(name = "cpf", length = 15, nullable = false, unique = true)
	private String cpf;
	
	@NotBlank(groups = CreateUser.class)
	@Column(name = "birthdate", nullable = false)
	private String birthdate;

	@NotBlank(groups = CreateUser.class)
	@Column(name = "phone", length = 15, nullable = false, unique = true)
	private String phone;

	@NotBlank(groups = CreateUser.class)
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "password", length = 20,  nullable = false)
	@NotBlank(groups = {CreateUser.class, UpdateUser.class})
	@Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 20)
	private String password;

	public User() {
	}

	public User(Integer id, @NotBlank String name, @NotBlank String cpf, @NotBlank String birthdate,
			@NotBlank String phone, @NotBlank String email, @NotBlank @Size(min = 8, max = 20) String password) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.birthdate = birthdate;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password);
	}
	
	
}
