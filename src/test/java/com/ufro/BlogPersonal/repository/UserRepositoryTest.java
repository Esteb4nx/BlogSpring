package com.ufro.BlogPersonal.repository;

import com.ufro.BlogPersonal.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenSaved_thenFindById() {
        userRepository.save(new User("Bob", "bob@domain.com"));
        assertThat(userRepository.findById(1L)).isNotNull();
    }

}