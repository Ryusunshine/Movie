package com.example.movie.controller;

import com.example.movie.dto.InfoDTO;
import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.TicketDTO;
import com.example.movie.service.MemberService;
import com.example.movie.service.TicketService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Api(tags = {"예매 서비스"}, description = "예매 기능을 담당합니다.")
@Controller
public class TicketController {

    private final TicketService ts;
    private final MemberService ms;

    @Autowired
    public TicketController(TicketService ts, MemberService ms) {
        this.ts = ts;
        this.ms = ms;
    }

    private static Logger logger = LoggerFactory.getLogger(TicketController.class);

    @GetMapping("/ticket")
    public String ticket(){
        return "ticket";
    }

    @ApiOperation(value = "영화 정보", notes = "영화 정보를 뷰에 전달합니다.")
    @ResponseBody
    @RequestMapping(value = "crawling.do", method = {RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
    public String getMovies(){
        String gson = "";
        List<MovieDTO> movieDTOList = ts.getMovieList();
        List<InfoDTO> list = new ArrayList<InfoDTO>();
        int index = 0;
        for (MovieDTO movie : movieDTOList) {
            index += 1;
            String movieNm = movie.getMovieNm();
            String movieImg = movie.getMovieImg();
            InfoDTO infoDto = new InfoDTO(index, movieImg, movieNm);
            list.add(infoDto);
        }
        gson = new Gson().toJson(list);
        return gson;
    }

    @ApiOperation(value = "티켓 정보 저장", notes = "티켓의 일부정보를 객체에 저장합니다.")
    @RequestMapping(value = "moveSeat.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String moveSeat(Model model, TicketDTO dto) {

        model.addAttribute("ticket", dto);

        return "seat";
    }

    @ApiOperation(value = "티켓 정보 저장", notes = "티켓의 정보를 DB에 저장 & 결제 페이지를 담당합니다")
    @RequestMapping (value = "payticket.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String payTicket(Model model, TicketDTO dto, @ApiIgnore Authentication authentication){
        String temp = dto.getSelectedTheater().replaceAll("\\s+", " "); //영화관 정보 세분화후 저장
        String[] tempList = temp.split(" ");
        dto.setSelectedTheater(tempList[0]);
        dto.setTheaterDetail(tempList[1]);

        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        dto.setMemberId(memberDTO.getId());

        int result = ts.insertTicket(dto);

        String money = dto.getPayMoney();
        model.addAttribute("payMoney",  money); // 결제 금액을 결제 페이지로 전달

        return "payticket";
    }

    @ApiOperation(value = "예매 완료 페이지", notes = "예매 완료 페이지의 정보를 전달합니다.")
    @RequestMapping(value = "complete.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String payComplete(Model model) {

        TicketDTO ticket = ts.getTicket();
        ts.updateTicket(ticket.getId()); // 결제 날짜 & 결제 성공 여부 업데이트
        TicketDTO dto = ts.getTicket();
        logger.info("예매완료 = {}"+ dto.toString());
        MovieDTO movie = ts.getMovieDTO(dto.getMovieTitle()); //영화 제목으로 영화 이미지url 추출
        String movieUrl = movie.getMovieImg().split("\\|")[0];
        movie.setMovieImg(movieUrl);

        model.addAttribute("ticket", dto);
        model.addAttribute("movie", movie);


        return "payComplete";
    }

    @ApiOperation(value = "결제 기능", notes = "결제 메시지를 전달합니다.")
    @PostMapping("/payKakao")
    @ResponseBody
    public String payKakao(@RequestParam String amount, HttpSession session, Model model) {

        if (amount != "0" || amount !=null){
            return "결제가 성공되었습니다.";
    } else {
            return "결제가 실패했습니다.";
        }
}
}







