package com.server.dosopt.secondseminar.dto.request;

import com.server.dosopt.secondseminar.SOPT;
import lombok.Data;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;
}
