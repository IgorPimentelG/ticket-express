package com.ticketexpress.infrastructure.adapters;

import com.ticketexpress.domain.Administrator;
import com.ticketexpress.domain.ports.repositories.IAdministratorRepository;
import com.ticketexpress.infrastructure.adapters.db.AdministratorRepository;
import com.ticketexpress.infrastructure.mappers.AdministratorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AdministratorRepositoryPort implements IAdministratorRepository {

	private final AdministratorRepository administratorRepository;
	private final AdministratorMapper administratorMapper;

	@Override
	public void save(Administrator administrator) {
		var entity = administratorMapper.map(administrator);
		administratorRepository.save(entity);
	}

	@Override
	public Optional<Administrator> find(UUID id) {
		var entity = administratorRepository.findById(id);
		return entity.map(administratorMapper::map);
	}
}
