package com.ticketexpress.infrastructure.adapters;

import com.ticketexpress.domain.Client;
import com.ticketexpress.domain.common.Page;
import com.ticketexpress.domain.common.Pagination;
import com.ticketexpress.domain.ports.repositories.IClientRepository;
import com.ticketexpress.infrastructure.adapters.db.ClientRepository;
import com.ticketexpress.infrastructure.mappers.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClientRepositoryPort implements IClientRepository {

	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;

	@Override
	public void save(Client client) {
		var entity = clientMapper.map(client);
		clientRepository.save(entity);
	}

	@Override
	public void delete(Client client) {
		var entity = clientRepository.findById(client.getId());
		entity.ifPresent(clientRepository::delete);
	}

	@Override
	public Optional<Client> find(UUID id) {
		var entity = clientRepository.findById(id);
		return entity.map(clientMapper::map);
	}

	@Override
	public Page<Client> list(Pagination pagination) {
		Pageable pageable = PageRequest.of(pagination.pageNumber(), pagination.pageSize());
		var clients = clientRepository.findAll(pageable);

		return new Page<>(
		  clientMapper.map(clients.getContent()),
		  clients.getTotalPages(),
		  clients.getTotalElements()
		);
	}
}
