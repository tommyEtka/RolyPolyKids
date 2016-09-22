package com.GC.RolyPoly;
public class CraftInfo {
    private String link;
    private String imgSrc;
    private String title;
    private String favoritesTag;
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
    
    public String getFavoritesTag() {
		return favoritesTag;
	}
	public void setFavoritesTag(String favoritesTag) {
		this.favoritesTag = favoritesTag;
	}
	public CraftInfo(String link, String imgSrc, String title,String favoritesTag) {
        super();
        this.link = link;
        this.imgSrc = imgSrc;
        this.title = title;
        this.favoritesTag = favoritesTag;
    }
    // not sure if we need this one?
    public CraftInfo(String link, String imgSrc) {
        super();
        this.link = link;
        this.imgSrc = imgSrc;
    }
    // not sure if we need this one?
    public CraftInfo(String link) {
        super();
        this.link = link;
    }
    // not sure if we need this one?
    public CraftInfo() {
        super();
    }
}
