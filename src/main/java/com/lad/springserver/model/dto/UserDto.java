package com.lad.springserver.model.dto;

import com.lad.springserver.model.entity.Booking;
import com.lad.springserver.model.entity.Roles;
import lombok.Data;

import java.util.Collection;

@Data
public class UserDto extends AbstractDto{
    private String login;
    private String password;
    private String email;
    private Collection<BookingDto> bookings;
    private Integer roleId;
}
