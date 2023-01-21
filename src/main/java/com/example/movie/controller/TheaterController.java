package com.example.movie.controller;

import com.example.movie.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TheaterController {
    @Autowired
    TheaterService ts;

}
