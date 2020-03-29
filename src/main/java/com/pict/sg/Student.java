package com.pict.sg;

public class Student {
	String id;
	int rollno;
	String fName,lName,uname,pwd;
	String _Class;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String get_Class() {
		return _Class;
	}
	public void set_Class(String _Class) {
		this._Class = _Class;
	}
		public String toString()
	{
		return this._Class+" "+this.fName+" " +this.lName;
		
	}
	
}
