package com.example.movie.mapper;

import com.example.movie.dto.BoardDTO;
import com.example.movie.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDTO> selectBoard();

    BoardDTO selectBoardDetail(String id);

    int insertBoard(BoardDTO boardDTO);

    int updateBoard(BoardDTO boardDTO);

    int deleteBoard(BoardDTO boardDTO);

    List<ReplyDTO> selectReply(int board_id);

    ReplyDTO selectReplyById(int id);

    int insertReply(ReplyDTO replyDTO);

    int updateReply(ReplyDTO replyDTO);

    int deleteReply(ReplyDTO replyDTO);

}
