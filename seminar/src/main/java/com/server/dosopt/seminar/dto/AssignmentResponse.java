package com.server.dosopt.seminar.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AssignmentResponse {

    private int code;
    private String status;
    private boolean success;

    @Builder
    public AssignmentResponse(int code, String status, boolean success) {
        this.code = code;
        this.status = status;
        this.success = success;
    }
}
