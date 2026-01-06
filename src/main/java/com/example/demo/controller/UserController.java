package com.example.demo.controller;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing users.
 *
 * <p>
 * Supports CRUD operations and search with pagination.
 * All business logic is delegated to the service layer.
 * </p>
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    // Explicit constructor for dependency injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user.
     *
     * @param requestDto user request data
     * @return created user details
     */
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto createdUser = userService.createUser(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * Get a user by ID.
     *
     * @param id user ID
     * @return user details
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        UserResponseDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Update an existing user.
     *
     * @param id         user ID
     * @param requestDto user update data
     * @return updated user details
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto requestDto) {
        UserResponseDto updatedUser = userService.updateUser(id, requestDto);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Delete a user by ID.
     *
     * @param id user ID
     * @return no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Search users by keyword with pagination and sorting.
     *
     * @param keyword  search keyword (name or email)
     * @param pageable pagination and sorting parameters
     * @return paged user results
     */
    @GetMapping("/search")
    public ResponseEntity<Page<UserResponseDto>> searchUsers(
            @RequestParam String keyword,
            Pageable pageable) {
        Page<UserResponseDto> result = userService.searchUsers(keyword, pageable);
        return ResponseEntity.ok(result);
    }
}
