package com.server.dosopt.secondseminar.dto.request;

import com.server.dosopt.secondseminar.Part;
import lombok.Data;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}
