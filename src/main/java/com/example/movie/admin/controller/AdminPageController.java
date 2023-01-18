package com.example.movie.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = {"어드민 페이지"}, description = "관리자페이지 조회를 담당합니다.")
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @ApiOperation(value = "관리자 페이지 메인 화면", notes = "관리자 페이지의 메인 화면을 출력한다.")
    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }

    @ApiOperation(value = "관리자 페이지 회원 리스트 페이지", notes = "관리자 페이지의 회원 리스트 페이지를 출력한다.")
    @GetMapping("/memberList")
    public String memberList() {
        return "admin/memberlist";
    }

    @ApiOperation(value = "관리자 페이지 극장 리스트 페이지", notes = "관리자 페이지의 극장 리스트 페이지를 출력한다.")
    @GetMapping("/theaterList")
    public String theaterList() {
        return "admin/theaterlist";
    }

    @ApiOperation(value = "극장 추가 페이지", notes = "극장 추가 페이지를 출력한다.")
    @GetMapping("/addTheater")
    public String addTheater() {
        return "admin/addtheater";
    }
}
