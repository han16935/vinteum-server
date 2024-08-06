package com.aiia.Vinteum.user;

import com.aiia.Vinteum.api.ApiResponse;
import com.aiia.Vinteum.user.join.JoinResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ApiResponse<JoinResponse> join(@Valid @RequestBody JoinRequest request){
        return ApiResponse.success(userService.join(request.toServiceRequest()));
    }
}
