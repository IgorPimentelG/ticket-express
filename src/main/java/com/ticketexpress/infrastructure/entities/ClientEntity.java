package com.ticketexpress.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_clients")
public class ClientEntity extends BaseEntity {

	@Column(name = "full_name")
	private String fullName;

	private String phone;
	private String email;
	private String CPF;

	@Column(name = "birth_date")
	private LocalDate birthDate;
}
