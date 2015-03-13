package com.liberty.repositories;

import com.liberty.models.Book;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 12:40
 */
public interface BookRepository extends GraphRepository<Book> {
}
