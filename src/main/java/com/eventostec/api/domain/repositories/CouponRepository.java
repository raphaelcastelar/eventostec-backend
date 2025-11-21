package com.eventostec.api.domain.repositories;

import com.eventostec.api.domain.coupon.Coupon;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, UUID> {
}
