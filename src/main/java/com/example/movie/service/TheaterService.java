package com.example.movie.service;

import com.example.movie.dto.TheaterDTO;
import com.example.movie.repository.OrderRepository;
import com.example.movie.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository tr;

    @Autowired
    OrderRepository or;

    public TheaterDTO selectTheaterData(Long theater_id) {
        return tr.selectTheaterData(theater_id);
    }

    public TheaterDTO selectTheaterName(Long member_id) {

        if (or.selectTheaterIdOne(member_id) == null) {
            return null;
        } else {
            Long id = or.selectTheaterIdOne(member_id);
            return tr.selectTheaterName(id);
        }
    }

    public ArrayList<TheaterDTO> selectTheaterNames(Long member_id) {
        ArrayList<Long> ids = or.selectTheaterIds(member_id);
        ArrayList<TheaterDTO> theaterList = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            theaterList.add(tr.selectTheaterName(ids.get(i)));
        }

        return theaterList;
    }

    public ArrayList<TheaterDTO> selectCancelTheaterName(Long member_id) {
        ArrayList<Long> ids = or.selectCancelTheaterIds(member_id);
        ArrayList<TheaterDTO> theaterList = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            theaterList.add(tr.selectTheaterName(ids.get(i)));
        }

        return theaterList;
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
}
