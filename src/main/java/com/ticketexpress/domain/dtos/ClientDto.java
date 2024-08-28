package com.ticketexpress.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public record ClientDto(
	UUID id,
	String fullName,
	String phone,
	String email,
	String CPF,

	@JsonFormat(pattern = "dd/MM/yyyy")
	LocalDate birthDate
) {}
