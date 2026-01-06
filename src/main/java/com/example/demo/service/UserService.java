package com.example.demo.service;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service interface for managing Users.
 *
 * <p>
 * Defines all business operations related to Users.
 * </p>
 */
public interface UserService {

    /**
     * Create a new user.
     *
     * @param requestDto data for creating user
     * @return created user details
     */
    UserResponseDto createUser(UserRequestDto requestDto);

    /**
     * Get a user by ID.
     *
     * @param id user ID
     * @return user details
     */
    UserResponseDto getUserById(Long id);

    /**
     * Update an existing user.
     *
     * @param id         user ID
     * @param requestDto updated user data
     * @return updated user details
     */
    UserResponseDto updateUser(Long id, UserRequestDto requestDto);

    /**
     * Delete a user by ID.
     *
     * @param id user ID
     */
    void deleteUser(Long id);

    /**
     * Search users by keyword with pagination.
     *
     * @param keyword  search keyword
     * @param pageable pagination and sorting info
     * @return paginated list of users
     */
    Page<UserResponseDto> searchUsers(String keyword, Pageable pageable);
}
