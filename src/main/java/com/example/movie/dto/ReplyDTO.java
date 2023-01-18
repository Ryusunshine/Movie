package com.example.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReplyDTO {

    private Long id;            // pk
    private Long member_id;     // member 테이블의 pk
    private Long board_id;      // board 테이블의 pk
    private String nickname;    // 닉네임
    private String content;     // 리플 내용
    private String indate;      // 리플 생성일시

}
