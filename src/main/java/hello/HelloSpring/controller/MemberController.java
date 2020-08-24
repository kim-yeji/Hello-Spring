package hello.HelloSpring.controller;

import hello.HelloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //스프링이 스프링 빈에 있는 거랑 연결을 시켜줌. MemberController(MemberService memberService)이거 두개
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
