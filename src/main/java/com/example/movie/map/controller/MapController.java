package com.example.movie.map.controller;

import com.example.movie.dto.OrderDTO;
import com.example.movie.service.MemberService;
import com.example.movie.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Api(tags = {"알람 서비스"}, description = "예매 정보를 slack으로 전달합니다.")
@Controller
@Slf4j
public class MapController {

    @Autowired
    OrderService or;

    @Autowired
    MemberService memberService;

    @ApiOperation(value = "예매 내역 전달", notes = "slack으로 내 예매 내역을 전달합니다.")
    @ResponseBody
    @GetMapping("/send")
    public void send(OrderDTO orderDTO, String movieNm, String selectedTheater) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> request = new HashMap<>();
        request.put("username", "예매내역확인"); //slack bot name
        request.put("text",
                "예매 번호 : " + orderDTO.getId() + "\n"
                + "영화 제목 : " + movieNm + "\n"
                + "관람 극장 : " + selectedTheater + "\n"
                + "관람 일시 : " + orderDTO.getScreenDate() + "\n"
                + "관람 좌석 : " + orderDTO.getSeat() + "\n"
                + "티켓 수 : " + orderDTO.getTicketCount() + "\n"
                + "총 결제 금액 : " + orderDTO.getTotalPrice()); //전송할 메세지

        request.put("icon_emoji", "https://img.cgv.co.kr/Movie/Thumbnail/Poster/000086/86072/86072_126.jpg"); //slack bot image

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request);

        String url = "https://hooks.slack.com/services/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"; //복사한 Webhook URL 입력

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}
