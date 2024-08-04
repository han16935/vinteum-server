package com.aiia.Vinteum.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinServiceRequest {
    private String name;
    private String userId;
    private String password;

    @Builder
    private JoinServiceRequest(String name, String userId, String password) {
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

    public static JoinServiceRequest of(String name, String userId, String password){
        return JoinServiceRequest.builder()
                .name(name)
                .userId(userId)
                .password(password)
                .build();
    }
}
