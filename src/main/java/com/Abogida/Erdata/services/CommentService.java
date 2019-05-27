package com.Abogida.Erdata.services;

import java.util.Optional;

import com.Abogida.Erdata.domains.Comment;

public interface CommentService {
	public Comment save(Comment comment);
	public Iterable<Comment> saveAll(Iterable<Comment> comment);

	Optional<Comment> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Comment> findAll();

	Iterable<Comment> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Comment comment);
	
	void deleteAll(Iterable<Comment> comment);

	void deleteAll();
}
