package com.testcode.practice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    /*
    * 머스테치 스터터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와
    * 뒤의 파일 확장자는 자동으로 지정된다. 앞의 경로는 src/main/resources/templates로,
    * 뒤의 파일 확장자는 .mustache가 붙는다.
    * src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리하게 됨.
    * */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
