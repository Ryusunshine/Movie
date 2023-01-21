package com.example.movie.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TheaterDTO {
    private Long id;
    private String selectedTheater;
    private Float latitude;
    private Float longitude;
    private String theaterDetail;
    private String seats;
    private String movieName; //ReserveDTO
    private String movieDate; //ReserveDTO
    private String movieTime;
}
