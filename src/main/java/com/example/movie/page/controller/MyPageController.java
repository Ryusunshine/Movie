package com.example.movie.page.controller;

import com.example.movie.dto.*;
import com.example.movie.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

@Api(tags = {"마이페이지 서비스"}, description = "마이페이지 항목을 담당합니다.")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MyPageController {
    private final MemberService ms;
    private final OrderService os;
    private final MovieService movieService;
    private final TheaterService ts;
    private final CommentService cs;

    @GetMapping
    @ApiOperation(value = "마이페이지 홈 페이지 조회", notes = "최근 예매내역, 댓글 수, 내 정보를 조회한다.")
    public String myPage(Model model, @ApiIgnore Authentication authentication) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());

        ArrayList<OrderDTO> orderList = os.selectOrderByMember(memberDTO.getId());

        OrderDTO order = os.selectOrderById(memberDTO.getId());
        MovieDTO movie = movieService.selectMovieImg(memberDTO.getId());
        DailyMovieDTO movieDTO = movieService.selectMovieName(memberDTO.getId());
        TheaterDTO theaterDTO = ts.selectTheaterName(memberDTO.getId());

        ArrayList<CommentDTO> commentList = cs.selectComment(memberDTO.getId());

        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("orderList", orderList);
        model.addAttribute("recentOrder", order);
        model.addAttribute("recentMovieImg", movie);
        model.addAttribute("recentMovie", movieDTO);
        model.addAttribute("recentTheater", theaterDTO);
        model.addAttribute("commentList", commentList);

        return "/mypage/mypage";
    }

    @ApiOperation(value = "마이페이지 유저상세정보 조회", notes = "내 정보를 조회한다.")
    @GetMapping("/user-detail")
    public String userDetail(@ApiIgnore Authentication authentication, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-detail";
    }

    @ApiOperation(value = "이름 변경 팝업창", notes = "이름 변경을 위한 팝업창을 출력한다.")
    @GetMapping("/user-edit/name")
    public String userEditName(@ApiIgnore Authentication authentication, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-edit-name";
    }

    @ApiOperation(value = "이름 변경", notes = "사용자의 이름을 변경한다.")
    @ResponseBody
    @PostMapping("/user-edit/name")
    public String updateName(MemberDTO memberDTO, @ApiIgnore Authentication authentication) {
        MemberDTO member = ms.selectMemberDetail(authentication.getName());
        member.setName(memberDTO.getName());
        return ms.updateMemberName(member);
    }

    @ApiOperation(value = "비밀번호 변경 팝업창", notes = "비밀번호 변경을 위한 팝업창을 출력한다.")
    @GetMapping("/user-edit/password")
    public String userEditPassword(@ApiIgnore Authentication authentication, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-edit-password";
    }

    @ApiOperation(value = "비밀번호 변경", notes = "사용자의 비밀번호를 변경한다.")
    @ResponseBody
    @PostMapping("/user-edit/password")
    public String updatePassword(MemberDTO memberDTO, @ApiIgnore Authentication authentication) {
        MemberDTO member = ms.selectMemberDetail(authentication.getName());
        member.setPassword(memberDTO.getPassword());
        return ms.updateMemberPassword(member);
    }

    @ApiOperation(value = "마이페이지 내 평점 조회", notes = "내가 쓴 평점을 조회한다.")
    @GetMapping("/user-comment")
    public String userComment(@ApiIgnore Authentication authentication, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        ArrayList<CommentDTO> commentList = cs.selectComment(memberDTO.getId());
        List<DailyMovieDTO> movieList = movieService.selectMovieNameByCode(memberDTO.getId());

        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("commentList", commentList);
        model.addAttribute("movieList", movieList);
        return "/mypage/user-comment";
    }

    @ApiOperation(value = "마이페이지 예매내역 조회", notes = "예매 내역, 예매 취소 내역을 조회한다.")
    @GetMapping("/user-order")
    public String userOrder(@ApiIgnore Authentication authentication, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());

        ArrayList<OrderDTO> orderList = os.selectOrderByMember(memberDTO.getId());
        ArrayList<OrderDTO> cancelList = os.selectCancelOrder(memberDTO.getId());

        ArrayList<DailyMovieDTO> movieList = movieService.selectMovieNames(memberDTO.getId());
        ArrayList<MovieDTO> movie = movieService.selectMovieImgs(memberDTO.getId());
        ArrayList<TheaterDTO> theaterList = ts.selectTheaterNames(memberDTO.getId());

        ArrayList<DailyMovieDTO> movieCancelList = movieService.selectCancelMovieNames(memberDTO.getId());
        ArrayList<TheaterDTO> theaterCancelList = ts.selectCancelTheaterName(memberDTO.getId());

        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("orderList", orderList);
        model.addAttribute("cancelList", cancelList);

        model.addAttribute("movieList", movieList);
        model.addAttribute("movie", movie);
        model.addAttribute("theaterList", theaterList);

        model.addAttribute("movieCancelList", movieCancelList);
        model.addAttribute("theaterCancelList", theaterCancelList);
        return "/mypage/user-order";
    }

    @ApiOperation(value = "회원 탈퇴", notes = "회원 탈퇴 페이지 조회한다.")
    @GetMapping("/withdrawal")
    public String withdraw() {
        return "mypage/withdrawal";
    }

    @ApiOperation(value = "영화관 정보 조회", notes = "극장의 정보를 조회한다.")
    @GetMapping("/theater/detail/{id}")
    public String theaterDetail(@PathVariable Long id, Model model) {
        TheaterDTO theater = ts.selectTheaterData(id);
        model.addAttribute("theater", theater);
        return "mypage/map";
    }

}
