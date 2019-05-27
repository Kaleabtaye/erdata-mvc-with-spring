package com.Abogida.Erdata.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Abogida.Erdata.domains.FreeAid;
import com.Abogida.Erdata.repositories.FreeAidRepository;

@Service
public class FreeAidServiceImpl implements FreeAidService {
	FreeAidRepository freeAidRepository;
	
	public FreeAidServiceImpl(FreeAidRepository freeAidRepository) {
		this.freeAidRepository = freeAidRepository;
	}
	@Override
	public FreeAid save(FreeAid freeAid) {
		return freeAidRepository.save(freeAid);
	}

	@Override
	public Iterable<FreeAid> saveAll(Iterable<FreeAid> freeAid) {
		return freeAidRepository.saveAll(freeAid);
	}

	@Override
	public Optional<FreeAid> findById(Long id) {
		return freeAidRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return freeAidRepository.existsById(id);
	}

	@Override
	public Iterable<FreeAid> findAll() {
		return freeAidRepository.findAll();
	}

	@Override
	public Iterable<FreeAid> findAllById(Iterable<Long> ids) {
		return freeAidRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return freeAidRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		freeAidRepository.deleteById(id);
		
	}

	@Override
	public void delete(FreeAid freeAid) {
		freeAidRepository.delete(freeAid);
		
	}

	@Override
	public void deleteAll(Iterable<FreeAid> freeAid) {
		freeAidRepository.deleteAll(freeAid);
		
	}

	@Override
	public void deleteAll() {
		freeAidRepository.deleteAll();
		
	}

}
