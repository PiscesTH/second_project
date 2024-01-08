package com.green.second_project.user;

import com.green.second_project.common.ResVo;
import com.green.second_project.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public ResVo postSignin(UserSigninDto dto){
        int insUserResult = userMapper.insUser(dto);
        int insAddressResult = userMapper.insUserAddress(dto);
        return new ResVo(dto.getIuser());
    }
}
