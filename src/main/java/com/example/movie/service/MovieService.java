package com.example.movie.service;

import com.example.movie.dto.DailyMovieDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.repository.CommentRepository;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class MovieService {

    private final MovieRepository mr;
    private final OrderRepository or;
    private final CommentRepository cr;

    @Autowired
    public MovieService(MovieRepository mr, OrderRepository or, CommentRepository cr) {
        this.mr = mr;
        this.or = or;
        this.cr = cr;
    }

    public Integer selectDateInsertChk(){
        return mr.selectDateInsertChk();
    }

    public DailyMovieDTO selectMovieName(Long member_id) {
        if (or.selectMovieIdOne(member_id) == null) {
            return null;
        } else {
            Integer id = or.selectMovieIdOne(member_id).intValue();
            return mr.selectMovieName(id);
        }
    }

    public MovieDTO selectMovieImg(Long member_id) {
        if (or.selectMovieIdOne(member_id) == null) {
            return null;
        } else {
            Integer id = or.selectMovieIdOne(member_id).intValue();
            String str = mr.selectMovieImg(id).getMovieImg().split("\\|")[0];
            MovieDTO movie = mr.selectMovieImg(id);
            movie.setMovieImg(str);
            return movie;
        }
    }

    public ArrayList<DailyMovieDTO> selectMovieNames(Long member_id) {
        ArrayList<Long> ids = or.selectMovieIds(member_id);
        List<Integer> params = new ArrayList<>();
        ArrayList<DailyMovieDTO> movieList = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            params.add(ids.get(i).intValue());
            movieList.add(mr.selectMovieName(params.get(i)));
        }
        return movieList;
    }

    public ArrayList<MovieDTO> selectMovieImgs(Long member_id) {
        ArrayList<Long> ids = or.selectMovieIds(member_id);
        ArrayList<Integer> params = new ArrayList<>();
        ArrayList<MovieDTO> movie = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            params.add(ids.get(i).intValue());
            String str = mr.selectMovieImg(params.get(i)).getMovieImg().split("\\|")[0];
            MovieDTO movieDTO = mr.selectMovieImg(params.get(i));
            movieDTO.setMovieImg(str);
            movie.add(movieDTO);
        }
        return movie;
    }

    public ArrayList<DailyMovieDTO> selectCancelMovieNames(Long member_id) {
        ArrayList<Long> ids = or.selectCancelMovieIds(member_id);
        List<Integer> params = new ArrayList<>();
        ArrayList<DailyMovieDTO> movieList = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            params.add(ids.get(i).intValue());
            movieList.add(mr.selectMovieName(params.get(i)));
        }

        return movieList;
    }

    public int insertDailyMovie(DailyMovieDTO dailyMovieDTO) {
        return mr.insertDailyMovie(dailyMovieDTO);
    }

    public int insertMovieDetail(MovieDTO movieDTO) {
        return mr.insertMovieDetail(movieDTO);
    }

    public ArrayList<HashMap<String, Object>> selectDailyMovieCode() {
        return mr.selectDailyMovieCode();
    }

    public ArrayList<MovieDTO> selectMovieDtMovieNmDirNm(){
        return mr.selectMovieDtMovieNmDirNm();
    }
    public List<MovieDTO> selectAllMovies() { return mr.selectAllMovies(); }
    public MovieDTO selectMovieDetailByMovieCode(int movieCd) { return mr.selectMovieDetailByMovieCode(movieCd); }
    public Integer updateMvDtImgAndSummary(MovieDTO movieDTO){
        return mr.updateMvDtImgAndSummary(movieDTO);
    }
    public ArrayList<HashMap<String, String>> selectDailyRank(){
        return mr.selectDailyRank();
    }
    public List<DailyMovieDTO> selectMovieNameByCode(Long member_id) {
        ArrayList<Long> ids = cr.selectMovieId(member_id);
        List<Integer> params = new ArrayList<>();
        List<DailyMovieDTO> movie = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            params.add(ids.get(i).intValue());
            movie.add(mr.selectMovieNameByCode(params.get(i)));
        }

        return movie;
    }
}
