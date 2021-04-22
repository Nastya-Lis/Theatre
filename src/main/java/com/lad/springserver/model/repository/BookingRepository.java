package com.lad.springserver.model.repository;

import com.lad.springserver.model.entity.Booking;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends IRepository<Booking>{
    @Override
    List<Booking> findAll(Sort sort);
}
