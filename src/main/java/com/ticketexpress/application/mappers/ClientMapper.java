package com.ticketexpress.application.mappers;

import com.ticketexpress.domain.common.Page;
import com.ticketexpress.domain.dtos.ClientDto;
import com.ticketexpress.domain.Client;
import org.mapstruct.*;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClientMapper {

	ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );

	Client map(ClientDto source);
	ClientDto map(Client source);
	List<ClientDto> map(List<Client> source);
	Page<ClientDto> map(Page<Client> source);
	void update(ClientDto source, @MappingTarget Client target);
}
