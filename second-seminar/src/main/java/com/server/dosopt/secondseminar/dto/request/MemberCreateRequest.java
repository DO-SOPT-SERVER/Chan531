package com.server.dosopt.secondseminar.dto.request;

import com.server.dosopt.secondseminar.domain.SOPT;
import lombok.Data;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;
}
