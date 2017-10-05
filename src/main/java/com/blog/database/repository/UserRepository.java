package com.blog.database.repository;

import com.blog.database.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergii Manko
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
