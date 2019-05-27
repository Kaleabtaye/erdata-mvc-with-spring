package com.abogiida.erdata.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abogiida.erdata.domains.Job;
import com.abogiida.erdata.repositories.JobRepository;

@Service
public class JobServiceImpl implements JobService {

	JobRepository jobRepository;
	
	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}
	@Override
	public Job save(Job job) {
		return jobRepository.save(job);
	}

	@Override
	public Iterable<Job> saveAll(Iterable<Job> jobs) {
		return jobRepository.saveAll(jobs);
	}

	@Override
	public Optional<Job> findById(Long id) {
		return jobRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return jobRepository.existsById(id);
	}

	@Override
	public Iterable<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public Iterable<Job> findAllById(Iterable<Long> ids) {
		return jobRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return jobRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		jobRepository.deleteById(id);
		
	}

	@Override
	public void delete(Job job) {
		jobRepository.delete(job);
		
	}

	@Override
	public void deleteAll(Iterable<Job> jobs) {
		jobRepository.deleteAll(jobs);
		
	}

	@Override
	public void deleteAll() {
		jobRepository.deleteAll();
		
	}

}
