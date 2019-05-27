package com.Abogida.Erdata.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Abogida.Erdata.domains.FreeAid;
import com.Abogida.Erdata.domains.News;
import com.Abogida.Erdata.repositories.FreeAidRepository;
import com.Abogida.Erdata.repositories.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {
	NewsRepository newsRepository;
	
	public NewsServiceImpl(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}
	@Override
	public News save(News news) {
		return newsRepository.save(news);
	}

	@Override
	public Iterable<News> saveAll(Iterable<News> news) {
		return newsRepository.saveAll(news);
	}

	@Override
	public Optional<News> findById(Long id) {
		return newsRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return newsRepository.existsById(id);
	}

	@Override
	public Iterable<News> findAll() {
		return newsRepository.findAll();
	}

	@Override
	public Iterable<News> findAllById(Iterable<Long> ids) {
		return newsRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return newsRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		newsRepository.deleteById(id);
		
	}

	@Override
	public void delete(News news) {
		newsRepository.delete(news);
		
	}

	@Override
	public void deleteAll(Iterable<News> news) {
		newsRepository.deleteAll(news);
		
	}

	@Override
	public void deleteAll() {
		newsRepository.deleteAll();
		
	}


}
