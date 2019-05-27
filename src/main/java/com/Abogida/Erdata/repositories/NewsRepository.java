package com.Abogida.Erdata.repositories;
import org.springframework.data.repository.CrudRepository;

import com.Abogida.Erdata.domains.News;

public interface NewsRepository extends CrudRepository<News,Long> {

}
