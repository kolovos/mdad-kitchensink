package com.kitchensink.viewpager;

import java.io.Serializable;

public class Article implements Serializable {
	
	private static final long serialVersionUID = -2969209643481097941L;
	
	protected String title;
	protected String content;
	
	public Article(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
