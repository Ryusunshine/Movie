package com.example.movie.controller;

import com.example.movie.dto.CommentDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class CommentController {

    @Autowired
    CommentService cs;
//    @Autowired
//    LoginService ls;

//    @GetMapping("movie/{movieId}")
//    public String movieDetail(@PathVariable long movieId, Model model) {
//        return "movie_detail";
//    }

    @PostMapping("/api/comment/add")
    public int insertComment(@RequestBody CommentDTO commentDTO) {
        return cs.insertComment(commentDTO);
    }
    @ApiOperation(value = "마이 페이지에서 평점 삭제", notes = "마이 페이지 내에서 내 평점을 삭제한다.")
    @DeleteMapping("/member/user-comment/{id}")
    public String deleteComment(@PathVariable Long id) {
        return cs.deleteCommentR(id);
    }

    @GetMapping("/api/comments/{movieCd}")
    public List<CommentDTO> selectAllCommentByMovieId(@PathVariable int movieCd) {
        return cs.selectAllCommentByMovieId(movieCd);
    }

    @PutMapping("/api/comment/GoodUp/{commentId}")
    public int updateGoodNumOneUpByCommentId(@PathVariable int commentId) {
//        System.out.println("updateGoodNumOneUpByCommentId");
        return cs.updateGoodNumOneUpByCommentId(commentId);
    }

    @PutMapping("/api/comment/BadUp/{commentId}")
    public int updateBadNumOneUpByCommentId(@PathVariable int commentId) {
//        System.out.println("updateBadNumOneUpByCommentId");
        return cs.updateBadNumOneUpByCommentId(commentId);
    }

    @DeleteMapping("/api/comment/delete/{commentId}")
    public int deleteComment(@PathVariable long commentId) {
        return cs.deleteComment(commentId);
    }

    @PostMapping("/api/comment/{commentId}")
    public CommentDTO getComment(@PathVariable int commentId) {
        return cs.selectCommentByCommentId(commentId);
    }

    @PutMapping("/api/comment/update/{commentId}")
    public int updateComment(@PathVariable int commentId, @RequestBody CommentDTO commentDTO) {
        return cs.updateComment(commentDTO);
    }
}
