package com.abogiida.erdata.repositories;

import org.springframework.data.repository.CrudRepository;

import com.abogiida.erdata.domains.Job;
import com.abogiida.erdata.security.Reciever;
import com.abogiida.erdata.domains.FreeAid;

public interface RecieverRepository extends CrudRepository<Reciever,Long> {
	Reciever findByUsername(String userName);
	Iterable<Job> findByJobs(Long id);
}
