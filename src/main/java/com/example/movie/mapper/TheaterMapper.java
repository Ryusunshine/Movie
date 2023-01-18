package com.example.movie.mapper;

import com.example.movie.dto.TheaterDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TheaterMapper {
    TheaterDTO selectTheaterName(Long theater_id);
    List<TheaterDTO> selectTheaters();
    TheaterDTO selectTheaterData(Long theater_id);

    int deleteTheater(TheaterDTO theaterDTO);

    int insertTheater(TheaterDTO theaterDTO);
}
