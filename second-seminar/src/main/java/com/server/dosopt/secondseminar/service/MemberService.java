package com.server.dosopt.secondseminar.service;

import com.server.dosopt.secondseminar.domain.SOPT;
import com.server.dosopt.secondseminar.dto.request.MemberCreateRequest;
import com.server.dosopt.secondseminar.dto.request.MemberProfileUpdateRequest;
import com.server.dosopt.secondseminar.dto.request.MemberUpdateRequest;
import com.server.dosopt.secondseminar.dto.response.MemberGetResponse;
import com.server.dosopt.secondseminar.domain.entity.Member;
import com.server.dosopt.secondseminar.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getMemberByIdV1(Long id) {
        Member member = memberJpaRepository.findById(id).get();
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getMemberByIdV2(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다.")));
    }

    public MemberGetResponse getMemberByIdV3(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .toList();
    }

    @Transactional
    public String create(MemberCreateRequest request) {
        Member member =  memberJpaRepository.save(Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build());
        return member.getId().toString();
    }

    @Transactional
    public void updateMember(Long memberId, MemberUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateMember(request.name(), request.nickname(), request.age(), request.sopt());
    }

    @Transactional
    public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateSOPT(new SOPT(request.generation(), request.part()));
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }
}
