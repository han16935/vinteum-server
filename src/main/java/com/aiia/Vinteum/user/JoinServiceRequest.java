package com.aiia.Vinteum.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinServiceRequest {
    private String userId;
    private String password;

    @Builder
    private JoinServiceRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public static JoinServiceRequest of(String userId, String password){
        return JoinServiceRequest.builder()
                .userId(userId)
                .password(password)
                .build();
    }
}
