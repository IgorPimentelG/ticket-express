package com.ticketexpress.domain.ports.services;

import com.ticketexpress.domain.Client;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IClientService {
	void create();
	void update();
	void delete();
	Client find(UUID id);
	Page<Client> list(int pageNumber, int pageSize);
}
