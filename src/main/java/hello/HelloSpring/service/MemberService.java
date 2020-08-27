package hello.HelloSpring.service;

import hello.HelloSpring.domain.Member;
import hello.HelloSpring.repository.MemberRepository;
import hello.HelloSpring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
//@Component
public class MemberService {
    private final MemberRepository memberRepository;

    //@Autowired //MemberService(MemberRepository memberRepository) 이거 두개를 연결시킴
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *
     * 회원 가입
     * 엥 글씨체 왜이래 왤케 귀여운거야
     */
    public Long join(Member member) {
        vaildateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void vaildateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     *
     * 전체 회원 조회
     *
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
