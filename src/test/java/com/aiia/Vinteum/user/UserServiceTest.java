package com.aiia.Vinteum.user;

import com.aiia.Vinteum.IntegrationTestSupport;
import com.aiia.Vinteum.user.join.JoinResponse;
import com.aiia.Vinteum.user.join.JoinServiceRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserServiceTest extends IntegrationTestSupport {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @AfterEach
    void tearDown() {
        userRepository.deleteAllInBatch();
    }

    @DisplayName("회원가입할 수 있다.")
    @Test
    void join_green() {
        // given
        JoinServiceRequest request = JoinServiceRequest.of("user1", "pw", "kim");

        // when
        JoinResponse response = userService.join(request);

        // then
        assertThat(response).extracting("userId", "name")
                .containsExactly("user1", "kim");
    }

    @DisplayName("중복된 ID로는 회원가입할 수 없다.")
    @Test
    void join_withDuplicateID() {
        // given
        User user1 = User.of("id1", "pw1", "kim");
        User user2 = User.of("id2", "pw1", "jung");
        User user3 = User.of("id3", "pw1", "choi");
        userRepository.saveAll(List.of(user1, user2, user3));

        JoinServiceRequest request = JoinServiceRequest.of("id1", "pw", "kim");

        // when // then
        assertThatThrownBy(() -> userService.join(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 ID입니다!");
    }
}