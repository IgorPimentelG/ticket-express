package com.ticketexpress.application.mappers;

import com.ticketexpress.domain.dtos.AdministratorDto;
import com.ticketexpress.domain.Administrator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdministratorMapper {

	AdministratorMapper INSTANCE = Mappers.getMapper( AdministratorMapper.class );

	AdministratorDto map(Administrator administrator);
	void update(AdministratorDto source, @MappingTarget Administrator target);
}
