package com.ximple.onlinelibrary.service;

import com.ximple.onlinelibrary.dto.ReservationDto;
import com.ximple.onlinelibrary.dto.ReservationOutput;

import java.util.List;

public interface ReservationService {

    void reserveBook(ReservationDto reservation);

    List<ReservationOutput> listReservationByUserName(String userName);

}
