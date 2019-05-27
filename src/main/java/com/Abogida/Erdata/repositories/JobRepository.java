package com.Abogida.Erdata.repositories;
import org.springframework.data.repository.CrudRepository;

import com.Abogida.Erdata.domains.Job;

public interface JobRepository extends CrudRepository<Job,Long> {

}
