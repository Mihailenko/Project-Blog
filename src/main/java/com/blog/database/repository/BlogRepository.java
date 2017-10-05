package com.blog.database.repository;

import com.blog.database.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mikhailenko Mikhail
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
