package com.example.movie.service;

import com.example.movie.dto.TheaterDTO;
import com.example.movie.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository tr;

    public TheaterDTO selectTheaterData(String selectedTheater) {
        return tr.selectTheaterData(selectedTheater);
    }


    public List<TheaterDTO> selectTheaters() {
        return tr.selectTheaters();
    }

    public String deleteTheater(TheaterDTO theaterDTO) {
        int result = tr.deleteTheater(theaterDTO);

        if (result > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    public String insertTheater(TheaterDTO theaterDTO) {
        int result = tr.insertTheater(theaterDTO);

        if (result > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    public String insertSeat(TheaterDTO theaterDTO){
        int result = tr.insertSeat(theaterDTO);
        if (result > 0){
            return "success";
        } else{
            return "failed";
        }
    }

    public List<TheaterDTO> findTheaters(String selectedTheater, String movieName, String movieDate){
        return tr.findTheaters(selectedTheater, movieName, movieDate);
    }
}
