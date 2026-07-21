package com.aspire.usermanagement.service.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.aspire.usermanagement.exception.CustomApplicationException;

public class DateUtil {
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private DateUtil() {
		// prevent instantiation
	}

	public static LocalDate toLocalDate(String date) {
		if (date == null || date.trim().isEmpty()) {
			return null;
		}

		try {
			return LocalDate.parse(date, DATE_TIME_FORMATTER);

		} catch (DateTimeParseException dtpe) {
			throw new CustomApplicationException("Invalid date format and date format should be dd/MM/yyyy");
		}

	}

	public static String toString(LocalDate date) {
		if (date == null) {
			return null;
		}

		return date.format(DATE_TIME_FORMATTER);
	}
}

