package com.GC.RolyPoly;

public class SEInfo {

    private String link;
    private String imgSrc;
    private String title;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public SEInfo(String link, String imgSrc, String title) {
		super();
		this.link = link;
		this.imgSrc = imgSrc;
		this.title = title;
	}
	public SEInfo(String link, String imgSrc) {
		super();
		this.link = link;
		this.imgSrc = imgSrc;
	}
	public SEInfo(String link) {
		super();
		this.link = link;

	}
	public SEInfo() {
		super();

	}


}
