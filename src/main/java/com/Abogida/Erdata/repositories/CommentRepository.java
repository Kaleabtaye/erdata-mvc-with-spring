package com.Abogida.Erdata.repositories;
import org.springframework.data.repository.CrudRepository;

import com.Abogida.Erdata.domains.Comment;

public interface CommentRepository extends CrudRepository<Comment,Long> {

}
