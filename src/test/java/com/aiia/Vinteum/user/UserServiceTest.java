package com.aiia.Vinteum.user;

import com.aiia.Vinteum.IntegrationTestSupport;
import com.aiia.Vinteum.user.join.JoinResponse;
import com.aiia.Vinteum.user.join.JoinServiceRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest extends IntegrationTestSupport {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @DisplayName("회원가입할 수 있다.")
    @Test
    void join_green() {
        // given
        JoinServiceRequest request = JoinServiceRequest.of("kim", "user1", "pw");

        // when
        JoinResponse response = userService.join(request);

        // then
        assertThat(response).extracting("name", "userId")
                .containsExactly("kim", "user1");
    }
}