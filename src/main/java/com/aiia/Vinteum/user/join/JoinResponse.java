package com.aiia.Vinteum.user.join;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinResponse {
    private String userId;
    private String name;

    @Builder
    private JoinResponse(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public static JoinResponse of(String userId, String name) {
        return JoinResponse.builder()
                .userId(userId)
                .name(name)
                .build();
    }
}
