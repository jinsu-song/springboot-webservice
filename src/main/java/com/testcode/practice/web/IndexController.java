package com.testcode.practice.web;

import com.testcode.practice.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    /*
    * 머스테치 스터터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와
    * 뒤의 파일 확장자는 자동으로 지정된다. 앞의 경로는 src/main/resources/templates로,
    * 뒤의 파일 확장자는 .mustache가 붙는다.
    * src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리하게 됨.
    * */
    @GetMapping("/")
    public String index(Model model) {
        /*
         * Model
         * 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
         * 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달
         * */
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
