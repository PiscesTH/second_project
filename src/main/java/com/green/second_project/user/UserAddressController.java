package com.green.second_project.user;

import com.green.second_project.common.ResVo;
import com.green.second_project.user.model.UserInsAddressDto;
import com.green.second_project.user.model.UserSelAddressVo;
import com.green.second_project.user.model.UserUpdAddressDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/address")
public class UserAddressController {
    private final UserService service;
    @GetMapping
    public List<UserSelAddressVo> getUserAddress() {
        return service.getUserAddress();
    }

    @PutMapping
    public ResVo putUserAddress(@RequestBody UserUpdAddressDto dto) {
        return service.putUserAddress(dto);
    }

    @PostMapping
    public ResVo postUserAddress(@RequestBody UserInsAddressDto dto){
        return service.postUserAddress(dto);
    }
}
