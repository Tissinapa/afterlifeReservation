package com.afterlife.reservation;

import com.afterlife.reservation.Entities.UserEntity;
import com.afterlife.reservation.Repositories.UserRepository;
import com.afterlife.reservation.Services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceTests {
    /* Remember AAA kerho
    Arrange, act and assert
    *
    */
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void ShouldReturnUserWhenIdExists(){
        UserEntity user = new UserEntity("Kalle","kallen@email.com","hash",false);
        when(userRepository.save(any(UserEntity.class))).thenReturn(user);

        UserEntity savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertEquals("Kalle",savedUser.getUsername());
        verify(userRepository, times(1)).save(user); // learning how to do this

    }

    @Test
    void ShouldFetchAllWhenExists(){
        UserEntity user1 = new UserEntity("Matias","matiaksen@email.com","hash",false);
        UserEntity user2 = new UserEntity("Mätitahna","matitahnan@email.com","hash",false);

        when(userRepository.findAll()).thenReturn(List.of(user1,user2));

        List<UserEntity> users = userService.fetchUserList();

        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();

    }

    @Test
    void ShouldUpdateUserWhenIdExists(){
        Long userId = 1L;
        UserEntity existingUser = new UserEntity("oldSchool","oldschool@email.com","hash",false);
        existingUser.setUserId(userId);

        UserEntity updatedUser = new UserEntity();
        updatedUser.setUsername("NewSchool");
        updatedUser.setEmail("newschool@email.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));

        when(userRepository.save(any(UserEntity.class))).thenReturn(existingUser);

        UserEntity result = userService.updateUser(updatedUser, userId);

        assertEquals("NewSchool", result.getUsername());
        assertEquals("newschool@email.com", result.getEmail());

        verify(userRepository).findById(userId);
        verify(userRepository).save(existingUser);

    }
    @Test
    void shouldDeleteUserById(){
        Long userId = 1L;
        userService.deleteUserById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }

}
