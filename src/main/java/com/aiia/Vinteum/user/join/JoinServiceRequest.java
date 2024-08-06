package com.aiia.Vinteum.user.join;

import com.aiia.Vinteum.user.User;
import lombok.*;

@Getter
@NoArgsConstructor
public class JoinServiceRequest {
    private String userId;
    private String password;
    private String name;

    @Builder
    private JoinServiceRequest(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }

    public static JoinServiceRequest of(String userId, String password, String name){
        return JoinServiceRequest.builder()
                .userId(userId)
                .password(password)
                .name(name)
                .build();
    }

    public User toUser(){
        return User.of(userId, password, name);
    }
}
