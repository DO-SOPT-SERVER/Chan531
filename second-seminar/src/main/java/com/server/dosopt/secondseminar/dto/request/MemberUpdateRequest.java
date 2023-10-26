package com.server.dosopt.secondseminar.dto.request;

import com.server.dosopt.secondseminar.domain.SOPT;

public record MemberUpdateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {}
