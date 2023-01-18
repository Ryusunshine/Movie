package com.example.movie.controller;

import com.example.movie.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = {"예매내역 서비스"}, description = "예매내역 항목을 담당합니다.")
@Controller
public class OrderController {

    @Autowired
    OrderService os;

    @ApiOperation(value = "예매 취소", notes = "선택한 예매 내역을 취소한다.")
    @ResponseBody
    @PutMapping("/ticket")
    public String updateOrderStatus(Long id) {
        return os.updateOrderStatus(id);
    }
}
