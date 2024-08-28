package com.ticketexpress.infrastructure.mappers;

import com.ticketexpress.domain.Client;
import com.ticketexpress.infrastructure.entities.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

	ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );

	Client map(ClientEntity source);
	ClientEntity map(Client source);
	List<Client> map(List<ClientEntity> source);
}
