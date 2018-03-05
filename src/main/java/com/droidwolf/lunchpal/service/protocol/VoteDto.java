package com.droidwolf.lunchpal.service.protocol;

import java.util.UUID;

public class VoteDto {
    private UUID userId;

    public VoteDto(UUID userId) {
        this.userId = userId;
    }

    public VoteDto() {
    }

    public UUID getUserId() {
        return userId;
    }
}
