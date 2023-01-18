package com.example.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardDTO {

    private Long id;            // pk
    private Long member_id;     // member 테이블의 pk
    private String nickname;    // 닉네임
    private String title;       // 게시글 제목
    private String content;     // 게시글 내용
    private String indate;      // 게시글 생성일시

}
