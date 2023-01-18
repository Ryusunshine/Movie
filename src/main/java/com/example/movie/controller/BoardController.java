package com.example.movie.controller;

import com.example.movie.dto.BoardDTO;
import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.service.BoardService;
import com.example.movie.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"게시판 서비스"}, description = "게시판 CRUD 관련 서비스를 담당합니다.")
@Controller
public class BoardController {

    @Autowired
    BoardService bs;

    @Autowired
    MemberService ms;

    @GetMapping("/board")
    @ApiOperation(value = "전체 게시글 조회", notes = "전체 게시글을 조회한다.")
    public String selectBoard(Model model) {
        List<BoardDTO> list = bs.selectBoard();
        model.addAttribute("boardList", list);
        return "board";
    }

    @GetMapping("/board/{id}")
    @ApiOperation(value = "특정 게시글 조회", notes = "특정 게시글을 id 기준으로 조회한다.")
    public String selectBoardDetail(@PathVariable String id, Model model, Authentication authentication) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("boardList", bs.selectBoardDetail(id));
        model.addAttribute("id", id);
        return "boardDetail";
    }

    @GetMapping("/board/insert")
    @ApiOperation(value = "게시글 작성 페이지", notes = "게시글 작성 페이지로 이동한다.")
    public String insertBoard(Model model, Authentication authentication) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        model.addAttribute("memberDTO", memberDTO);
        return "boardInsert";
    }

    @ResponseBody
    @PostMapping("/api/insertBoard")
    @ApiOperation(value = "게시글 작성", notes = "게시글을 작성한다.")
    public int insertBoard(@RequestBody BoardDTO boardDTO) {
        return bs.insertBoard(boardDTO);
    }

    @GetMapping("/board/update/{id}")
    @ApiOperation(value = "게시글 수정 페이지", notes = "게시글 수정 페이지로 이동한다.")
    public String updateBoard(@PathVariable String id, Model model) {
        model.addAttribute("boardList", bs.selectBoardDetail(id));
        model.addAttribute("id", id);
        return "boardUpdate";
    }

    @ResponseBody
    @PutMapping("/api/updateBoard")
    @ApiOperation(value = "게시글 수정", notes = "게시글을 수정한다.")
    public String updateBoard(@RequestBody BoardDTO boardDTO) {
        return bs.updateBoard(boardDTO);
    }

    @ResponseBody
    @DeleteMapping("/api/deleteBoard")
    @ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제한다.")
    public String deleteBoard(BoardDTO boardDTO) {
        return bs.deleteBoard(boardDTO);
    }

    @ResponseBody
    @GetMapping("/api/selectReply/{board_id}")
    @ApiOperation(value = "리플 조회", notes = "특정 게시글의 리플을 조회한다.")
    public List<ReplyDTO> selectReply(@PathVariable int board_id) {
        return bs.selectReply(board_id);
    }

    @ResponseBody
    @GetMapping("/api/selectReplyById/{id}")
    @ApiOperation(value = "수정시 해당 리플 조회", notes = "특정 게시글의 리플을 조회한다.")
    public ReplyDTO selectReplyById(@PathVariable int id) {
        return bs.selectReplyById(id);
    }

    @ResponseBody
    @PostMapping("/api/insertReply")
    @ApiOperation(value = "리플 작성", notes = "특정 게시글의 리플을 작성한다.")
    public int insertReply(@RequestBody ReplyDTO replyDTO) {
        return bs.insertReply(replyDTO);
    }

    @ResponseBody
    @PutMapping("/api/updateReply")
    @ApiOperation(value = "리플 수정", notes = "특정 게시글의 리플을 수정한다.")
    public String updateReply(@RequestBody ReplyDTO replyDTO) {
        return bs.updateReply(replyDTO);
    }

    @ResponseBody
    @DeleteMapping("/api/deleteReply")
    @ApiOperation(value = "리플 삭제", notes = "특정 게시글의 리플을 삭제한다.")
    public String deleteReply(ReplyDTO replyDTO) {
        return bs.deleteReply(replyDTO);
    }

}
