package com.vikas.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.vikas.entity.Book;
import com.vikas.repository.Bookrepository;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class MongoDBRedisIntegrationServiceImpl
        implements MongoDBRedisIntegrationService {

	@Autowired
    private  Bookrepository repository;
	@Autowired
    private  MongoTemplate mongoTemplate;

    private static final Logger logger = LoggerFactory.getLogger(MongoDBRedisIntegrationServiceImpl.class);
    
    public Long count() {
        return this.repository.count();
    }

   
    public Book save(Book book) {

    	logger.info("Saving book :{}", book);
        return this.repository.save(book);
    }

   
    public Book findBookByTitle(String title) {
    	logger.info("Finding Book by Title :{}", title);
        return this.repository.findByTitle(title);
    }

   public Book updateByTitle(String title, String author) {
	   logger.info("Updating Book Author by Title :{} with {}", title, author);
        final Query query = new Query(Criteria.where("title").is(title));
        final Update update = new Update().set("author", author);
        return this.mongoTemplate.findAndModify(query, update,
                new FindAndModifyOptions().returnNew(true).upsert(false), Book.class);
    }

 
  


	

}
