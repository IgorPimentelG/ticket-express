package com.ticketexpress.domain.ports.repositories;

import com.ticketexpress.domain.Client;
import com.ticketexpress.domain.common.Page;
import com.ticketexpress.domain.common.Pagination;

import java.util.Optional;
import java.util.UUID;

public interface IClientRepository {
	void save(Client client);
	void delete(Client client);
	Optional<Client> find(UUID id);
	Page<Client> list(Pagination pagination);
}

