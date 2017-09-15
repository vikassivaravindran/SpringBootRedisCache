/**
 * 
 */
package com.vikas.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;


/**
 * @author vikas.sivaravindran
 *
 */
@QueryEntity
@Document
public class Book implements Serializable{


	public Book() {
		// TODO Auto-generated constructor stub
	}

	@Id
	private String id;
	@Indexed
	private String title;
	
	private String author;
	
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Book(String id, String title, String author, String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
	}

	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description + "]";
	}

	
	
}
