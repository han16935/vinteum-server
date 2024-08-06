package com.aiia.Vinteum.user;

import com.aiia.Vinteum.ControllerTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends ControllerTestSupport {

    @DisplayName("회원가입할 수 있다.")
    @Test
    void join() throws Exception {
        // given
        JoinRequest request = JoinRequest.builder()
                .userId("userId")
                .password("password")
                .name("name")
                .build();

        // when // then
        mockMvc.perform(post("/user/join")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.message").value(HttpStatus.OK.name()));
    }

    @DisplayName("회원가입 시 ID를 입력해야 한다")
    @Test
    void join_emptyUserId() throws Exception {
        // given
        JoinRequest request = JoinRequest.builder()
                .password("password")
                .name("name")
                .build();

        // when // then
        mockMvc.perform(post("/user/join")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("400"))
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("ID는 필수입니다!"))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @DisplayName("회원가입 시 비밀번호를 입력해야 한다")
    @Test
    void join_emptyPassword() throws Exception {
        // given
        JoinRequest request = JoinRequest.builder()
                .userId("userId")
                .name("name")
                .build();

        // when // then
        mockMvc.perform(post("/user/join")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("400"))
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("비밀번호는 필수입니다!"))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @DisplayName("회원가입 시 이름을 입력해야 한다")
    @Test
    void join_emptyName() throws Exception {
        // given
        JoinRequest request = JoinRequest.builder()
                .userId("userId")
                .password("password")
                .build();

        // when // then
        mockMvc.perform(post("/user/join")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("400"))
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("이름은 필수입니다!"))
                .andExpect(jsonPath("$.data").isEmpty());
    }
}
