package com.abogiida.erdata.repositories;
import org.springframework.data.repository.CrudRepository;

import com.abogiida.erdata.domains.Comment;

public interface CommentRepository extends CrudRepository<Comment,Long> {

}
