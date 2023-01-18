package com.example.movie.mapper;

import com.example.movie.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CommentMapper {
    int insertComment(CommentDTO commentDTO);
    int updateComment(CommentDTO commentDTO);
    int deleteComment(long id);
    List<CommentDTO> selectAllCommentByMovieId(long movieId);
    List<CommentDTO> selectCommentByMemberId(long memberId);
    CommentDTO selectCommentByCommentId(long id);

    int updateGoodNumOneUpByCommentId(long id);
    int updateBadNumOneUpByCommentId(long id);
    ArrayList<CommentDTO> selectComment(Long member_id);
    ArrayList<Long> selectMovieId(Long member_id);
}
