package com.example.movie.repository;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.TicketDTO;
import com.example.movie.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {

	private final TicketMapper mapper;

	@Autowired public TicketRepository(TicketMapper mapper) {
		this.mapper = mapper;
	}

	public int insertTicket(TicketDTO dto) {
		return mapper.insertTicket(dto);
	}

	public int updateTicket(Long id){
		return mapper.updateTicket(id);
	}

	public List<MovieDTO> getMovieList(){
		return mapper.getMovieList();
	}

	public MovieDTO getMovieDTO(String movieTitle){return mapper.getMovieDTO(movieTitle);}

	public TicketDTO getTicket() { return mapper.getTicket();}

	public List<TicketDTO> getTicketList(String userId) { return mapper.getTicketList(userId);}

	public TicketDTO selectOrderById(Long member_id) {
		return mapper.selectOrderById(member_id);
	}

	public ArrayList<TicketDTO> selectOrderByMember(Long member_id) {
		return mapper.selectOrderByMember(member_id);
	}

	public ArrayList<TicketDTO> selectCancelOrder(Long member_id) {
		return mapper.selectCancelOrder(member_id);
	}

	public int updateOrderStatus(Long id) {
		return mapper.updateOrderStatus(id);
	}
}
