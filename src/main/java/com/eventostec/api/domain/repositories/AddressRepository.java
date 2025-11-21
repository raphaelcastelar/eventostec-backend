package com.eventostec.api.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventostec.api.domain.address.Address;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
