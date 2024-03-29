package com.green.second_project.user;

import com.green.second_project.common.ResVo;
import com.green.second_project.user.model.UserDelAddressDto;
import com.green.second_project.user.model.UserInsAddressDto;
import com.green.second_project.user.model.UserSelAddressVo;
import com.green.second_project.user.model.UserUpdAddressDto;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResVo postUserAddress(@Valid @RequestBody UserInsAddressDto dto){
        return service.postUserAddress(dto);
    }

    @GetMapping
    public List<UserSelAddressVo> getUserAddress() {
        return service.getUserAddress();
    }

    @PutMapping
    public ResVo putUserAddress(@Valid @RequestBody UserUpdAddressDto dto) {
        return service.putUserAddress(dto);
    }

    @DeleteMapping
    public ResVo delUserAddress(UserDelAddressDto dto) {
        return service.delUserAddress(dto);
    }
}
