package message;

import java.util.Date;


public class Message_VO {

	private int msg_no; // 번호
	private String msg_wrt_id; // 보내는 사람 id
	private String msg_rec_id; // 받는 사람 id
	private String msg_content; // 내용
	private Date msg_regdate; // 보내는 날짜
	
	public int getMsg_no() {
		return msg_no;
	}
	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}
	public String getMsg_wrt_id() {
		return msg_wrt_id;
	}
	public void setMsg_wrt_id(String msg_wrt_id) {
		this.msg_wrt_id = msg_wrt_id;
	}
	public String getMsg_rec_id() {
		return msg_rec_id;
	}
	public void setMsg_rec_id(String msg_rec_id) {
		this.msg_rec_id = msg_rec_id;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Date getMsg_regdate() {
		return msg_regdate;
	}
	public void setMsg_regdate(Date msg_regdate) {
		this.msg_regdate = msg_regdate;
	}
	

}
