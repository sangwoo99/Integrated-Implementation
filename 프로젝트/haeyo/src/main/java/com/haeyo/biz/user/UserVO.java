package com.haeyo.biz.user;

public class UserVO {
	private int uNo;
	private String uName;
	private String uEmail;
	private String uPwd;
	private String uphone;
	private String uAddress;
	private int uAgreecheck;
	private String uPic;
	private String uNick;
	
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public int getuAgreecheck() {
		return uAgreecheck;
	}
	public void setuAgreecheck(int uAgreecheck) {
		this.uAgreecheck = uAgreecheck;
	}
	public String getuPic() {
		return uPic;
	}
	public void setuPic(String uPic) {
		this.uPic = uPic;
	}
	public String getuNick() {
		return uNick;
	}
	public void setuNick(String uNick) {
		this.uNick = uNick;
	}
	
	@Override
	public String toString() {
		return "UserVO [uNo=" + uNo + ", uName=" + uName + ", uEmail=" + uEmail + ", uPwd=" + uPwd + ", uphone="
				+ uphone + ", uAddress=" + uAddress + ", uAgreecheck=" + uAgreecheck + ", uPic=" + uPic + ", uNick="
				+ uNick + "]";
	}
}
