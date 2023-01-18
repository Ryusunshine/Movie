package com.example.movie.service;

import com.example.movie.dto.OrderDTO;
import com.example.movie.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

    @Autowired
    OrderRepository or;

    public ArrayList<OrderDTO> selectOrderByMember(Long member_id) {

        if (or.selectOrderByMember(member_id) == null) {
            return null;
        } else {
            return or.selectOrderByMember(member_id);
        }
    }


    public ArrayList<OrderDTO> selectCancelOrder(Long member_id) {
        return or.selectCancelOrder(member_id);
    }


    public OrderDTO selectOrderById(Long member_id) {
        if (or.selectOrderById(member_id) == null) {
            return null;
        } else {
            return or.selectOrderById(member_id);
        }
    }

    public String updateOrderStatus(Long id) {
        int result = or.updateOrderStatus(id);

        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }

}
