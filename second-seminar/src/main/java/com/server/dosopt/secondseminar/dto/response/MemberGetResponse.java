package com.server.dosopt.secondseminar.dto.response;

import com.server.dosopt.secondseminar.SOPT;
import com.server.dosopt.secondseminar.entity.Member;

public record MemberGetResponse(
        String name,
        String nickname,
        int age,
        SOPT soptInfo
) {
    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}