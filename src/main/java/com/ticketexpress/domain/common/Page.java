package com.ticketexpress.domain.common;

import java.util.List;

public record Page<T> (List<T> items, int totalPages, long totalElements) {}


