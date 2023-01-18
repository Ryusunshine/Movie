package com.example.movie.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {

    private Long id;
    private Long member_id;
    private Long theater_id;
    private Long movie_id;
    private String seat;
    private boolean orderStatus;
    private String screenDate;
    private int ticketCount;
    private int totalPrice;
    private String indate;

}