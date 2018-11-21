package board.free;

/*�뒪�듃�읉痢�2�뒗 �떛湲��넠�뙣�꽩�씠 �븘�땶 POJO瑜� �궗�슜�븳�떎.*/

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
	private int commentcnt;

	private int ref;
	private int re_step;
	private int re_level;

	// get�쓣 �넻�빐 jsp媛숈� 怨녹쑝濡� �뜲�씠�꽣瑜� 蹂대궪 �닔 �엳�떎.
	// set�쓣 �넻�빐 form �뜲�씠�꽣 媛믪쓣 媛��졇���꽌 ���옣�븳�떎

	public int getRef() {
		return ref;
	}

	public int getCommentcnt() {
		return commentcnt;
	}

	public void setCommentcnt(int commentcnt) {
		this.commentcnt = commentcnt;
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
