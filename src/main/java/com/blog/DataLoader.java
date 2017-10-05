package com.blog;

import com.blog.database.domain.User;
import com.blog.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergii Manko
 */
@Component
@Profile("dev")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataLoader implements ApplicationRunner {
    private final UserRepository userRepository;
    private final List<User> users = new ArrayList<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        insertUsers();
    }

    private void insertUsers() {
        users.add(new User("Ivan", "user", "123456"));
        userRepository.save(users);
    }
}
