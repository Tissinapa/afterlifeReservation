package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.UserEntity;
import com.afterlife.reservation.Repositories.SeatRepository;
import com.afterlife.reservation.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity saveUser(UserEntity user){
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> fetchUserList(){
        return (List<UserEntity>) userRepository.findAll();
    }
    @Override
    public UserEntity updateUser(UserEntity user, Long userId){
        UserEntity userDB = userRepository.findById(userId).get();
        //name
        if(Objects.nonNull(user.getUsername()) && !"".equalsIgnoreCase(user.getUsername())){
            userDB.setUsername(user.getUsername());
        }
        //email
        if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())){
            userDB.setEmail(user.getEmail());
        }

        return userRepository.save(userDB);
    }
    @Override
    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }

}
