package com.ticketexpress.domain.ports.services;

import com.ticketexpress.domain.Administrator;

import java.util.UUID;

public interface IAdministratorService {
	void update();
	Administrator find(UUID id);
}
