package com.lad.springserver.model.repository;

import com.lad.springserver.model.entity.Booking;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends IRepository<Booking>{
    @Override
    List<Booking> findAll(Sort sort);

    @Query(value = "SELECT * FROM booking WHERE id_user =:idUser", nativeQuery = true)
    List<Booking> findBookingsByUserId(Integer idUser);

}
