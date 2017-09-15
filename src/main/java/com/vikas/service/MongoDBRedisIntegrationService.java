package com.vikas.service;

import com.vikas.entity.Book;


/**
 * @author rajakolli
 * @version 0 : 5
 * @since July 2017
 *
 */
public interface MongoDBRedisIntegrationService {

   
    Long count();

   
    Book save(Book book);

  
    Book findBookByTitle(String title);

    
    Book updateByTitle(String title, String author);

  

}
