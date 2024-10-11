package com.ghosttrio.userservice.service;

import com.ghosttrio.userservice.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
