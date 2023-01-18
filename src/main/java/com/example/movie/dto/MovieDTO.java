package com.example.movie.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MovieDTO {

    private int movieCd;             // 영화코드 (DB와 같이 int 로 수정함)
    private String movieNm;          // 영화제목(국문)
    private String movieNmEn;        // 영화제목(영문)
    private String cmpMovieNm;       // 영화제목(영문) 공백, 특수문자 제거. api 가져올 시에 비교 위함.
    private String prdtYear;         // 제작연도
    private int showtime;            // 상영시간(러닝타임)
    private LocalDate openDt;        // 개봉일
    private String typeNm;           // 영화 유형명
    private String nationNm;         // 제작 국가
    private String genreNm;          // 장르명
    private String directorNm;       // 감독명
    private String directorNmEn;     // 감독명(영문)
    private String companyNm;        // 배급사
    private String watchGradeNm;     // 관람등급
    private String movieImg;         // 영화 포스터 url
    private String actorNm;          // 배우(국문)
    private String actorNmEn;        // 배우(영문)
    private String summary;          // 영화 줄거리

}
