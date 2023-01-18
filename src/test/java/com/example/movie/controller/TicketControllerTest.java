package com.example.movie.controller;

import com.example.movie.dto.MovieDTO;
import com.example.movie.service.TicketService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TicketControllerTest {
    private static Logger logger = LoggerFactory.getLogger(TicketControllerTest.class);
    @Autowired
    TicketService ts;

    @Test
    void payComplete() {
        String name = ts.getTicket().getMovieTitle();
        String img = ts.getMovieImg(name);
        logger.info("{name}: "+ img);
    }
}