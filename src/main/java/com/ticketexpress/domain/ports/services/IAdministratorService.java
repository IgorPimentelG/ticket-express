package com.ticketexpress.domain.ports.services;

import com.ticketexpress.domain.dtos.AdministratorDto;
import com.ticketexpress.domain.Administrator;

import java.util.UUID;

public interface IAdministratorService {
	void update(AdministratorDto resource);
	AdministratorDto find(UUID id);
}
