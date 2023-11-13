package com.server.dosopt.secondseminar.dto.request;

import com.server.dosopt.secondseminar.domain.SOPT;

public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {}
