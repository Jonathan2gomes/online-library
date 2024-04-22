package com.ximple.onlinelibrary.resource;


import com.ximple.onlinelibrary.dto.ReservationDto;
import com.ximple.onlinelibrary.dto.ReservationOutput;
import com.ximple.onlinelibrary.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{username}")
    public List<ReservationOutput> getReservations(@PathVariable String username) {
        return reservationService.listReservationByUserName(username);
    }

    @PostMapping
    public ResponseEntity<String> reserveBook(@RequestBody ReservationDto reservation) {
        reservationService.reserveBook(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book reserved");
    }
}
