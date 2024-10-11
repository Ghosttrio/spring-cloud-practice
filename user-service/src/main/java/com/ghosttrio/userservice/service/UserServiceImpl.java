package com.ghosttrio.userservice.service;

import com.ghosttrio.userservice.dto.UserDto;
import com.ghosttrio.userservice.entity.UserEntity;
import com.ghosttrio.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        userEntity.setEncryptedPwd("encrypted_PASS");
        userEntity.setEmail(userDto.getEmail());
        userEntity.setUserId("userId");
        userEntity.setName(userDto.getName());
        userRepository.save(userEntity);
        return null;
    }
}
