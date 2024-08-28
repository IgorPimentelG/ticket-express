package com.ticketexpress.domain.ports.services;

import com.ticketexpress.domain.common.Page;
import com.ticketexpress.domain.common.Pagination;
import com.ticketexpress.domain.dtos.ClientDto;

import java.util.UUID;

public interface IClientService {
	void create(ClientDto resource);
	void update(ClientDto resource);
	void delete(UUID id);
	ClientDto find(UUID id);
	Page<ClientDto> list(Pagination pagination);
}
