package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.UserEntity;


import java.util.List;

public interface UserService {
    UserEntity saveUser(UserEntity userEntity);
    List<UserEntity> fetchUserList();
    UserEntity updateUser(UserEntity userEntity, Long userId);
    void deleteUserById(Long userId);
}
