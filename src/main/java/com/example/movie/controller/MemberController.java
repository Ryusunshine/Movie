package com.example.movie.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService ms;

    @RequestMapping("/my")
    ModelAndView myView(Authentication authentication) {
        System.out.println("authentication = " + authentication);
        System.out.println("authentication.getName = " + authentication.getName());
        MemberDTO memberDTO = Optional.ofNullable(ms.finByMemberId(authentication.getName()))
                .map(u -> MemberDTO.builder().userId(u.getUserId()).email(u.getEmail()).password(u.getPassword()).role(u.getRole()).build())
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
        System.out.println("memberDTO = " + memberDTO);
        ModelAndView modelAndView = new ModelAndView("/my");
        modelAndView.addObject("memberDTO", memberDTO);

        return modelAndView;
    }

    @GetMapping("/goLogin")
    public String loginPage() {
        return "/login";
    }
    
    @GetMapping("/signup")
    public String signupPage() {
        return "/signup";
    }

    @PostMapping("/signup")
    public void createUser(@Valid MemberDTO memberDTO, HttpServletResponse response){
        ms.createUser(memberDTO);
//        response.sendRedirect("/login");
    }


    @ApiOperation(value = "회원 탈퇴", notes = "회원 탈퇴를 수행한다.(활성화 or 비활성화)")
    @ResponseBody
    @PostMapping("/withdrawal")
    public String withdrawal(@ApiIgnore Authentication authentication) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());

        return ms.updateIsMemberStatus(memberDTO);
    }

}
