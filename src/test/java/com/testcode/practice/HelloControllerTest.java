package com.testcode.practice;

import com.testcode.practice.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다.
        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) // 200인지 아닌지
                .andExpect(content().string(hello));    // 리턴하는 값이 맞는지 => hello 인지
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        /*
        param
        - API 테스트 할 때 사용될 요청 파라미터를 설정
        - 단, 값은 String만 허용
        - 그래서 문자열로 변경해야함
        * */
        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name", is(name)))
                        .andExpect(jsonPath("$.amount", is(amount))
        );
        /*
        jsonPath
        - JSON 응답값을 필드별로 검증할 수 있는 메소드
        - $를 기준으로 필드명을 명시
        - 여기서는 name과 amount를 검증하니 $.name, $.amount로 검증
        * */
    }
}
