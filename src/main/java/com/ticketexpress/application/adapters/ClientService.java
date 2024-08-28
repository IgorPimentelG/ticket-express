package com.ticketexpress.application.adapters;

import com.ticketexpress.application.errors.NotFoundException;
import com.ticketexpress.application.mappers.ClientMapper;
import com.ticketexpress.domain.Client;
import com.ticketexpress.domain.common.Page;
import com.ticketexpress.domain.common.Pagination;
import com.ticketexpress.domain.dtos.ClientDto;
import com.ticketexpress.domain.ports.repositories.IClientRepository;
import com.ticketexpress.domain.ports.services.IClientService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class ClientService implements IClientService {

	private IClientRepository clientRepository;
	private final ClientMapper clientMapper = ClientMapper.INSTANCE;

	@Override
	public void create(ClientDto resource) {
		var client = clientMapper.map(resource);
		clientRepository.save(client);
	}

	@Override
	public void update(ClientDto resource) {
		var client = findById(resource.id());
		clientMapper.update(resource, client);
		clientRepository.save(client);
	}

	@Override
	public void delete(UUID id) {
		var client = findById(id);
		clientRepository.delete(client);
	}

	@Override
	public ClientDto find(UUID id) {
		var client = findById(id);
		return clientMapper.map(client);
	}

	@Override
	public Page<ClientDto> list(Pagination pagination) {
		Page<Client> clients = clientRepository.list(pagination);
		return clientMapper.map(clients);
	}

	private Client findById(UUID id) {
		return clientRepository.find(id)
		  .orElseThrow(() -> new NotFoundException("Client doesn't exist."));
	}
}
