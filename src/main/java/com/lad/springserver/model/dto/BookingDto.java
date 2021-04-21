package com.lad.springserver.model.dto;

import com.lad.springserver.model.entity.Performances;
import com.lad.springserver.model.entity.Users;
import lombok.Data;

@Data
public class BookingDto extends AbstractDto{
    private int amount;
    private Users user;
    private Performances performance;
}
