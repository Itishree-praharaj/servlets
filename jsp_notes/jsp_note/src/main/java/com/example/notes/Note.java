package com.example.notes;

public class Note {
	 private static int count = 0;
	    private int id;
	    private String title;
	    private String content;

	    public Note() {
	        this.id = ++count;
	    }
	    public int getId() {
	        return id;
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
