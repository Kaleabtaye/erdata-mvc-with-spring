package com.abogiida.erdata.services;

import java.util.Optional;

import com.abogiida.erdata.domains.FreeAid;

public interface FreeAidService {
	public FreeAid save(FreeAid freeAid);
	public Iterable<FreeAid> saveAll(Iterable<FreeAid> freeAid);

	Optional<FreeAid> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<FreeAid> findAll();

	Iterable<FreeAid> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(FreeAid freeAid);
	
	void deleteAll(Iterable<FreeAid> freeAid);

	void deleteAll();
}
