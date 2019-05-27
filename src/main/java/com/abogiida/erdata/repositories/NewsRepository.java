package com.abogiida.erdata.repositories;
import org.springframework.data.repository.CrudRepository;

import com.abogiida.erdata.domains.News;

public interface NewsRepository extends CrudRepository<News,Long> {

}
