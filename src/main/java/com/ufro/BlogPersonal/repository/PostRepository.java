package com.ufro.BlogPersonal.repository;

import com.ufro.BlogPersonal.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}