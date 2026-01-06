package com.example.demo.service.impl;

import com.example.demo.dto.OrderResponseDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Implementation of UserService.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Explicit constructor injection (no Lombok)
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        User saved = userRepository.save(user);
        return mapToDto(saved);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return mapToDto(user);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto requestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        User updated = userRepository.save(user);
        return mapToDto(updated);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepository.delete(user);
    }

    @Override
    public Page<UserResponseDto> searchUsers(String keyword, Pageable pageable) {
        Page<User> users = userRepository.searchByNameOrEmail(keyword, pageable);
        return users.map(this::mapToDto);
    }

    /**
     * Maps User entity to UserResponseDto.
     */
    private UserResponseDto mapToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        if (user.getOrders() != null) {
            dto.setOrders(user.getOrders().stream()
                    .map(order -> {
                        OrderResponseDto orderDto = new OrderResponseDto();
                        orderDto.setId(order.getId());
                        orderDto.setProduct(order.getProduct());
                        return orderDto;
                    })
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}
