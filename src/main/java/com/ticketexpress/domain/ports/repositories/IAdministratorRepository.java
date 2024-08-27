package com.ticketexpress.domain.ports.repositories;

import com.ticketexpress.domain.Administrator;

import java.util.Optional;
import java.util.UUID;

public interface IAdministratorRepository {
	void save(Administrator administrator);
	Optional<Administrator> find(UUID id);
}
