package com.example.movie.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketDTO implements Serializable {
	private Long id;
	private Long memberId; //회원 아이디
	private String movieTitle; //영화 제목
	private String movieDate; //영화 상영 날짜
	private String movieStartTime; //영화 시작 시간
	private String selectedTheater; //극장
	private String theaterDetail; //극장 정보
	private String ticketNumber; //티켓 개수
	private String selectedSeat; //자리 정보
	private String payMoney; //결제 금액
	private String payDate; //결제 날짜
	private String orderStatus; // 결제 여부
}