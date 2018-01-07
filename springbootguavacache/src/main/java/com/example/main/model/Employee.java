package com.example.main.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.io.Serializable;

/**
 * @author Lucky Pratama
 *
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GenericGenerator(
			name="employeeSequenceGenerator",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="sequence_name", value = "employeeSequenceNew"),
					@Parameter(name="initial_value", value = "1"),
					@Parameter(name="increment_size", value = "1")
			}
			)
	
	@Id
	@GeneratedValue(generator="employeeSequenceGenerator")
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
