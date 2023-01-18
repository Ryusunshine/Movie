package com.example.movie.service;

import com.example.movie.dto.BoardDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository br;

    public List<BoardDTO> selectBoard() {
        List<BoardDTO> list = br.selectBoard();
        return list;
    }

    public BoardDTO selectBoardDetail(String id) {
        return br.selectBoardDetail(id);
    }

    public int insertBoard(BoardDTO boardDTO) {
        return br.insertBoard(boardDTO);
    }

    public String updateBoard(BoardDTO boardDTO) {
        int result = 0;
        result += br.updateBoard(boardDTO);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }

    public String deleteBoard(BoardDTO boardDTO) {
        int result = 0;
        result += br.deleteBoard(boardDTO);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }

    public List<ReplyDTO> selectReply(int board_id) {
        return br.selectReply(board_id);
    }

    public ReplyDTO selectReplyById(int id) {
        return br.selectReplyById(id);
    }

    public int insertReply(ReplyDTO replyDTO) {
        return br.insertReply(replyDTO);
    }

    public String updateReply(ReplyDTO replyDTO) {
        int result = 0;
        result += br.updateReply(replyDTO);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }

    public String deleteReply(ReplyDTO replyDTO) {
        int result = 0;
        result += br.deleteReply(replyDTO);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }

}
