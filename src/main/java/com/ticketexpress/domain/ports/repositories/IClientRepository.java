package com.ticketexpress.domain.ports.repositories;

import com.ticketexpress.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface IClientRepository {
	void save(Client client);
	void delete(Client client);
	Optional<Client> find(UUID id);
	Page<Client> list(Pageable pageable);
}

