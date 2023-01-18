//package com.example.movie.controller;
//
//import com.example.movie.dto.MovieDTO;
//import com.example.movie.service.MovieService;
//import org.junit.jupiter.api.*;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.servlet.http.HttpSession;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//public class MovieControllerTest {
//
//    private MockMvc mockMvc;
//
////    @Mock
////    HttpSession session;
//
//    protected MockHttpSession session;
//
//    @Mock
//    private MovieService movieService;
//
//    @InjectMocks
//    private MovieController movieController;
//
//    @BeforeEach
//    void setUp(@Autowired MovieController movieController) {
//        // MockMvc
//        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
//        session = new MockHttpSession();
//        session.setAttribute("email","test01");  // 실제 있는 것으로 하기 !!
//    }
//
//    @AfterEach
//    public void clean(){
//        session.clearAttributes(); //테스트 이후 세션 초기화
//    }
//
//    @Test
//    @DisplayName("Movie Controller selectAllMoviesTest 테스트")
//    void selectAllMoviesTest() {
//
//        // given import 해주기
//        // LocalDate 채워주기
//
//        MovieDTO movieDTO = new MovieDTO(3, "영화제목한글", "영화제목영문", 130, null , "임의", "임의", "임의", "임의", "임의", "임의", "임의", "임의", "임의");
//
//        List<MovieDTO> result = new ArrayList<>();
//        result.add(movieDTO);
//
//        // 조건 : 무엇을 호출하면 무엇을 돌려준다.
//        given(movieController.selectAllMovies()).willReturn(result);
////        given(movieController.selectAllMovies(session)).willReturn(result);
//
//        List<MovieDTO> testResult = movieController.selectAllMovies();
////        List<MovieDTO> testResult = movieController.selectAllMovies(session);
//
//        Assertions.assertEquals("3", testResult.get(3).getMovieCd());
//
//    }
//
//    // MockMVC 사용하는 방법
//    @Test
//    @Transactional
//    void movieDeleteTest() throws Exception {
//        mockMvc.perform(delete("/schedules/10")) //호출 url
//                .andExpect(status().isOk()) //결과 200(정상) 호출이 되어야함
//                .andExpect(content().string("success")) //응답이 "success"로 나와야함
//                .andDo(print()); //출력
//    }
//
//    // 세션&파라미터 이용 방법 (필드 추가)
//    @Test
//    @Transactional
//    void movieSelectTest() throws Exception {
//
//        // 이 부분 강사님 수업 코드로 바꾸기 !!!!!!
////        mockMvc.perform(get("/schedules")) //호출 url
////                .andExpect(status().isOk()) //결과 200(정상) 호출이 되어야함
////                .andExpect(content().string("success")) //응답이 "success"로 나와야함
////                .andDo(print()); //출력
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/schedules")
//                        .session(session)
//                        .param("params", "example"))
//                        .param("params2", "example2"))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//}
