package com.haeyo.biz.board.impl;

import java.sql.Date;

import com.haeyo.biz.user.UserVO;

public class TogetherReplyVO {
	int trNo;
	int uNo;
	int tNo;
	String trContent;
	Date trCredate;
	UserVO userVO;
	
	public int getTrNo() {
		return trNo;
	}
	public void setTrNo(int trNo) {
		this.trNo = trNo;
	}
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	public int gettNo() {
		return tNo;
	}
	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	public String getTrContent() {
		return trContent;
	}
	public void setTrContent(String trContent) {
		this.trContent = trContent;
	}
	public Date getTrCredate() {
		return trCredate;
	}
	public void setTrCredate(Date trCredate) {
		this.trCredate = trCredate;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	@Override
	public String toString() {
		return "TogetherReplyVO [trNo=" + trNo + ", uNo=" + uNo + ", tNo=" + tNo + ", trContent=" + trContent
				+ ", trCredate=" + trCredate + ", userVO=" + userVO + "]";
	}
	
}
