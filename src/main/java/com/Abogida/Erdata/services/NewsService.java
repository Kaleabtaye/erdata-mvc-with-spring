package com.Abogida.Erdata.services;

import java.util.Optional;

import com.Abogida.Erdata.domains.News;

public interface NewsService {
	public News save(News news);
	public Iterable<News> saveAll(Iterable<News> news);

	Optional<News> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<News> findAll();

	Iterable<News> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(News news);
	
	void deleteAll(Iterable<News> news);

	void deleteAll();
}
