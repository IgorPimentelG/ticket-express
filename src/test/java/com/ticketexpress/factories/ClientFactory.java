package com.ticketexpress.factories;

import com.ticketexpress.domain.Client;
import com.ticketexpress.domain.common.Page;
import com.ticketexpress.domain.dtos.ClientDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class ClientFactory {

	public static Client entity() {
		return new Client(
		  "any full name",
		  "(83) 99190-1111",
		  "any@mail.com",
		  "111.111.111-11",
		  LocalDate.of(1990, 1, 1)
		);
	}

	public static ClientDto dto() {
		return new ClientDto(
		  UUID.randomUUID(),
		  "any full name",
		  "(83) 99190-1111",
		  "any@mail.com",
		  "111.111.111-11",
		  LocalDate.of(1990, 1, 1)
		);
	}

	public static Page<Client> page() {
		final int totalElements = 2;
		List<Client> clients = new ArrayList<>(totalElements);

		for (int i = 0; i < totalElements; i++) {
			clients.add(
			  new Client(
				"any full name " + (i + 1),
				"(83) 99190-1111",
				"any@mail.com",
				"111.111.111-11",
				LocalDate.of(1990, 1, 1)
			  )
			);
		}

		return new Page<>(clients, 1, 2);
	}
}
