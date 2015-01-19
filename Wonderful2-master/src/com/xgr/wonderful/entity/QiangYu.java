package com.xgr.wonderful.entity;

import java.io.Serializable;
import java.util.List;

import com.amap.api.location.core.GeoPoint;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobGeoPoint;
import cn.bmob.v3.datatype.BmobRelation;

public class QiangYu extends BmobObject implements Serializable{

	/**
	 * qiang yu entity,每个列表item内容
	 * 2014/4/27
	 */
	private static final long serialVersionUID = -6280656428527540320L;
	
	private User author;
	private String content;
	private List<BmobFile> Contentfigureurl;
	private int love;
	private int hate;
	private int share;
	private int comment;
	private boolean isPass;
	private boolean myFav;//收藏
	private boolean myLove;//赞
	private BmobRelation relation;
	private BmobGeoPoint  mGeoPoint;//坐标

	public BmobGeoPoint getGeopoint(){
		return mGeoPoint;
	}
	
	public void setGeopoint(BmobGeoPoint geoPoint){
		this.mGeoPoint=geoPoint;
	}
	
	public BmobRelation getRelation() {
		return relation;
	}
	public void setRelation(BmobRelation relation) {
		this.relation = relation;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<BmobFile> getContentfigureurl() {
		return Contentfigureurl;
	}
	public void setContentfigureurl(List<BmobFile> contentfigureurl) {
		Contentfigureurl = contentfigureurl;
	}
	public void addContentfigureurl(BmobFile contentfigureurl) {
		Contentfigureurl.add(contentfigureurl);
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public int getHate() {
		return hate;
	}
	public void setHate(int hate) {
		this.hate = hate;
	}
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public boolean isPass() {
		return isPass;
	}
	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}
	public boolean getMyFav() {
		return myFav;
	}
	public void setMyFav(boolean myFav) {
		this.myFav = myFav;
	}
	public boolean getMyLove() {
		return myLove;
	}
	public void setMyLove(boolean myLove) {
		this.myLove = myLove;
	}
	@Override
	public String toString() {
		return "QiangYu [author=" + author + ", content=" + content
				+ ", Contentfigureurl=" + Contentfigureurl + ", love=" + love
				+ ", hate=" + hate + ", share=" + share + ", comment="
				+ comment + ", isPass=" + isPass + ", myFav=" + myFav
				+ ", myLove=" + myLove +", Geopoint=" + mGeoPoint + ", relation=" + relation + "]";
	}
	
}
