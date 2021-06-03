package com.fi9e.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="article")

/**
 * 
 * @author 
 *
 */
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="slug", columnDefinition = "CHAR(32)")
	private String slug;
	
	@Column(name="name")
	private String name;
	
	@Column(name="content")
	private String content;
	
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "category_id", nullable = true)
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createdAt;
	
	@Column(name="updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date updatedAt;
	
	public Article() {
		
	}

	public Article(String name, String slug, String content, int categoryId, java.util.Date createdAt, java.util.Date updatedAt) {
		super();
		this.name = name; 
		this.slug = slug;
		this.content = content;
		this.categoryId = categoryId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	/* public void setId(int id) {
		this.id = id;
	} */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategory() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(java.util.Date createdAt) {
		this.createdAt = createdAt;
	}

	public java.util.Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(java.util.Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Article {id:" + id
				+ ", slug:" + slug
				+ ", content:"+ content 
				+ ", createdAt:" + createdAt
				+ ", updatedAt:" + updatedAt + "}";
	}
}
