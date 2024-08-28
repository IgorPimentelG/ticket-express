package com.ticketexpress.domain;

import com.ticketexpress.domain.errors.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTests {

	@Test
	@DisplayName("should create a client")
	public void testCreateClient() {
		var client = new Client(
		  "any name",
		  "(83) 99190-1111",
		  "any@mail.com",
		  "111.111.111-11",
		  LocalDate.of(1990, 1, 1)
		);

		assertEquals(client.getFullName(), "any name");
		assertEquals(client.getPhone(), "(83) 99190-1111");
		assertEquals(client.getEmail(), "any@mail.com");
		assertEquals(client.getCPF(), "111.111.111-11");
		assertEquals(client.getBirthDate(), LocalDate.of(1990, 1, 1));
		assertEquals(client.calculateAge(), 34);
	}

	@Test
	@DisplayName("should throws an error when full name is empty")
	public void testEmptyFullName() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			new Client(
			  "",
			  "(83) 99190-1111",
			  "any@mail.com",
			  "111.111.111-11",
			  LocalDate.of(1990, 1, 1)
			);
		});

		String expectedMessage = "Full name cannot be empty.";
		var messages = new ArrayList<String>(
		  Arrays.asList(exception.getMessage().replace("[", "").replace("]", "").split(","))
		);

		assertTrue(messages.contains(expectedMessage));
	}

	@Test
	@DisplayName("should throws an error when phone is invalid")
	public void testPhoneInvalid() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			var client = new Client(
			  "any name",
			  "83991901111",
			  "any@mail.com",
			  "111.111.111-11",
			  LocalDate.of(1990, 1, 1)
			);
		});

		String expectedMessage = "Phone number invalid.";
		var messages = new ArrayList<String>(
		  Arrays.asList(exception.getMessage().replace("[", "").replace("]", "").split(","))
		);

		assertTrue(messages.contains(expectedMessage));
	}

	@Test
	@DisplayName("should throws an error when e-mail is invalid")
	public void testEmailInvalid() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			new Client(
			  "any name",
			  "(83) 99190-1111",
			  "any@",
			  "111.111.111-11",
			  LocalDate.of(1990, 1, 1)
			);
		});

		String expectedMessage = "E-mail invalid.";
		var messages = new ArrayList<String>(
		  Arrays.asList(exception.getMessage().replace("[", "").replace("]", "").split(","))
		);

		assertTrue(messages.contains(expectedMessage));
	}

	@Test
	@DisplayName("should throws an error when CPF is invalid")
	public void testCPFInvalid() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			new Client(
			  "any name",
			  "(83) 99190-1111",
			  "any@mail.com",
			  "11111111111",
			  LocalDate.of(1990, 1, 1)
			);
		});

		String expectedMessage = "CPF invalid.";
		var messages = new ArrayList<String>(
		  Arrays.asList(exception.getMessage().replace("[", "").replace("]", "").split(","))
		);

		assertTrue(messages.contains(expectedMessage));
	}

	@Test
	@DisplayName("should throws an error when birth date is invalid")
	public void testBirthDateInvalid() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			new Client(
			  "any name",
			  "(83) 99190-1111",
			  "any@mail.com",
			  "111.111.111-11",
			  LocalDate.of(2024, 1, 1)
			);
		});

		String expectedMessage = "No minors allowed.";
		var messages = new ArrayList<String>(
		  Arrays.asList(exception.getMessage().replace("[", "").replace("]", "").split(","))
		);

		assertTrue(messages.contains(expectedMessage));
	}
}