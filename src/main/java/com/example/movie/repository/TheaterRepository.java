package com.example.movie.repository;

import com.example.movie.dto.TheaterDTO;
import com.example.movie.mapper.TheaterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TheaterRepository {

    @Autowired
    TheaterMapper tm;

    public List<TheaterDTO> selectTheaters() {
        return tm.selectTheaters();
    }

    public TheaterDTO selectTheaterData(String selectedTheater) {
        return tm.selectTheaterData(selectedTheater);
    }

    public int deleteTheater(TheaterDTO theaterDTO) {
        return tm.deleteTheater(theaterDTO);
    }

    public int insertTheater(TheaterDTO theaterDTO) {
        return tm.insertTheater(theaterDTO);
    }

    public int insertSeat(TheaterDTO theaterDTO){return tm.insertSeat(theaterDTO);}

    public List<TheaterDTO> findTheaters(String selectedTheater, String movieName, String movieDate){return tm.findTheaters(selectedTheater, movieName, movieDate);}
}
