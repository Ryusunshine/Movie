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

    public TheaterDTO selectTheaterName(Long theater_id) {
        return tm.selectTheaterName(theater_id);
    }

    public List<TheaterDTO> selectTheaters() {
        return tm.selectTheaters();
    }

    public TheaterDTO selectTheaterData(Long theater_id) {
        return tm.selectTheaterData(theater_id);
    }


    public int deleteTheater(TheaterDTO theaterDTO) {
        return tm.deleteTheater(theaterDTO);
    }

    public int insertTheater(TheaterDTO theaterDTO) {
        return tm.insertTheater(theaterDTO);
    }
}
