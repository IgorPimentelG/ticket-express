package com.ticketexpress.infrastructure.mappers;

import com.ticketexpress.domain.Administrator;
import com.ticketexpress.infrastructure.entities.AdministratorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdministratorMapper {

	AdministratorMapper INSTANCE = Mappers.getMapper( AdministratorMapper.class );

	Administrator map(AdministratorEntity source);
	AdministratorEntity map(Administrator source);
}
