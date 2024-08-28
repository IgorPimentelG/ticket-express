package com.ticketexpress.application;

import com.ticketexpress.application.adapters.AdministratorService;
import com.ticketexpress.application.errors.NotFoundException;
import com.ticketexpress.domain.ports.repositories.IAdministratorRepository;
import com.ticketexpress.factories.AdministratorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class AdministratorServiceTests {

	@Mock
	IAdministratorRepository administratorRepository;

	@InjectMocks
	AdministratorService administratorService;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("should update an administrator")
	void updateAdministrator() {
		var dto = AdministratorFactory.dto();
		var administrator = AdministratorFactory.entity();

		when(administratorRepository.find(any())).thenReturn(Optional.of(administrator));

		administratorService.update(dto);

		verify(administratorRepository, times(1)).save(any());
	}

	@Test
	@DisplayName("should throw an error when update administrator doesn't exist")
	void updateAdministratorError() {
		Exception exception = assertThrows(NotFoundException.class, () -> {
			when(administratorRepository.find(any())).thenReturn(Optional.empty());
			administratorService.update(AdministratorFactory.dto());
		});

		var expectedMessage = "Administrator doesn't exist.";
		var message = exception.getMessage();

		verify(administratorRepository, times(1)).find(any());
		assertEquals(expectedMessage, message);
	}

	@Test
	@DisplayName("should find a administrator by id")
	void findAdministrator() {
		var administrator = AdministratorFactory.entity();
		when(administratorRepository.find(any())).thenReturn(Optional.of(administrator));

		var result = administratorService.find(UUID.randomUUID());

		verify(administratorRepository, times(1)).find(any());
		assertEquals(result.fullName(), administrator.getFullName());
		assertEquals(result.email(), administrator.getEmail());
		assertEquals(result.photo(), administrator.getPhoto());
	}

	@Test
	@DisplayName("should throw an error when find administrator doesn't exist")
	void findAdministratorError() {
		Exception exception = assertThrows(NotFoundException.class, () -> {
			when(administratorRepository.find(any())).thenReturn(Optional.empty());

			administratorService.find(UUID.randomUUID());
		});

		var expectedMessage = "Administrator doesn't exist.";
		var message = exception.getMessage();

		verify(administratorRepository, times(1)).find(any());
		assertEquals(expectedMessage, message);
	}

}
