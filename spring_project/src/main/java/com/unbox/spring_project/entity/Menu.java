package com.unbox.spring_project.entity;

public class Menu {
	
	private int idx;
	private String memID;
	private String title;
	private String content;
	private String wrtier;
	private String indate;
	private int count;
	
	public Menu() {}

	public Menu(int idx, String memID, String title, String content, String wrtier, String indate, int count) {
		this.idx = idx;
		this.memID = memID;
		this.title = title;
		this.content = content;
		this.wrtier = wrtier;
		this.indate = indate;
		this.count = count;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
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

	public String getWrtier() {
		return wrtier;
	}

	public void setWrtier(String wrtier) {
		this.wrtier = wrtier;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
