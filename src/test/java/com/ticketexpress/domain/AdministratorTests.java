package com.ticketexpress.domain;

import com.ticketexpress.domain.errors.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AdministratorTests {

	@Test
	@DisplayName("should create an administrator")
	public void testCreateAdministrator() {
		var administrator = new Administrator("any full name", "exemple@mail.com");
		assertEquals(administrator.getFullName(), "any full name");
		assertEquals(administrator.getEmail(), "exemple@mail.com");
	}

	@Test
	@DisplayName("should throws an error when full name is empty")
	public void testEmptyFullName() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			new Administrator("", "exemple@mail.com");
		});

		String expectedMessage = "Full name cannot be empty.";
		var messages = new ArrayList<String>(
		  Arrays.asList(exception.getMessage().replace("[", "").replace("]", "").split(","))
		);

		assertTrue(messages.contains(expectedMessage));
	}

	@Test
	@DisplayName("should throws an error when email is invalid")
	public void testInvalidEmail() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			new Administrator("any name", "exemple@");
		});

		String expectedMessage = "E-mail invalid.";
		var messages = new ArrayList<String>(
		  Arrays.asList(exception.getMessage().replace("[", "").replace("]", "").split(","))
		);

		assertTrue(messages.contains(expectedMessage));
	}

	@Test
	@DisplayName("should throws an error when email is empty")
	public void testEmptyEmail() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			new Administrator("any name", "");
		});

		String expectedMessage = "E-mail cannot be empty.";
		var messages = new ArrayList<String>(
		  Arrays.asList(exception.getMessage().replace("[", "").replace("]", "").split(","))
		);

		assertTrue(messages.contains(expectedMessage));
	}

	@Test
	@DisplayName("should throws an error when photo is invalid")
	public void testInvalidPhoto() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			var administrator = new Administrator("any name", "exemple@mail.com");
			administrator.addPhoto("any_photo.gif");
		});

		String expectedMessage = "Extension gif is not allowed.";
		var messages = new ArrayList<String>(
		  Arrays.asList(exception.getMessage().replace("[", "").replace("]", "").split(","))
		);

		assertTrue(messages.contains(expectedMessage));
	}
}
