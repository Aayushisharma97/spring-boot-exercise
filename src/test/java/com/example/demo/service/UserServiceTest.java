package com.example.demo.service;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User userEntity;
    private UserRequestDto userRequestDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        userEntity = new User();
        userEntity.setId(1L);
        userEntity.setName("John Doe");
        userEntity.setEmail("john.doe@example.com");

        userRequestDto = new UserRequestDto();
        userRequestDto.setName("John Doe");
        userRequestDto.setEmail("john.doe@example.com");
    }

    @Test
    void createUser_ShouldReturnCreatedUser() {
        when(userRepository.save(any(User.class))).thenReturn(userEntity);

        UserResponseDto responseDto = userService.createUser(userRequestDto);

        assertNotNull(responseDto);
        assertEquals(userEntity.getId(), responseDto.getId());
        assertEquals(userEntity.getName(), responseDto.getName());
        assertEquals(userEntity.getEmail(), responseDto.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void getUserById_WhenUserExists_ShouldReturnUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        UserResponseDto responseDto = userService.getUserById(1L);

        assertNotNull(responseDto);
        assertEquals(userEntity.getId(), responseDto.getId());
        assertEquals(userEntity.getName(), responseDto.getName());
        assertEquals(userEntity.getEmail(), responseDto.getEmail());
    }

    @Test
    void getUserById_WhenUserNotFound_ShouldThrowException() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.getUserById(2L));
    }

    @Test
    void updateUser_WhenUserExists_ShouldReturnUpdatedUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        when(userRepository.save(any(User.class))).thenReturn(userEntity);

        UserResponseDto updatedDto = userService.updateUser(1L, userRequestDto);

        assertNotNull(updatedDto);
        assertEquals(userEntity.getId(), updatedDto.getId());
        assertEquals(userRequestDto.getName(), updatedDto.getName());
        assertEquals(userRequestDto.getEmail(), updatedDto.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void updateUser_WhenUserNotFound_ShouldThrowException() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.updateUser(2L, userRequestDto));
    }

    @Test
    void deleteUser_WhenUserExists_ShouldCallDelete() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        userService.deleteUser(1L);

        verify(userRepository, times(1)).delete(userEntity);
    }

    @Test
    void deleteUser_WhenUserNotFound_ShouldThrowException() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.deleteUser(2L));
    }

    @Test
    void searchUsers_ShouldReturnPageOfUserResponseDto() {
        List<User> users = List.of(userEntity);
        Pageable pageable = PageRequest.of(0, 10);
        Page<User> userPage = new PageImpl<>(users, pageable, users.size());

        when(userRepository.searchByNameOrEmail("john", pageable)).thenReturn(userPage);

        Page<UserResponseDto> resultPage = userService.searchUsers("john", pageable);

        assertNotNull(resultPage);
        assertEquals(1, resultPage.getTotalElements());
        assertEquals(userEntity.getId(), resultPage.getContent().get(0).getId());
    }
}
