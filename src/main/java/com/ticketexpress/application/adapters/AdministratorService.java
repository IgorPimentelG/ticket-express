package com.ticketexpress.application.adapters;

import com.ticketexpress.application.errors.NotFoundException;
import com.ticketexpress.application.mappers.AdministratorMapper;
import com.ticketexpress.domain.Administrator;
import com.ticketexpress.domain.dtos.AdministratorDto;
import com.ticketexpress.domain.ports.repositories.IAdministratorRepository;
import com.ticketexpress.domain.ports.services.IAdministratorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class AdministratorService implements IAdministratorService {

	private IAdministratorRepository administratorRepository;
	public final AdministratorMapper administratorMapper = AdministratorMapper.INSTANCE;

	@Override
	public void update(AdministratorDto resource) {
		var administrator = findById(resource.id());
		administratorMapper.update(resource, administrator);
		administratorRepository.save(administrator);
	}

	@Override
	public AdministratorDto find(UUID id) {
		var administrator = findById(id);
		return administratorMapper.map(administrator);
	}

	private Administrator findById(UUID id) {
		return administratorRepository.find(id)
		  .orElseThrow(() -> new NotFoundException("Administrator doesn't exist."));
	}
}
