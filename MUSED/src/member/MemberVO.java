package member;

import java.util.Date;

public class MemberVO {
	
	private String id;
	private String name;
	private String password;
	private int jumin1;
	private int jumin2;
	private String sex;
	private String email;
	private String phone;
	private String zipcode;
	private String address1;
	private String address2;
	private Date joindate;
	private int access_num;
	private int score;
	private int logincount;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getJumin1() {
		return jumin1;
	}
	public void setJumin1(int jumin1) {
		this.jumin1 = jumin1;
	}
	public int getJumin2() {
		return jumin2;
	}
	public void setJumin2(int jumin2) {
		this.jumin2 = jumin2;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public int getAccess_num() {
		return access_num;
	}
	public void setAccess_num(int access_num) {
		this.access_num = access_num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLogincount() {
		return logincount;
	}
	public void setLogincount(int logincount) {
		this.logincount = logincount;
	}
	
	

}
