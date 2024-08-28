package com.ticketexpress.infrastructure.configs;

import com.ticketexpress.application.adapters.AdministratorService;
import com.ticketexpress.application.adapters.ClientService;
import com.ticketexpress.domain.ports.repositories.*;
import com.ticketexpress.domain.ports.services.*;
import com.ticketexpress.infrastructure.mappers.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjectConfig {

	@Bean
	public IAdministratorService administratorService(IAdministratorRepository repository) {
		return new AdministratorService(repository);
	}

	@Bean
	public IClientService clientService(IClientRepository repository) {
		return new ClientService(repository);
	}

	@Bean
	public ClientMapper clientMapper() {
		return ClientMapper.INSTANCE;
	}

	@Bean
	public AdministratorMapper administratorMapper() {
		return AdministratorMapper.INSTANCE;
	}
}
