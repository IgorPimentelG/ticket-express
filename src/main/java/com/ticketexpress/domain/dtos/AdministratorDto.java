package com.ticketexpress.domain.dtos;

import java.util.UUID;

public record AdministratorDto(
  UUID id,
  String fullName,
  String email,
  String photo
) {}
