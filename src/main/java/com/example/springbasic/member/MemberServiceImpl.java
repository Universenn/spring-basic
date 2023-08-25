package com.example.springbasic.member;

public class MemberServiceImpl implements MemberService{

    // DIP 위배
    // 나중에 저장소가 바뀔시 OCP 위배
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
