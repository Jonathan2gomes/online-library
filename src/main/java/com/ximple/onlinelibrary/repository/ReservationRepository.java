package com.ximple.onlinelibrary.repository;

import com.ximple.onlinelibrary.model.Reservation;
import com.ximple.onlinelibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByUser(User user);
}
