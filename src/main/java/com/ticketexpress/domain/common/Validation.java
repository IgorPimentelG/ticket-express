package com.ticketexpress.domain.common;

import com.ticketexpress.domain.errors.ValidationException;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

public abstract class Validation {

	public static ValidationBuilder build() {
		return new ValidationBuilder();
	}

	public static class ValidationBuilder {
		private final List<String> validations = new ArrayList<>();
		private Object value;

		public ValidationBuilder forValue(Object value) {
			this.value = value;
			return this;
		}

		public ValidationBuilder max(int maxLength, String message) {
			if (((String) value).length() > maxLength) {
				validations.add(message);
			}
			return this;
		}

		public ValidationBuilder min(int minLength, String message) {
			if (((String) value).length() < minLength) {
				validations.add(message);
			}
			return this;
		}

		public ValidationBuilder notEmpty(String message) {
			if (((String) value).isEmpty()) {
				validations.add(message);
			}
			return this;
		}

		public ValidationBuilder required(String message) {
			if (value != null) {
				validations.add(message);
			}
			return this;
		}

		public ValidationBuilder email() {
			applyRegex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "E-mail invalid.");
			return this;
		}

		public ValidationBuilder phone() {
			applyRegex("^\\([1-9]{2}\\) [9]{0,1}[6-9]{1}[0-9]{3}\\-[0-9]{4}$", "Phone number invalid.");
			return this;
		}

		public ValidationBuilder cnpj() {
			applyRegex("^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$", "CNPJ invalid.");
			return this;
		}

		public ValidationBuilder cpf() {
			applyRegex("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", "CPF invalid.");
			return this;
		}

		public ValidationBuilder ofLegalAge() {
			var age = LocalDate.now().getYear() - ((LocalDate) value).getYear();

			if (age < 18) {
				validations.add("No minors allowed.");
			}
			return this;
		}

		public ValidationBuilder extension(List<String> allow) {
			var ext = ((String) value).split("\\.")[1];

			if (!allow.contains(ext)) {
				validations.add("Extension " + ext + " is not allowed.");
			}
			return this;
		}

		public void validate() {
			if (!validations.isEmpty()) {
				throw new ValidationException(validations.toString());
			}
		}

		private void applyRegex(String regex, String message) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher((String) value);

			if (!matcher.matches()) {
				validations.add(message);
			}
		}
	}
}