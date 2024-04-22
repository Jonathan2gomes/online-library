package com.ximple.onlinelibrary.service;

import com.ximple.onlinelibrary.dto.ReservationDto;
import com.ximple.onlinelibrary.dto.ReservationOutput;
import com.ximple.onlinelibrary.exception.NotFoundException;
import com.ximple.onlinelibrary.mapper.BookMapper;
import com.ximple.onlinelibrary.mapper.ReservationMapper;
import com.ximple.onlinelibrary.mapper.UserMapper;
import com.ximple.onlinelibrary.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final ReservationMapper reservationMapper;
    private final UserMapper userMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserService userService, BookService bookService, BookMapper bookMapper, ReservationMapper reservationMapper, UserMapper userMapper) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.bookService = bookService;
        this.bookMapper = bookMapper;
        this.reservationMapper = reservationMapper;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public void reserveBook(ReservationDto reservation) {
        var user = userService.findByUsername(reservation.user());
        var book = bookService.findByName(reservation.bookName());

        reservationRepository.save(reservationMapper.toEntity(userMapper.toEntity(user), bookMapper.toEntity(book)));
        log.info("Book reserved");
    }

    @Override
    public List<ReservationOutput> listReservationByUserName(String userName) {
        var user = userService.findByUsername(userName);
        var reservation = reservationRepository.findByUser(userMapper.toEntity(user)).orElseThrow(() -> new NotFoundException("User not found"));
        return List.of(reservationMapper.toDto(reservation));
    }
}
