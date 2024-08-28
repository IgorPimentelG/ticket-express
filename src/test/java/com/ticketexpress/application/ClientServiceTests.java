package com.ticketexpress.application;

import com.ticketexpress.application.adapters.ClientService;
import com.ticketexpress.application.errors.NotFoundException;
import com.ticketexpress.domain.common.Pagination;
import com.ticketexpress.domain.ports.repositories.IClientRepository;
import com.ticketexpress.factories.ClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ClientServiceTests {

	@Mock
	IClientRepository clientRepository;

	@InjectMocks
	ClientService clientService;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("should create a client")
	void createClient() {
		var dto = ClientFactory.dto();
		clientService.create(dto);

		verify(clientRepository, times(1)).save(any());
	}

	@Test
	@DisplayName("should update a client")
	void updateClient() {
		var dto = ClientFactory.dto();
		var client = ClientFactory.entity();

		when(clientRepository.find(any())).thenReturn(Optional.of(client));

		clientService.update(dto);

		verify(clientRepository, times(1)).save(any());
	}

	@Test
	@DisplayName("should throw an error when update client doesn't exist")
	void updateClientError() {
		Exception exception = assertThrows(NotFoundException.class, () -> {
			when(clientRepository.find(any())).thenReturn(Optional.empty());
			clientService.update(ClientFactory.dto());
		});

		var expectedMessage = "Client doesn't exist.";
		var message = exception.getMessage();

		verify(clientRepository, times(1)).find(any());
		assertEquals(expectedMessage, message);
	}

	@Test
	@DisplayName("should delete a client by id")
	void deleteClient() {
		var client = ClientFactory.entity();
		when(clientRepository.find(any())).thenReturn(Optional.of(client));

		clientService.delete(UUID.randomUUID());

		verify(clientRepository, times(1)).delete(any());
	}

	@Test
	@DisplayName("should throw an error when delete client doesn't exist")
	void deleteClientError() {
		Exception exception = assertThrows(NotFoundException.class, () -> {
			when(clientRepository.find(any())).thenReturn(Optional.empty());

			clientService.delete(UUID.randomUUID());
		});

		var expectedMessage = "Client doesn't exist.";
		var message = exception.getMessage();

		verify(clientRepository, times(1)).find(any());
		assertEquals(expectedMessage, message);
	}

	@Test
	@DisplayName("should find a client by id")
	void findClient() {
		var client = ClientFactory.entity();
		when(clientRepository.find(any())).thenReturn(Optional.of(client));

		var result = clientService.find(UUID.randomUUID());

		verify(clientRepository, times(1)).find(any());
		assertEquals(result.fullName(), client.getFullName());
		assertEquals(result.email(), client.getEmail());
		assertEquals(result.CPF(), client.getCPF());
		assertEquals(result.phone(), client.getPhone());
	}

	@Test
	@DisplayName("should throw an error when find client doesn't exist")
	void findClientError() {
		Exception exception = assertThrows(NotFoundException.class, () -> {
			when(clientRepository.find(any())).thenReturn(Optional.empty());

			clientService.find(UUID.randomUUID());
		});

		var expectedMessage = "Client doesn't exist.";
		var message = exception.getMessage();

		verify(clientRepository, times(1)).find(any());
		assertEquals(expectedMessage, message);
	}

	@Test
	@DisplayName("should list clients")
	void listClients() {
		when(clientRepository.list(any())).thenReturn(ClientFactory.page());

		var pagination = new Pagination(0, 10);
		var clients = clientService.list(pagination);

		verify(clientRepository, times(1)).list(any());
		assertEquals(clients.totalPages(), 1);
		assertEquals(clients.totalElements(), 2);
		assertEquals(clients.items().size(), 2);
	}
}
