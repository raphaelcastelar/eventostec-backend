package com.eventostec.api.service;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRequestDTO;
import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.repositories.CouponRepository;
import com.eventostec.api.domain.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    public Coupon addCouponsToEvent(UUID eventId, CouponRequestDTO couponData) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));


        Coupon newCoupon = new Coupon();
        newCoupon.setCode(couponData.code());
        newCoupon.setDiscount(couponData.discount());
        newCoupon.setValid(couponData.valid());
        newCoupon.setEvent(event);

        return couponRepository.save(newCoupon);
    }

}
