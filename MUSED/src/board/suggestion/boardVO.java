package board.suggestion;

/*스트럿츠2는 싱글톤패턴이 아닌 POJO를 사용한다.*/

import java.util.Date;

public class boardVO {

	  private int no;
	  private String subject;
	  private String name;
	  private String password;
	  private String content;
	  private int readhit;
	  private Date regdate;
	
	  private int ref;
	  private int re_step;
	  private int re_level;
	  
	  
	  //get을 통해 jsp같은 곳으로 데이터를 보낼 수 있다.
	  //set을 통해 form 데이터 값을 가져와서 저장한다
	  
	  public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public int getNo() {
		return no;
	}
	public String getSubject() {
		return subject;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getContent() {
		return content;
	}
	
	public int getReadhit() {
		return readhit;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	  
	  
}
