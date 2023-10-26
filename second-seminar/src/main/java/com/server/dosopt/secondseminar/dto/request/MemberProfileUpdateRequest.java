package com.server.dosopt.secondseminar.dto.request;

import com.server.dosopt.secondseminar.enums.Part;

public record MemberProfileUpdateRequest(
        int generation,
        Part part
) {}
