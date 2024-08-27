package com.ticketexpress.domain;

import com.ticketexpress.domain.common.Validation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Client implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private UUID id;
	private String fullName;
	private String phone;
	private String email;
	private String CPF;
	private LocalDate birthDate;

	public Client(String fullName, String phone, String email, String CPF, LocalDate birthDate) {
		setFullName(fullName);
		setPhone(phone);
		setEmail(email);
		setCPF(CPF);
		setBirthDate(birthDate);
	}

	public void setFullName(String fullName) {
		Validation.build()
		  .forValue(fullName)
		  .notEmpty("Full name cannot be empty.")
		  .max(100, "Full name must have a maximum of 100 characters.")
		  .validate();
		this.fullName = fullName;
	}

	public void setPhone(String phone) {
		Validation.build()
		  .forValue(phone)
		  .phone()
		  .validate();
		this.phone = phone;
	}

	public void setEmail(String email) {
		Validation.build()
		  .forValue(email)
		  .email()
		  .validate();
		this.email = email;
	}

	public void setCPF(String CPF) {
		Validation.build()
		  .forValue(CPF)
		  .cpf()
		  .validate();
		this.CPF = CPF;
	}

	public void setBirthDate(LocalDate birthDate) {
		Validation.build()
		  .forValue(birthDate)
		  .ofLegalAge()
		  .validate();
		this.birthDate = birthDate;
	}

	public int calculateAge() {
		return LocalDate.now().getYear() - birthDate.getYear();
	}
}