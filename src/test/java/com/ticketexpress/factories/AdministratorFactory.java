package com.ticketexpress.factories;

import com.ticketexpress.domain.Administrator;
import com.ticketexpress.domain.dtos.AdministratorDto;

import java.util.UUID;

public abstract class AdministratorFactory {

	public static Administrator entity() {
		return new Administrator(
		  "any full name",
		  "any@mail.com"
		);
	}

	public static AdministratorDto dto() {
		return new AdministratorDto(
		  UUID.randomUUID(),
		  "any full name",
		  "any@mail.com",
		  "photo.png"
		);
	}
}
