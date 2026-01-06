package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository for User entity.
 *
 * <p>
 * Provides basic CRUD operations and a custom search query with pagination.
 * </p>
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Search users by name or email containing the keyword (case-insensitive).
     *
     * @param keyword  the search keyword
     * @param pageable pagination information
     * @return paginated list of users matching the keyword
     */
    @Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<User> searchByNameOrEmail(@Param("keyword") String keyword, Pageable pageable);
}
