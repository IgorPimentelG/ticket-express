package com.ticketexpress.infrastructure.adapters.db;

import com.ticketexpress.infrastructure.entities.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdministratorRepository extends JpaRepository<AdministratorEntity, UUID> {}
