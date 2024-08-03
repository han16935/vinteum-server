package com.aiia.Vinteum;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_ID")
    private String userId;

    private String password;

    @Builder
    private User(Long id, String userId, String password) {
        this.id = id;
        this.userId = userId;
        this.password = password;
    }

    public static User of(String userId, String password){
        return User.builder()
                .userId(userId)
                .password(password)
                .build();
    }
}
