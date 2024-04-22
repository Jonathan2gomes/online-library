package com.ximple.onlinelibrary.mapper;

import com.ximple.onlinelibrary.dto.ReservationOutput;
import com.ximple.onlinelibrary.model.Book;
import com.ximple.onlinelibrary.model.Reservation;
import com.ximple.onlinelibrary.model.User;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper {

    public ReservationOutput toDto(Reservation reservation) {
        return new ReservationOutput(reservation.getBook().getTitle());
    }

    public Reservation toEntity(User user, Book book) {
        return new Reservation(user, book);
    }
}
