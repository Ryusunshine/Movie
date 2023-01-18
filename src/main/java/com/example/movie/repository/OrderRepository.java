package com.example.movie.repository;

import com.example.movie.dto.OrderDTO;
import com.example.movie.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class OrderRepository {

    @Autowired
    OrderMapper om;

    public ArrayList<OrderDTO> selectOrderByMember(Long member_id) {
        return om.selectOrderByMember(member_id);
    }

    public ArrayList<Long> selectMovieIds(Long member_id) {
        return om.selectMovieIds(member_id);
    }

    public ArrayList<Long> selectTheaterIds(Long member_id) {
        return om.selectTheaterIds(member_id);
    }

    public ArrayList<OrderDTO> selectCancelOrder(Long member_id) {
        return om.selectCancelOrder(member_id);
    }

    public ArrayList<Long> selectCancelMovieIds(Long member_id) {
        return om.selectCancelMovieIds(member_id);
    }

    public ArrayList<Long> selectCancelTheaterIds(Long member_id) {
        return om.selectCancelTheaterIds(member_id);
    }
    public OrderDTO selectOrderById(Long member_id) {
        return om.selectOrderById(member_id);
    }

    public Long selectMovieIdOne(Long member_id) {
        return om.selectMovieIdOne(member_id);
    }

    public Long selectTheaterIdOne(Long member_id) {
        return om.selectTheaterIdOne(member_id);
    }

    public int updateOrderStatus(Long id) {
        return om.updateOrderStatus(id);
    }
}
