package com.abogiida.erdata.services;

import java.util.Optional;

import com.abogiida.erdata.domains.Job;

public interface JobService {
	public Job save(Job job);
	public Iterable<Job> saveAll(Iterable<Job> jobs);

	Optional<Job> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Job> findAll();

	Iterable<Job> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Job job);
	
	void deleteAll(Iterable<Job> jobs);

	void deleteAll();
}
