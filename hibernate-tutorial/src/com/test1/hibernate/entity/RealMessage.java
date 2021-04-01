package com.test1.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="real_message")
public class RealMessage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="message")
	private String messageText;
	
	@Column(name="author")
	private String author;
	
	@Column(name="server")
	private String server;
	
	@Column(name="channel")
	private String channel;
	
	public RealMessage() {
		
	}

	public RealMessage(String messageText, String author, String server, String channel) {
		super();
		this.messageText = messageText;
		this.author = author;
		this.server = server;
		this.channel = channel;
	}

	
	
	public int getId() {
		return id;
	}

	/*public void setId(int id) {
		this.id = id;
	}*/

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "RealMessage [id=" + id + ", messageText=" + messageText + ", author=" + author + ", server=" + server
				+ ", channel=" + channel + "]";
	}
}
