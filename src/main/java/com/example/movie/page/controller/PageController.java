package com.example.movie.page.controller;

import com.example.movie.dto.MovieDTO;
import com.example.movie.service.MovieService;
import com.example.movie.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PageController {
    private final MovieService ms;

    @GetMapping("/")
    public String index(Model model) {
        ArrayList<HashMap<String, String>> rankLists = ms.selectDailyRank();
        for (HashMap<String, String> rankList : rankLists) {
            String str = rankList.get("movie_img");
            String[] splitArray = str.split("\\|");
            rankList.put("movie_img", splitArray[0]);
        }

        model.addAttribute("rankLists", rankLists);
        return "index";
    }

    @GetMapping("/movie")
    public String movieList() {
        return "movie";
    }

    @GetMapping("/movie/{movieCode}")
    public String movieDetail(@PathVariable int movieCode, Model model) {
        model.addAttribute("movieCode", movieCode);
        return "movie_detail";
    }



}
