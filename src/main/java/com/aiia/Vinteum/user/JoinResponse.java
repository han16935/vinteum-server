package com.aiia.Vinteum.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinResponse {
    private String name;
    private String userId;

    @Builder
    private JoinResponse(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public static JoinResponse of(String name, String userId) {
        return JoinResponse.builder()
                .name(name)
                .userId(userId)
                .build();
    }
}
