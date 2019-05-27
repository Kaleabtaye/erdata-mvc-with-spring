package com.abogiida.erdata.repositories;
import org.springframework.data.repository.CrudRepository;

import com.abogiida.erdata.domains.Job;

public interface JobRepository extends CrudRepository<Job,Long> {

}
