package com.vikas.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.ApplicationArguments;

import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.vikas.controller.BookController;
import com.vikas.entity.Book;


@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
    private BookController controller;

    /** {@inheritDoc} */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Long cnt = controller.count();
        if (cnt == 0) {
          /*  controller.deleteCache();*/
            final Book book = new Book();
            book.setTitle("MongoDbCookBook");
            book.setDescription("MongoDB Data Book");
            book.setAuthor("Raja");
            controller.saveBook(book);
        }
    }
}
