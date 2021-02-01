package com.survivingcodingbootcamp.blog.storage.repository;

import com.survivingcodingbootcamp.blog.model.Comment;
import com.survivingcodingbootcamp.blog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface commentRepository extends CrudRepository<Comment, Long> {
}
