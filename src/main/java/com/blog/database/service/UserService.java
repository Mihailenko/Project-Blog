package com.blog.database.service;

import com.blog.database.domain.User;
import com.blog.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sergii Manko
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserRepository userRepository;

    public User findOne(final Long userId) {
        return userRepository.findOne(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Long add(final String name, final String login, final String password) {
        final User user = new User(name, login, password);
        return userRepository.save(user).getId();
    }
}
