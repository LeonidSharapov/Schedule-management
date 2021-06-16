package example.Controller.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Work {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String date;
private int userId;
private String sTime;
private String fTime;
private String naiyo;
private String work;
private String coments;
private String sTime2;
private String fTime2;
private String naiyo2;
private String work2;
private String coments2;

 public Work(){

}
 //only update
 public Work(Long id,String sTime,String fTime,String naiyo,String work,String coments,
		String sTime2,String fTime2,String naiyo2,String work2, String coments2){
	this.id=id;
	this.sTime=sTime;
	this.fTime=fTime;
	this.naiyo=naiyo;
	this.work=work;
	this.coments=coments;
	this.sTime2=sTime2;
	this.fTime2=fTime2;
	this.naiyo2=naiyo2;
	this.work2=work2;
	this.coments2=coments2;
}
public Work(String date,int userId){
	this.date=date;
	this.userId=userId;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getsTime() {
	return sTime;
}
public void setsTime(String sTime) {
	this.sTime = sTime;
}
public String getfTime() {
	return fTime;
}
public void setfTime(String fTime) {
	this.fTime = fTime;
}
public String getNaiyo() {
	return naiyo;
}
public void setNaiyo(String naiyo) {
	this.naiyo = naiyo;
}
public String getWork() {
	return work;
}
public void setWork(String work) {
	this.work = work;
}
public String getComents() {
	return coments;
}
public void setComents(String coments) {
	this.coments = coments;
}
public String getsTime2() {
	return sTime2;
}
public void setsTime2(String sTime2) {
	this.sTime2 = sTime2;
}
public String getfTime2() {
	return fTime2;
}
public void setfTime2(String fTime2) {
	this.fTime2 = fTime2;
}
public String getNaiyo2() {
	return naiyo2;
}
public void setNaiyo2(String naiyo2) {
	this.naiyo2 = naiyo2;
}
public String getWork2() {
	return work2;
}
public void setWork2(String work2) {
	this.work2 = work2;
}
public String getComents2() {
	return coments2;
}
public void setComents2(String coments2) {
	this.coments2 = coments2;
}
}