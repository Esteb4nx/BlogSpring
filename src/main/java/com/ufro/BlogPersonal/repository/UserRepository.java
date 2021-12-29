package com.ufro.BlogPersonal.repository;

import com.ufro.BlogPersonal.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}