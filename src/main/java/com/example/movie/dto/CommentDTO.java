package com.example.movie.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommentDTO {

    private Long id;
    private Long memberId;
    private Long movieId;
    private String content;
    private LocalDateTime indate;
    private int good;
    private int bad;

}