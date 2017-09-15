/**
 * 
 */
package com.vikas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.entity.Book;
import com.vikas.repository.Bookrepository;
import com.vikas.service.MongoDBRedisIntegrationService;

import lombok.RequiredArgsConstructor;

/**
 * @author vikas.sivaravindran
 *
 */
@RestController
@RequestMapping(value="/api")
@RequiredArgsConstructor
public class BookController {

	@Autowired
	private Bookrepository bookrepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private MongoDBRedisIntegrationService service;
	
	
	@RequestMapping(value="/save/book" , method=RequestMethod.POST)
	public Book saveBook(@RequestBody Book book){
		System.out.println("Book "+book.toString());
		return service.save(book);
	
	}
	
	@RequestMapping(value="/get/book/{title}" , method=RequestMethod.GET)
	@CachePut(value = "book", key = "#title")
	public Book findBookByTitle(@PathVariable("title")String title){
		
		return service.findBookByTitle(title);
		
	}
	
	 @RequestMapping(value = "/update/{title}/{author}",method = RequestMethod.PUT)
	    @CachePut(value = "book", key = "#title")
	    public Book updateAuthorByTitle(@PathVariable("title") String title,
	            @PathVariable("author") String author) {
	        return service.updateByTitle(title, author);
	    }

/*	 @RequestMapping(value = "/delete/{title}" , method=RequestMethod.DELETE)
	    @CacheEvict(value = "book", key = "#title")
	    public String deleteBookByTitle(@PathVariable(value = "title") String title) {
	        final Book book = this.findBookByTitle(title);
	        if (null != book) {
	            this.service.deleteBook(book.getId());
	            return "Book with title " + title + " deleted";
	        } else {
	            return "Book with title " + title + " Not Found";
	        }
	    }
	 
	 
	 @RequestMapping(value = "/deleteCache" , method=RequestMethod.GET)
	    @CacheEvict(value = "book", allEntries = true)
	    public void deleteCache() {
	        this.service.deleteAllCache();
	    }
	*/

	public Long count() {
		// TODO Auto-generated method stub
		   return this.service.count();
	}


	 
	/* public void deleteAll() {
	        this.service.deleteAllCollections();
	    }*/
}
