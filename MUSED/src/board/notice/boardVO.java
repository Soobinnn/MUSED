package board.notice;

/*스트럿츠2는 싱글톤패턴이 아닌 POJO를 사용한다.*/

import java.util.Date;

public class boardVO {

	  private int no;
	  private String subject;
	  private String name;
	  private String password;
	  private String content;
	  private String file_orgname;
	  private String file_savname;
	  private int readhit;
	  private Date regdate;
	
	  /*private int ref;
	  private int re_step;
	  private int re_level;
	  */
	  
	  //get을 통해 jsp같은 곳으로 데이터를 보낼 수 있다.
	  //set을 통해 form 데이터 값을 가져와서 저장한다
	  
	 
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
	public String getFile_orgname() {
		return file_orgname;
	}
	public String getFile_savname() {
		return file_savname;
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
	public void setFile_orgname(String file_orgname) {
		this.file_orgname = file_orgname;
	}
	public void setFile_savname(String file_savname) {
		this.file_savname = file_savname;
	}
	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	  
	  
}
