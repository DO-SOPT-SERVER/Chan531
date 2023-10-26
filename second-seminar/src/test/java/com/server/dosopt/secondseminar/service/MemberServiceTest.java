package com.server.dosopt.secondseminar.service;

import com.server.dosopt.secondseminar.domain.SOPT;
import com.server.dosopt.secondseminar.dto.request.MemberCreateRequest;
import com.server.dosopt.secondseminar.dto.request.MemberProfileUpdateRequest;
import com.server.dosopt.secondseminar.enums.Part;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("Record로 변경한 MemberCreateRequest가 잘 작동하는 지 확인")
    @Transactional
    void createMemberSuccessful() {
        // given
        MemberCreateRequest memberCreateRequest = new MemberCreateRequest(
                "남궁찬",
                "갓슈",
                24,
                new SOPT(33, Part.SERVER)
        );

        // when
        String id = memberService.create(memberCreateRequest);

        // then
        assertEquals("1", id);
    }

    @Test
    @DisplayName("Record로 변경한 MemberProfileUpdateRequest가 잘 작동하는 지 확인")
    @Transactional
    void updateMemberProfileSuccessful() {
        // given
        memberService.create(new MemberCreateRequest(
                        "남궁찬",
                        "갓슈",
                        24,
                        new SOPT(33, Part.SERVER)));
        MemberProfileUpdateRequest memberProfileUpdateRequest = new MemberProfileUpdateRequest(
                34,
                Part.IOS
        );

        // when
        memberService.updateSOPT(1L, memberProfileUpdateRequest);

        // then
        assertEquals(memberService.getMemberByIdV2(1L).soptInfo().getGeneration(), 34);
        assertEquals(memberService.getMemberByIdV2(1L).soptInfo().getPart(), Part.IOS);
    }
}