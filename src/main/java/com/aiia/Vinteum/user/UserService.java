package com.aiia.Vinteum.user;

import com.aiia.Vinteum.user.join.JoinResponse;
import com.aiia.Vinteum.user.join.JoinServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public JoinResponse join(JoinServiceRequest req){
        if(userRepository.existsByName(req.getName())){
            throw new IllegalArgumentException("중복된 ID입니다!");
        }

        User begineer = req.toUser();

        User savedUser = userRepository.save(begineer);

        return savedUser.toJoinResponse();
    }


}
