/**
 * 
 */
package com.vikas.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.vikas.entity.Book;

/**
 * @author vikas.sivaravindran
 *
 */
public interface Bookrepository extends MongoRepository<Book, String> {
	
	
	Book findByTitle(String title);
	
	void delete(String title);

	void deleteById(String id);
	
	Optional<Book> findById(String id);
	
}
