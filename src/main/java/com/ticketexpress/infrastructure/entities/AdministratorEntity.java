package com.ticketexpress.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_administrators")
public class AdministratorEntity extends BaseEntity {
	@Column(name = "full_name")
	private String fullName;

	private String photo;
	private String email;
}
