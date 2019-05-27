package com.abogiida.erdata.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abogiida.erdata.domains.Comment;
import com.abogiida.erdata.repositories.CommentRepository;
@Service
public class CommentServiceImpl implements CommentService {
	CommentRepository commentRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public Iterable<Comment> saveAll(Iterable<Comment> comment) {
		return commentRepository.saveAll(comment);
	}

	@Override
	public Optional<Comment> findById(Long id) {
		return commentRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return commentRepository.existsById(id);
	}

	@Override
	public Iterable<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public Iterable<Comment> findAllById(Iterable<Long> ids) {
		return commentRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return commentRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		commentRepository.deleteById(id);
		
	}

	@Override
	public void delete(Comment comment) {
		commentRepository.delete(comment);
		
	}

	@Override
	public void deleteAll(Iterable<Comment> comment) {
		commentRepository.deleteAll(comment);
		
	}

	@Override
	public void deleteAll() {
		commentRepository.deleteAll();
		
	}

}
