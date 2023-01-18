package com.example.movie.admin.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.TheaterDTO;
import com.example.movie.service.MemberService;
import com.example.movie.service.TheaterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"어드민 서비스"}, description = "관리자페이지 서비스를 담당합니다.")
@Slf4j
@RestController
public class AdminController {

    @Autowired
    MemberService ms;

    @Autowired
    TheaterService ts;

    @ApiOperation(value = "관리자 페이지에서 회원 조회", notes = "등록된 모든 회원들의 내용을 조회합니다.")
    @GetMapping("/admin/customers")
    public List<MemberDTO> selectCustomers() {
        return ms.selectAllCustomers();
    }

    @ApiOperation(value = "관리자 페이지에서 회원 상태 변경", notes = "회원 상태를 활성화 or 비활성화로 변경합니다.")
    @PutMapping("/admin/customers")
    public String updateCustomers(MemberDTO memberDTO) {
        ms.memberStatus(memberDTO);
        return "test";
    }

    @ApiOperation(value = "관리자 페이지에서 극장 조회", notes = "등록된 모든 극장들의 내용을 조회합니다.")
    @GetMapping("/admin/theaters")
    public List<TheaterDTO> selectTheaters() {
        return ts.selectTheaters();
    }

    @ApiOperation(value = "관리자 페이지에서 극장 추가", notes = "극장 관련 내용을 DB에 추가합니다.")
    @PostMapping("/admin/theaters")
    public String insertTheater(TheaterDTO theaterDTO) {
        return ts.insertTheater(theaterDTO);
    }

    @ApiOperation(value = "관리자 페이지에서 극장 삭제", notes = "등록되어 있는 극장을 삭제합니다.")
    @DeleteMapping("/admin/theaters")
    public String deleteTheater(TheaterDTO theaterDTO) {
        return ts.deleteTheater(theaterDTO);
    }
}
