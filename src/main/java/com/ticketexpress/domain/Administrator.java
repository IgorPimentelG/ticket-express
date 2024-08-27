package com.ticketexpress.domain;

import com.ticketexpress.domain.common.Validation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Administrator implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private UUID id;
	private String fullName;
	private String photo;
	private String email;

	public Administrator(String fullName, String email) {
		setFullName(fullName);
		setEmail(email);
	}

	public void setFullName(String fullName) {
		Validation.build()
		  .forValue(fullName)
		  .notEmpty("Full name cannot be empty.")
		  .max(100, "Full name must have a maximum of 100 characters.")
		  .validate();
		this.fullName = fullName;
	}

	public void setEmail(String email) {
		Validation.build()
		  .forValue(email)
		  .notEmpty("E-mail cannot be empty.")
		  .email()
		  .validate();
		this.email = email;
	}

	public void addPhoto(String photo) {
		Validation.build()
		  .forValue(photo)
		  .extension(List.of("jpg", "jpeg", "png"))
		  .validate();
		this.photo = photo;
	}
}