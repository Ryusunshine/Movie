package com.example.movie.repository;

import com.example.movie.dto.BoardDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {

    @Autowired
    BoardMapper bm;

    public List<BoardDTO> selectBoard() {
        List<BoardDTO> list = bm.selectBoard();
        return list;
    }

    public BoardDTO selectBoardDetail(String id) {
        return bm.selectBoardDetail(id);
    }

    public int insertBoard(BoardDTO boardDTO) {
        return bm.insertBoard(boardDTO);
    }

    public int updateBoard(BoardDTO boardDTO) {
        return bm.updateBoard(boardDTO);
    }

    public int deleteBoard(BoardDTO boardDTO) {
        return bm.deleteBoard(boardDTO);
    }

    public List<ReplyDTO> selectReply(int board_id) {
        return bm.selectReply(board_id);
    }

    public ReplyDTO selectReplyById(int id) {
        return bm.selectReplyById(id);
    }

    public int insertReply(ReplyDTO replyDTO) {
        return bm.insertReply(replyDTO);
    }

    public int updateReply(ReplyDTO replyDTO) {
        return bm.updateReply(replyDTO);
    }

    public int deleteReply(ReplyDTO replyDTO) {
        return bm.deleteReply(replyDTO);
    }

}
