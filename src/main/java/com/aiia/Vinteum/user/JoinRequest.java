package com.aiia.Vinteum.user;

import com.aiia.Vinteum.user.join.JoinServiceRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinRequest {

    @NotBlank(message = "ID는 필수입니다!")
    private String userId;

    @NotBlank(message = "비밀번호는 필수입니다!")
    private String password;
    @NotBlank(message = "이름은 필수입니다!")
    private String name;

    @Builder
    public JoinRequest(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }

    public JoinServiceRequest toServiceRequest() {
        return JoinServiceRequest.of(userId, password, name);
    }
}
