package com.example.movie.mapper;

import com.example.movie.dto.TheaterDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TheaterMapper {
    List<TheaterDTO> selectTheaters();
    TheaterDTO selectTheaterData(String selectedTheater);

    int deleteTheater(TheaterDTO theaterDTO);

    int insertTheater(TheaterDTO theaterDTO);

    int insertSeat(TheaterDTO theaterDTO);

    List<TheaterDTO> findTheaters(String selectedTheater, String movieName, String movieDate);
}
